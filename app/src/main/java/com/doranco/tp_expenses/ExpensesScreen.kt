package com.doranco.tp_expenses

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import java.util.*

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun ExpensesScreen() {
    val viewModel: ExpensesViewModel = viewModel()
    var total =  String.format("%.2f", viewModel.totalPrice()).toDouble()

    Column(modifier = Modifier.padding(8.dp)){
        FilterDetails(viewModel, total)
        LazyColumn(contentPadding = PaddingValues(vertical = 8.dp, horizontal = 8.dp), modifier = Modifier) {
            items(viewModel.state.value) { expense ->
                ExpenseItem(expense)
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun FilterDetails(viewModel: ExpensesViewModel, total: Double) {
    Card(elevation = 4.dp, modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
            Button(
                onClick = {
                    viewModel.selectDate()
                    System.out.println("FilterDetails: bouton cliqué")
                    Log.d(TAG, "FilterDetails: cliqué")
                },
                modifier = Modifier.padding(4.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.purple_200),
                    contentColor = colorResource(id = R.color.white),
                ),
                shape = RoundedCornerShape(20)
            ) { Text(text = "7 jours", style = MaterialTheme.typography.h6) }

            Button(
                onClick = {  },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.purple_200),
                    contentColor = colorResource(id = R.color.white)
                ),
                shape = RoundedCornerShape(20),
                modifier = Modifier.padding(4.dp)
            ) { Text(text = "€$total", style = MaterialTheme.typography.h6) }
        }
    }
}

@Composable
fun ExpenseItem(item: Expense) {
    Card(elevation = 4.dp, modifier = Modifier.padding(8.dp)){
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
            Button(
                onClick = {
                    System.out.println("FilterDetails: bouton cliqué")
                    Log.d(TAG, "FilterDetails: cliqué")
                },
                modifier = Modifier,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.teal_200),
                    contentColor = colorResource(id = R.color.white)
                ),
                shape = RoundedCornerShape(50)
            ) { Text(text = price.toString(), style = MaterialTheme.typography.h6) }
        }
    }
}

/*
@Composable
fun DisplayUI() {
    var text_title: String = "Exemple"
    Text(
        text = text_title,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Center,
        color = colorResource(id = R.color.teal_200),
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(5.dp) // aspects exterieurs
    )
}
 */





















