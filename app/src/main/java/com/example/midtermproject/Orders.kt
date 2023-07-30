package com.example.midtermproject

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Orders(ad: AsynchronousData, username: String, onGoing: List<Order>, history: List<Order>, payAll: () -> Unit)
{
    var state by remember { mutableStateOf(0) }
    val header = "My Orders"
    val titles = listOf("On going", "History")

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    )
    {

        Text(
            text = header,
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black,
                textAlign = TextAlign.Center,),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp))

        TabRow(
            selectedTabIndex = state,
            containerColor = Color.White,
            modifier = Modifier
                .padding(10.dp))
        {
            titles.forEachIndexed{ i, t ->
                Tab(
                    selected = state == i,
                    onClick = { state = i },
                    selectedContentColor = Color.Black,
                    unselectedContentColor = Color.Gray,
                )
                {
                    Text(
                        text = t,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Black,
                            textAlign = TextAlign.Center,)
                    )
                }
            }
        }
        when(state)
        {
            0 -> OnGoing(ad, onGoing, payAll)

            1 -> History(ad, history)
        }
    }
}

@Composable
fun OnGoing(ad: AsynchronousData, onGoing: List<Order>, payAll: () -> Unit)
{
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp))
    {
        items(onGoing){order ->
            DisplayCoffee(ad, order)
        }
    }
    Button(
        onClick = payAll,
        modifier = Modifier
            .width(315.75375.dp)
            .height(46.00294.dp),
        shape = RoundedCornerShape(size = 30.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF324A59)),
    )
    {
        Text(
            text = "Pay All",
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 22.78.sp,
                fontWeight = FontWeight(600),
                color = Color.White,
                textAlign = TextAlign.Center,)
        )
    }

}

@Composable
fun History(ad: AsynchronousData, history: List<Order>)
{
    LazyColumn(
        verticalArrangement = Arrangement
            .spacedBy(24.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp))
    {
        items(history){order ->
            // Display coffee
            DisplayCoffee(ad, order)
        }
    }
}