package com.doranco.tp_expenses

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ExpensesViewModel:ViewModel() {

    val state = mutableStateOf(dummyExpenses)

    fun totalPrice(price : Double) {
        val expenses = state.value.toMutableList()
    /*
        val itemIndex = expenses.indexOfFirst { it.id == id }
        val item = expenses[itemIndex]
        state.value = expenses
*/
    }

}