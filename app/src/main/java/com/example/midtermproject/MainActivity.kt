package com.example.midtermproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.midtermproject.ui.theme.MidtermProjectTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MidtermProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen(Modifier)
                }
            }
        }
    }
}


@Composable
fun HomeScreen(modifier: Modifier = Modifier, username : String = "Guest", cnum : Int = 4)
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
                        color = Color(0xFFD8D8D8),))
                Text(
                    text = username,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black,))
            }
            Row()
            {
                // Cart button
                Button(
                    onClick = {
                        //To Cart
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
                        //To Profile
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
                            color = Color(0xFFD8D8D8)),)
                    Text(
                        text = "$cnum /8",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFFD8D8D8)),)
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
                items(6) { index ->
                    Button(
                        onClick = {
                            //Go to detail
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
                                index = index + 1,
                                modifier = Modifier
                                    .width(114.dp)
                                    .height(85.dp))
                            CoffeeText(index = index + 1)
                        }
                    }
                }
            }
        }
    }
}

enum class Tristate(){
    SMALL, MEDIUM, LARGE
}
class Coffee(index: Int, quantity: Int, shot: Boolean, select: Boolean, size: Tristate, ice: Tristate)
{
    val index = index
    val quantity = quantity
    val shot = shot
    val select = select
    val size = size
    val ice = ice

    fun calCost() : Float
    {
        val x = when(size){
            Tristate.SMALL -> 1f
            Tristate.MEDIUM -> 1.5f
            Tristate.LARGE -> 1.75f}
        return 3 * x * (if(shot) 2 else 1) * quantity
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    MidtermProjectTheme {
        HomeScreen(Modifier)
    }
}

@Composable
fun DetailScreen(index : Int)
{
    var quantity by remember { mutableStateOf(1)}
    var shot by remember { mutableStateOf(false) }
    var select by remember { mutableStateOf(false) }
    var size by remember { mutableStateOf(Tristate.SMALL) }
    var ice by remember { mutableStateOf(Tristate.SMALL) }

    val coffee = Coffee(index, quantity, shot, select, size, ice)

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
                    color = Color.Black,))

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
                index = index,
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
            CoffeeText(index = index)
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
                            color = if(shot) Color(0x66D8D8D8) else Color.Black,
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
                            color = if(!shot) Color(0x66D8D8D8) else Color.Black,
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
                    color = Color.Black,))
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
                text = "$${coffee.calCost()}",
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black,
                )
            )
        }

        Button(
            onClick = {},
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
                    textAlign = TextAlign.Center,))
        }

    }
}

@Preview
@Composable
fun DetailPreview() {
    MidtermProjectTheme {
        DetailScreen(1)
    }
}

@Composable
fun CoffeeImage(index: Int, modifier: Modifier)
{
    val context = LocalContext.current
    val resId = context.resources.getIdentifier("coffee_$index", "drawable", context.packageName)
    val drawableId = if (resId != 0) resId else R.drawable.coffee_icon_0
    Image(
        painter = painterResource(id = drawableId),
        contentDescription = "Drink $index",
        modifier = modifier)
}

@Composable
fun CoffeeText(index: Int)
{
    val context = LocalContext.current
    val resId = context.resources.getIdentifier("coffee_$index", "string", context.packageName)
    val stringID = if (resId != 0) resId else R.string.coffee_0
    Text(
        text = context.resources.getString(stringID),
        style = TextStyle(
            fontSize = 14.sp,
            lineHeight = 20.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black,
        ))
}

@Preview
@Composable
fun ButtonContentPreview()
{
    MidtermProjectTheme {
        CoffeeImage(index = 1, Modifier)
        CoffeeText(1)
    }
}




