package com.doranco.tp_expenses

import android.content.ContentValues.TAG
import android.util.Log
import android.view.Display
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.magnifier
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Preview(showBackground = true)
@Composable
fun ExpensesScreen() {
    val viewModel: ExpensesViewModel = viewModel()
    FilterDetails()
    LazyColumn(contentPadding = PaddingValues(vertical = 60.dp, horizontal = 8.dp), modifier = Modifier) {

        items(viewModel.state.value) { expense ->
            ExpenseItem(expense)
        }
    }
}

@Composable
fun FilterDetails() {
    var text_time = remember {
        mutableStateOf("Last 7 Days")
    }
    var text_price = remember {
        mutableStateOf("67.16")
    }
    Card(elevation = 4.dp, modifier = Modifier
        .padding(16.dp)
        .width(360.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
            Button( onClick = {
                                text_time.value = "Last 14 Days"
                                println("FilterDetails: bouton cliqué")
                                Log.d(TAG, "FilterDetails: cliqué")
                             },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.purple_200),
                    contentColor = colorResource(id = R.color.white),
                ),
                shape = MaterialTheme.shapes.large,
                modifier = Modifier) {
                Text(text = text_time.value, style = MaterialTheme.typography.body2)
            }
            Button( onClick = {  },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.purple_200),
                    contentColor = colorResource(id = R.color.white)
                ),
                shape = MaterialTheme.shapes.large,
                modifier = Modifier)
            {
                Text(text = "$", style = MaterialTheme.typography.h6)
            }
            Button( onClick = {
                             text_price.value = "00.00"
                             },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.purple_200),
                    contentColor = colorResource(id = R.color.white)
                ),
                shape = MaterialTheme.shapes.large,
                modifier = Modifier)
            {
                Text(text = text_price.value, style = MaterialTheme.typography.h6)
            }
        }
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

    Row( verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween ) {
        Column(modifier = modifier) {
            Text(text = title, style = MaterialTheme.typography.h6)
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text(text = date, style = MaterialTheme.typography.body2)
            }
        }

        Column(modifier = modifier, horizontalAlignment = Alignment.End) {
            Button( onClick = {  },
                modifier = Modifier,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.teal_200),
                    contentColor = colorResource(id = R.color.white)
                ),
                shape = MaterialTheme.shapes.large

            ) {
                Text(text = price.toString(), style = MaterialTheme.typography.h6)
            }
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





















