package com.doranco.tp_expenses

import retrofit2.http.GET

interface ExpensesApiService {
    @GET("expenses.json")
    suspend fun getExpenses(): List<Expense>
}