package com.doranco.tp_expenses

data class Expense(val id: Int, val title: String, val date: String, val price: Double)

val dummyExpenses = listOf(
    Expense(0, "A book", "2022-2-19", 14.99),
    Expense(1, "Another book", "2022-2-18", 18.59),
    Expense(2, "Pizza John", "2022-2-19", 14.99),
    Expense(3, "Dinner in the clouds", "2022-2-18", 18.59),
)