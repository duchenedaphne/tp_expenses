package com.doranco.tp_expenses

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.magnifier
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Preview(showBackground = true)
@Composable
fun ExpensesScreen() {
    val viewModel: ExpensesViewModel = viewModel()
    LazyColumn(contentPadding = PaddingValues(vertical = 8.dp, horizontal = 8.dp)) {
        items(viewModel.state.value) { expense ->
            ExpenseItem(expense),
            filter ->
            FilterItem(filter)
        }
    }
}

@Composable
fun FilterItem(item: Filter) {
    Card(elevation = 4.dp, modifier = Modifier.padding(8.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)) {
            FilterDetails(item.time, item.currency, item.total, Modifier.weight(0.85f))
        }
    }
}

@Composable
fun FilterDetails(time: String, currency: String, total: Double, modifier: Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
        Column(modifier = modifier) {
            Text(text = time, style = MaterialTheme.typography.body2)
        }
        Column(modifier = modifier) {
            Text(text = currency, style = MaterialTheme.typography.body2)
        }
        Column(modifier = modifier, horizontalAlignment = Alignment.End) {
            Text(text = total.toString(), style = MaterialTheme.typography.h6)
        }
}

@Composable
fun ExpenseItem(item: Expense) {
    Card(elevation = 4.dp, modifier = Modifier.padding(8.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)) {
            ExpenseDetails(item.title, item.date, item.price, Modifier.weight(0.85f))
        }
    }
}

@Composable
fun ExpenseDetails(title: String, date: String, price: Double, modifier: Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
        Column(modifier = modifier) {
            Text(text = title, style = MaterialTheme.typography.h6)
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(text = date, style = MaterialTheme.typography.body2)
            }
        }
        Column(modifier = modifier, horizontalAlignment = Alignment.End) {
            Text(text = price.toString(), style = MaterialTheme.typography.button,
                modifier = modifier.padding(8.dp, 1.dp).background(color = Color.Cyan, shape = RectangleShape))
        }
    }

}



















