package com.doranco.tp_expenses

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
}



    /*
    val expenses = state.value.toMutableList()

    fun totalPrice(): Double {
        var total: Double = 0.0
        expenses.forEach {
            total +=  it.price
        }
        return total
    }
/*
    fun selectDate(): String {
        val dateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        var dateSelection: String = ""

        expenses.sortedByDescending {
            LocalDate.parse(it, dateTimeFormatter)

        expenses.forEach {
            if (dateSelection )

        }
        return dateSelection
    }

 */

}
*/











