package com.doranco.tp_expenses

import com.google.gson.annotations.SerializedName

data class Expense(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("price")
    val price: Double)

