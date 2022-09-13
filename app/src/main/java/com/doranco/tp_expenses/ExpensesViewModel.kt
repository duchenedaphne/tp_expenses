package com.doranco.tp_expenses

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class ExpensesViewModel:ViewModel() {

    val state = mutableStateOf(dummyExpenses)

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












