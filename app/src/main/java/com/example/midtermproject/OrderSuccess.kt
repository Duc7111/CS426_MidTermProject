package com.example.midtermproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.example.midtermproject.ui.theme.MidtermProjectTheme

@Composable
fun OrderSuccess()
{
    Column (
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 200.dp, bottom = 150.dp, start = 50.dp, end = 50.dp))
    {
        Image(
            painter = painterResource(id = R.drawable.order_success),
            contentDescription = "image description",
            modifier = Modifier
                .padding(1.dp)
                .width(177.dp)
                .height(177.dp)
        )

        Text(
            text = "Order Success",
            style = TextStyle(
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black,
                textAlign = TextAlign.Center,
            )
        )

        Text(
            text = "Your order has been placed successfully.\n For more details, go to my orders.",
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 27.25.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFFAAAAAA),
                textAlign = TextAlign.Center,),
            modifier = Modifier
                .width(286.dp)
                .height(54.dp)
        )

        Button(
            onClick = {

            },
            modifier = Modifier
                .width(315.75375.dp)
                .height(46.00294.dp),
            shape = RoundedCornerShape(size = 30.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF324A59)),
        )
        {
            Text(
                text = "Track My Order",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 22.78.sp,
                    fontWeight = FontWeight(600),
                    color = Color.White,
                    textAlign = TextAlign.Center,)
            )
        }
    }
}

@Preview
@Composable
fun OrderSuccessPreview()
{
    MidtermProjectTheme {
        OrderSuccess()
    }
}