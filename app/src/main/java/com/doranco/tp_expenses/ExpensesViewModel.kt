package com.doranco.tp_expenses

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

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

    fun selectDate(): String {
        var dateSelection: String = ""
        expenses.forEach {
            dateSelection
        }
        return dateSelection
    }

}












