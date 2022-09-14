package com.doranco.tp_expenses

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class ExpensesViewModel:ViewModel() {

    val state = mutableStateOf(emptyList<Expense>())
    private var restInterface: ExpensesApiService

    private val errorHandler = CoroutineExceptionHandler { _, exception ->
        exception.printStackTrace()
    }

    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .baseUrl(
                "https://avid-racer-241421.firebaseio.com/"
            )
            .build()
        restInterface = retrofit.create(
            ExpensesApiService::class.java
        )
        getExpenses()
    }

    private suspend fun getRemoteExpenses() : List<Expense> {
        return withContext(Dispatchers.IO){
            restInterface.getExpenses()
        }
    }

    private fun getExpenses() {
        viewModelScope.launch(errorHandler) {
            val expenses = getRemoteExpenses()
            state.value = expenses
        }
    }

    private suspend fun totalPrice(): Double {
        var total: Double = 0.0

        getRemoteExpenses().forEach {
            total +=  it.price
        }
        return total
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private suspend fun selectDate(){
        val dateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val today: LocalDate = LocalDate.now(ZoneId.of("Europe/Paris"))
        val pastWeek: LocalDate = today.minusWeeks( 1 )

        getRemoteExpenses().forEach {
            var expenseDate = LocalDate.parse(it.date, dateTimeFormatter)
            if (expenseDate.isAfter(pastWeek))
                getExpenses()
        }
    }
}