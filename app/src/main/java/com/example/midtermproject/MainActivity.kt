package com.example.midtermproject

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.midtermproject.ui.theme.MidtermProjectTheme

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
                    SplashScreen(Modifier)
                }
            }
        }
    }
}

@Composable
fun SplashScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .width(width = 375.dp)
            .height(height = 812.dp)
            .background(color = Color(0xff324a59).copy(alpha = 0.86f))
    ) {
        Image(
            painter = painterResource(id = R.drawable.splash_screen_background),
            contentDescription = "rizky-subagja-Cd7bWkq3XtU-unsplash 1",
            modifier = Modifier
                .width(width = 375.dp)
                .height(height = 812.dp))
        Text(
            text = "Ordinary Coffee House",
            color = Color(0xfffffaf6),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(
                    x = 48.dp,
                    y = 417.dp
                )
                .width(width = 279.dp)
                .height(height = 24.dp))
        Image(
            painter = painterResource(id = R.drawable.splash_screen_icon),
            contentDescription = "Group 7103",
            colorFilter = ColorFilter.tint(Color(0xfffffaf6)),
            modifier = Modifier
                .width(width = 121.dp)
                .height(height = 132.dp))
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
                    .fillMaxSize()
                    .padding(start = 24.dp, top = 24.dp,end = 24.dp, bottom = 0.dp))
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
                            ButtonContent(index = index + 1)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ButtonContent(index: Int)
{
    val context = LocalContext.current
    var resId = context.resources.getIdentifier("coffee_$index", "drawable", context.packageName)
    val drawableId = if (resId != 0) resId else R.drawable.coffee_icon_0
    resId = context.resources.getIdentifier("coffee_$index", "string", context.packageName)
    val stringID = if (resId != 0) resId else R.string.coffee_0
    Image(
        painter = painterResource(id = drawableId),
        contentDescription = "Drink $index",
        modifier = Modifier
            .width(114.dp)
            .height(85.dp))
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
        ButtonContent(index = 1)
    }
}

@Preview
@Composable
fun SplashScreenPreview() {
    MidtermProjectTheme {
        SplashScreen(Modifier)
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    MidtermProjectTheme {
        HomeScreen(Modifier)
    }
}
