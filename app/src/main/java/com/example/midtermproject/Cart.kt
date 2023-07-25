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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.midtermproject.ui.theme.MidtermProjectTheme

@Composable
fun Cart(clist: List<Coffee>)
{
    val header = ConstrainedLayoutReference(id = "header")
    val caption = ConstrainedLayoutReference(id = "caption")
    val list = ConstrainedLayoutReference(id = "list")
    val checkOut = ConstrainedLayoutReference(id = "check_out")

    ConstraintLayout(
        modifier = Modifier
            .layoutId("cart_main")
            .fillMaxSize()
    )
    {
        // header
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(header) {
                    top.linkTo(parent.top, margin = 16.dp)
                })
        {
            Button(
                onClick = { //To Profile
                },
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent))
            {
                Image(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = "Back icon",
                    modifier = Modifier
                        .width(26.dp)
                        .height(26.dp))
            }
        }

        Text(
            text = "My Cart",
            style = TextStyle(
                fontSize = 20.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black,
                textAlign = TextAlign.Start,),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .constrainAs(caption) {
                    top.linkTo(header.bottom)
                })

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(list) {
                    top.linkTo(caption.bottom)
                    bottom.linkTo(checkOut.top, margin = 16.dp)
                })
        {
            items(clist.size){i ->
                // Display coffee
                DisplayCoffee(coffee = clist[i])
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .constrainAs(checkOut) {
                    bottom.linkTo(parent.bottom, margin = 16.dp)
                }
        )
        {
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            )
            {
                Text(
                    text = "Total Price",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0x38001833),
                    )
                )
                Text(
                    text = "$${totalPrice(clist)}",
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF001833),
                    )
                )
            }

            Button(
                onClick = {

                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF324A59)),
                modifier = Modifier
                    .width(162.dp)
                    .height(52.dp)
                    .background(color = Color(0xFF324A59), shape = RoundedCornerShape(size = 30.dp))
            )
            {
                Image(
                    painter = painterResource(id = R.drawable.cart),
                    contentDescription = "image description",
                    modifier = Modifier
                        .padding(1.dp)
                        .width(24.dp)
                        .height(24.dp),
                    alpha = 0.1f)

                Text(
                    text = "Checkout",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 23.sp,
                        fontWeight = FontWeight(600),
                        color = Color.White,
                        textAlign = TextAlign.Center,)
                )
            }
        }
    }
}

@Preview
@Composable
fun CartPreview(){
    MidtermProjectTheme {
        Cart(List<Coffee>(1){Coffee(1, 1, false, false, Tristate.MEDIUM, Tristate.MEDIUM)})
    }
}