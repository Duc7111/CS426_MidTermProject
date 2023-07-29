package com.example.midtermproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun DetailScreen(dao: DBDao, username: String, coffee: Coffee)
{
    var quantity by remember { mutableStateOf(1) }
    var shot by remember { mutableStateOf(false) }
    var select by remember { mutableStateOf(false) }
    var size by remember { mutableStateOf(Tristate.SMALL) }
    var ice by remember { mutableStateOf(Tristate.SMALL) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .background(color = Color.Transparent))
    {
        // Header
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp))
        {
            // Back button
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

            Text(
                text = "Details",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,)
            )

            // Cart button
            Button(
                onClick = { //To Cart
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
        }
        // Picture
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement =  Arrangement.Center,
            modifier = Modifier
                .width(325.dp)
                .height(146.dp)
                .background(color = Color(0xFFF7F8FB), shape = RoundedCornerShape(size = 12.dp)))
        {
            CoffeeImage(
                coffee.drawableName,
                modifier = Modifier
                    .width(172.dp)
                    .height(128.dp))
        }
        // Quantity
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp))
        {
            Text(
                text = coffee.name,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .border(
                        width = 1.2.dp,
                        color = Color(0x66D8D8D8),
                        shape = RoundedCornerShape(size = 50.dp)
                    )
                    .height(40.dp))
            {
                Button(
                    onClick = { if(quantity > 1) --quantity },
                    shape = RoundedCornerShape(size = 50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(64.dp))
                {
                    Text(
                        text = "-",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Black,),
                        modifier = Modifier
                            .fillMaxHeight())
                }

                Text(
                    text = "$quantity",
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black,),
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(top = 8.dp)
                        .width(32.dp))

                Button(
                    onClick = { if(quantity < 99) ++quantity },
                    shape = RoundedCornerShape(size = 50.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(64.dp))
                {
                    Text(
                        text = "+",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Black,),
                        modifier = Modifier
                            .fillMaxHeight())
                }
            }
        }

        // Shot
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp))
        {
            Text(
                text = "Shot",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                )
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .height(60.dp)
            )
            {
                Button(
                    onClick = { shot = false },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    modifier = Modifier
                        .border(
                            width = 1.2.dp,
                            color = if (shot) Color(0x66D8D8D8) else Color.Black,
                            shape = RoundedCornerShape(size = 50.dp)
                        )
                        .height(40.dp),)
                {
                    Text(
                        text = "Single",
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Black,)
                    )
                }

                Button(
                    onClick = { shot = true },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    modifier = Modifier
                        .border(
                            width = 1.2.dp,
                            color = if (!shot) Color(0x66D8D8D8) else Color.Black,
                            shape = RoundedCornerShape(size = 50.dp)
                        )
                        .height(40.dp),)
                {
                    Text(
                        text = "Double",
                        style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.Black,)
                    )
                }
            }
        }

        // Select
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp))
        {
            Text(
                text = "Select",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                )
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .height(60.dp)
            )
            {
                Button(
                    onClick = { select = false },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    modifier = Modifier
                        .fillMaxHeight()
                )
                {
                    Image(
                        painter = painterResource(id = R.drawable.here),
                        contentDescription = "Here icon",
                        alpha = if(select) 0.2f else 1f,
                        modifier = Modifier
                            .width(28.dp)
                            .height(27.dp))
                }

                Button(
                    onClick = { select = true },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    modifier = Modifier
                        .fillMaxHeight()
                )
                {
                    Image(
                        painter = painterResource(id = R.drawable.take_away),
                        contentDescription = "Here icon",
                        alpha = if(select) 1f else 0.2f,
                        modifier = Modifier
                            .width(20.dp)
                            .height(34.dp))
                }
            }
        }

        // Size
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp))
        {
            Text(
                text = "Size",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                )
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .height(60.dp)
            )
            {
                Button(
                    onClick = { size = Tristate.SMALL },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    modifier = Modifier
                        .fillMaxHeight())
                {
                    Image(
                        painter = painterResource(id = R.drawable.size),
                        contentDescription = "Here icon",
                        alpha = if(size == Tristate.SMALL) 1f else 0.2f,
                        modifier = Modifier
                            .width(17.dp)
                            .height(22.dp)
                    )
                }

                Button(
                    onClick = { size = Tristate.MEDIUM },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    modifier = Modifier
                        .fillMaxHeight())
                {
                    Image(
                        painter = painterResource(id = R.drawable.size),
                        contentDescription = "Here icon",
                        alpha = if(size == Tristate.MEDIUM) 1f else 0.2f,
                        modifier = Modifier
                            .width(24.dp)
                            .height(31.dp))
                }

                Button(
                    onClick = { size = Tristate.LARGE },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    modifier = Modifier
                        .fillMaxHeight()
                )
                {
                    Image(
                        painter = painterResource(id = R.drawable.size),
                        contentDescription = "Here icon",
                        alpha = if(size == Tristate.LARGE) 1f else 0.2f,
                        modifier = Modifier
                            .width(29.dp)
                            .height(38.dp))
                }
            }
        }

        // Ice
        if(select)
        {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp))
            {
                Text(
                    text = "Ice",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black,)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .height(60.dp)
                )
                {
                    Button(
                        onClick = { ice = Tristate.SMALL },
                        shape = RectangleShape,
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                        modifier = Modifier
                            .fillMaxHeight())
                    {
                        Image(
                            painter = painterResource(id = R.drawable.ice),
                            contentDescription = "Here icon",
                            alpha = if(ice == Tristate.SMALL) 1f else 0.2f,
                            modifier = Modifier
                                .width(17.dp)
                                .height(22.dp)
                        )
                    }

                    Button(
                        onClick = { ice = Tristate.MEDIUM },
                        shape = RectangleShape,
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                        modifier = Modifier
                            .fillMaxHeight())
                    {
                        Image(
                            painter = painterResource(id = R.drawable.ice),
                            contentDescription = "Here icon",
                            alpha = if(ice == Tristate.MEDIUM) 1f else 0.2f,
                            modifier = Modifier
                                .width(24.dp)
                                .height(31.dp))
                    }

                    Button(
                        onClick = { ice = Tristate.LARGE },
                        shape = RectangleShape,
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                        modifier = Modifier
                            .fillMaxHeight()
                    )
                    {
                        Image(
                            painter = painterResource(id = R.drawable.ice),
                            contentDescription = "Here icon",
                            alpha = if(ice == Tristate.LARGE) 1f else 0.2f,
                            modifier = Modifier
                                .width(29.dp)
                                .height(38.dp))
                    }
                }
            }
        }
        val order = Order(
            orderID = 0,
            username = username,
            coffeeName = coffee.name,)

        // Check
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp))
        {
            Text(
                text = "Total Amount",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                )
            )
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
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF324A59)),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(color = Color(0xFF324A59), shape = RoundedCornerShape(size = 30.dp)),
        )
        {
            Text(
                text = "Add to cart",
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



