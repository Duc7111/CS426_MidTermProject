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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun RedeemPreview()
{
    Redeem(Array<Coffee>(1)
    {
        Coffee(1, 1, false, false, Tristate.MEDIUM, Tristate.MEDIUM)
    })
}

@Composable
fun Redeem(history: Array<Coffee>)
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
                    .clickable { })
        }
        LazyColumn(
            verticalArrangement = Arrangement.Top,
        )
        {
            items(6)
            { i ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                )
                {
                    CoffeeImage(
                        index = i + 1,
                        modifier = Modifier
                            .width(82.dp)
                            .height(61.dp))

                    CoffeeText(index = i + 1)
                    Button(
                        onClick ={
                            //Get to detail screen
                        },
                        shape = RoundedCornerShape(size = 50.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF324A59),),
                        modifier = Modifier
                            .width(76.dp)
                            .height(32.dp)
                    )
                    {
                        Text(
                            text = "${pts * 115 - 40} pts",
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