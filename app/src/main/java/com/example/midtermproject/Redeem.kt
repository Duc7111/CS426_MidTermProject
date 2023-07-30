package com.example.midtermproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

const val redeemPts = 1350

@Composable
fun Redeem(coffeeList: List<Coffee>, user: User, onStateChange: (Int) -> Unit, onRedeem: (Order) -> Unit)
{
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp))
    {
        // Header
        Box (
            contentAlignment = Alignment.CenterStart)
        {
            Text(
                text = "Redeem",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF001833),
                    textAlign = TextAlign.Center,),
                modifier = Modifier
                    .fillMaxWidth()
            )
            Image(
                painter = painterResource(id = R.drawable.back),
                contentDescription = "Back button",
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp)
                    .clickable {
                        onStateChange(1)
                    })
        }
        LazyColumn(
            verticalArrangement = Arrangement.Top,
        )
        {
            items(coffeeList)
            {coffee ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                )
                {
                    CoffeeImage(
                        coffee.drawableName,
                        modifier = Modifier
                            .width(82.dp)
                            .height(61.dp))

                    Text(
                        text = coffee.name,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF324A59),
                        )
                    )

                    Button(
                        onClick ={
                            onRedeem(Order(username = user.username, coffeeName = coffee.name, quantity = 0))
                            onStateChange(2)
                        },
                        shape = RoundedCornerShape(size = 50.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF324A59)),
                        enabled = user.point >= redeemPts,
                        modifier = Modifier
                            .width(76.dp)
                            .height(32.dp)
                    )
                    {
                        Text(
                            text = "$redeemPts pts",
                            style = TextStyle(
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color.White,))
                    }
                }
            }
        }
    }
}