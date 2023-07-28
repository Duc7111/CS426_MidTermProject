package com.example.midtermproject

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun OdersPreview()
{
    Orders()
}

@Composable
fun Orders()
{
    var state by remember { mutableStateOf(0) }
    val header = "My Orders"
    val titles = listOf<String>("On going", "History")

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
            containerColor = Color.White,)
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
            0 -> OnGoing()
            1 -> History()
        }
    }
}

@Composable
fun OnGoing()
{

}

@Composable
fun History()
{

}