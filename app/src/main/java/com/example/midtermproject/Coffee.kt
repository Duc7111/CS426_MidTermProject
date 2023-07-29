package com.example.midtermproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CoffeeImage(drawableName: String, modifier: Modifier)
{
    Image(
        painter = painterResource(id = getDrawableIdByStringName(name = drawableName)),
        contentDescription = "Coffee Image",
        modifier = modifier
    )
}

fun totalPrice(orderList: List<Order>): Float {
    var sum = 0f
    for(order in orderList)
    {
        sum += order.calCost()
    }
    return sum
}

@Composable
fun DisplayCoffee(ad: AsynchronousData, order : Order)
{
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        userScrollEnabled = false,
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)

    )
    {
        item()
        {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .width(LocalConfiguration.current.screenWidthDp.dp)
                    .height(96.dp)
                    .background(color = Color(0xFFF7F8FB), shape = RoundedCornerShape(size = 15.dp))
            )
            {
                var coffee by remember { mutableStateOf(Coffee()) }
                ad.getCoffee(order.coffeeName) { coffee = it }
                CoffeeImage(
                    drawableName = coffee.drawableName,
                    modifier = Modifier
                        .width(82.dp)
                        .height(61.dp))

                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillParentMaxHeight())
                {
                    Text(
                        text = coffee.name,
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Black,)
                    )

                    Text(
                        text = order.toString(),
                        style = TextStyle(
                            fontSize = 10.sp,
                            fontWeight = FontWeight(300),
                            color = Color(0xFF757575),)
                    )

                    Text(
                        text = "x ${order.quantity}",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight(600),
                            color = Color(0x91000000),
                        )
                    )
                }
                Text(
                    text = "$${order.calCost()}",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black,
                    )
                )
            }

            Button(
                onClick = {

                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFE5E5)),
                shape = RoundedCornerShape(size = 15.dp),
                modifier = Modifier
                    .height(96.dp)
            )
            {
                Image(
                    painter = painterResource(id = R.drawable.delete),
                    contentDescription = "Delete",
                    modifier = Modifier
                        .padding(1.dp)
                        .width(24.dp)
                        .height(24.dp)
                )
            }
        }
    }
}

