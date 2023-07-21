package com.example.midtermproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
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
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
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
            painter = painterResource(id = R.drawable.rizky-subagja-1k7tnx5gaww-unsplash1),
            contentDescription = "rizky-subagja-1k7TnX5GAww-unsplash 1",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = (-1336).dp,
                    y = (-1576).dp)
                .width(width = 2731.dp)
                .height(height = 4096.dp))
        Image(
            painter = painterResource(id = R.drawable.rizky-subagja-cd7bwkq3xtu-unsplash1),
            contentDescription = "rizky-subagja-Cd7bWkq3XtU-unsplash 1",
            modifier = Modifier
                .width(width = 375.dp)
                .height(height = 812.dp))
        Image(
            painter = painterResource(id = R.drawable.rectangle2588),
            contentDescription = "Rectangle 2588",
            modifier = Modifier
                .width(width = 375.dp)
                .height(height = 812.dp)
                .background(color = Color(0xff1d2335).copy(alpha = 0.37f)))
        Box(
            modifier = Modifier
                .width(width = 348.dp)
                .height(height = 21.dp)
        ) {
            Text(
                text = "9:41",
                color = Color.White,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 15.sp,
                    letterSpacing = (-0.3).sp),
                modifier = Modifier
                    .align(alignment = Alignment.CenterStart)
                    .offset(x = 0.dp,
                        y = 0.dp)
                    .width(width = 54.dp))
            Image(
                painter = painterResource(id = R.drawable.cellularconnection),
                contentDescription = "Cellular Connection",
                colorFilter = ColorFilter.tint(Color.Black),
                modifier = Modifier
                    .width(width = 17.dp)
                    .height(height = 11.dp)
                    .background(color = Color.White))
            Image(
                painter = painterResource(id = R.drawable.wifi),
                contentDescription = "Wifi",
                colorFilter = ColorFilter.tint(Color.Black),
                modifier = Modifier
                    .width(width = 15.dp)
                    .height(height = 11.dp)
                    .background(color = Color.White))
            Box(
                modifier = Modifier
                    .width(width = 24.dp)
                    .height(height = 11.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.border),
                    contentDescription = "Border",
                    alpha = 0.35f,
                    modifier = Modifier
                        .align(alignment = Alignment.CenterEnd)
                        .offset(x = (-2.3280372619628906).dp,
                            y = 0.dp)
                        .width(width = 22.dp)
                        .height(height = 11.dp)
                        .clip(shape = RoundedCornerShape(2.6666667461395264.dp))
                        .border(border = BorderStroke(1.dp, Color.Black),
                            shape = RoundedCornerShape(2.6666667461395264.dp)))
                Image(
                    painter = painterResource(id = R.drawable.capacity),
                    contentDescription = "Capacity",
                    modifier = Modifier
                        .align(alignment = Alignment.CenterEnd)
                        .offset(x = (-4.328037261962891).dp,
                            y = 1.1920928955078125e-7.dp)
                        .width(width = 18.dp)
                        .height(height = 7.dp)
                        .clip(shape = RoundedCornerShape(1.3333333730697632.dp))
                        .background(color = Color.White))
                Image(
                    painter = painterResource(id = R.drawable.cap),
                    contentDescription = "Cap",
                    alpha = 0.4f,
                    modifier = Modifier
                        .align(alignment = Alignment.CenterEnd)
                        .offset(x = 7.152557373046875e-7.dp,
                            y = 2.384185791015625e-7.dp)
                        .width(width = 1.dp)
                        .height(height = 4.dp)
                        .background(color = Color.White.copy(alpha = 0.4f)))
            }
        }
        Text(
            text = "Ordinary Coffee House",
            color = Color(0xfffffaf6),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 48.dp,
                    y = 417.dp)
                .width(width = 279.dp)
                .height(height = 24.dp))
        Image(
            painter = painterResource(id = R.drawable.group7103),
            contentDescription = "Group 7103",
            colorFilter = ColorFilter.tint(Color(0xfffffaf6)),
            modifier = Modifier
                .width(width = 121.dp)
                .height(height = 132.dp))
    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    SplashScreen(Modifier)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MidtermProjectTheme {
        Greeting("Android")
    }
}