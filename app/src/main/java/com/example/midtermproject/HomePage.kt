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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HomeScreen(ad: AsynchronousData, user: User, clist: List<Coffee>, onStateChange: (Int) -> Unit, onOrder: (o: Order,i: Int) -> Unit, onLoyaltyGain: () -> Unit)
{
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth())
    {
        //Header
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp))
        {
            // Greeting
            Column(
            )
            {
                Text(
                    text = "Good morning",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFFD8D8D8),)
                )
                Text(
                    text = user.name,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black,)
                )
            }
            Row()
            {
                // Cart button
                Button(
                    onClick = {
                        onStateChange(4)
                    },
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent))
                {
                    Image(
                        painter = painterResource(id = R.drawable.cart),
                        contentDescription = "Cart icon",
                        modifier = Modifier
                            .width(26.dp)
                            .height(26.dp))
                }
                // Profile button
                Button(
                    onClick = {
                        onStateChange(3)
                    },
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent))
                {
                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "Profile icon",
                        modifier = Modifier
                            .width(26.dp)
                            .height(26.dp))
                }
            }
        }
        //Loyalty card
        LoyaltyCard(cnum = user.loyaltyPoint, onLoyaltyGain)
        // Coffee list
        Column (
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color(0xFF324A59),
                    shape = RoundedCornerShape(
                        topStart = 25.dp,
                        topEnd = 25.dp,
                        bottomEnd = 0.dp,
                        bottomStart = 0.dp
                    )
                ))
        {
            Text(
                text = "Choose your coffee",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFFD8D8D8),),
                modifier = Modifier
                    .padding(start = 24.dp, top = 18.dp)
            )
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 154.dp),
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(375.dp)
                    .padding(start = 24.dp, top = 24.dp, end = 24.dp, bottom = 0.dp))
            {
                items(clist.size) { i ->
                    Button(
                        onClick = {
                            onOrder (Order(username = user.username, coffeeName =  clist[i].name), i)
                            onStateChange(5)
                        },
                        shape = RoundedCornerShape(15.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF7F8FB)),
                        modifier = Modifier
                            .width(154.dp)
                            .height(154.dp))
                    {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxSize())
                        {
                            CoffeeImage(
                                clist[i].drawableName,
                                modifier = Modifier
                                    .width(114.dp)
                                    .height(85.dp))

                            Text(
                                text = clist[i].name,
                                style = TextStyle(
                                    fontSize = 14.sp,
                                    lineHeight = 20.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = Color.Black,))
                        }
                    }
                }
            }
        }
    }
}
