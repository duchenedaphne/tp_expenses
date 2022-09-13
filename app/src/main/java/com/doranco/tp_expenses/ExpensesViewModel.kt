package com.doranco.tp_expenses

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ExpensesViewModel:ViewModel() {

    val state = mutableStateOf(dummyExpenses)

    val expenses = state.value.toMutableList()

    fun totalPrice(price : Double) {
        expenses
    }

}