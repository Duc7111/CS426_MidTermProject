package com.example.midtermproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


const val pts : Int = 12

@Composable
fun Rewards(ad: AsynchronousData, username: String)
{
    var user by remember { mutableStateOf(User()) }
    ad.getUser(username) { user = it }
    var orderList by remember { mutableStateOf(List<Order>(0){Order(0, "", "")}) }
    ad.getOrders(username, Tristate.MEDIUM, Tristate.LARGE)
    {
        orderList = it
    }
    var point by remember {
        mutableStateOf(user.point)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize())
    {
        // Header
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp))
        {
            Text(
                text = "Rewards",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                    textAlign = TextAlign.Center,),
                modifier = Modifier
                    .width(68.dp)
                    .height(24.dp))
        }
        LoyaltyCard(user.loyaltyPoint)
        //Point
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp)
                .background(color = Color(0xFF324A59), shape = RoundedCornerShape(12.dp)))
        {
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(10.dp)
            )
            {
                Text(
                    text = "My Points:",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFFD8D8D8),),
                    modifier = Modifier)

                Text(
                    text = "${user.point}",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFFD8D8D8),),
                    modifier = Modifier)
            }

            Button(
                onClick = {

                },
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA2CDE9),),
                modifier = Modifier
                    .padding(16.dp)
                )
            {
                Text(
                    text = "Redeem drinks",
                    style = TextStyle(
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFFD8D8D8),
                    )
                )
            }
        }
        // Caption
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp))
        {
            Text(
                text = "History Rewards",
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF324A59),
                )
            )
        }
        // History Rewards
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxSize())
        {
            items(orderList)
            {order ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth())
                {
                    Text(
                        text = order.coffeeName,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight(500),
                            color = Color(0xFF324A59),))

                    Text(
                        text = "+ $pts Pts",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF324A59),),
                        modifier = Modifier
                            .width(59.dp)
                            .height(24.dp))
                }
            }
        }
    }
}

@Composable
fun LoyaltyCard(cnum: Int)
{
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .background(color = Color(0xFF324A59), shape = RoundedCornerShape(12.dp)))
    {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp))
        {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 10.dp))
            {
                Text(
                    text = "Loyalty card",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFFD8D8D8)
                    ),)
                Text(
                    text = "$cnum /8",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFFD8D8D8)
                    ),)
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 10.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(12.dp)))
            {
                for(i : Int in 1..8)
                    Image(
                        painter = if(i <= cnum)
                            painterResource(id = R.drawable.coffee_icon_1)
                        else
                            painterResource(id = R.drawable.coffee_icon_0),
                        contentDescription = "Coffee Icon",
                        modifier = Modifier
                            .padding(vertical = 20.dp, horizontal = 0.dp)
                            .width(30.dp)
                            .height(30.dp))
            }
        }
    }
}