package com.example.midtermproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
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
fun ProfilePreview()
{
    Profile(User("Adam", "1234", "sth", "sth"))
}

@Composable
fun Profile(user: User)
{
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment =  Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp))
    {
        // header
        Text(
            text = "Profile",
            style = TextStyle(
                fontSize = 16.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black,
                textAlign = TextAlign.Center,
            )
        )

        ProfileRow(rowName = "Full name", string = user.name)
        {
            user.name = it
        }

        ProfileRow(rowName = "Phone", string = user.phone)
        {
            user.phone = it
        }

        ProfileRow(rowName = "Email", string = user.email)
        {
            user.email = it
        }

        ProfileRow(rowName = "address", string = user.address)
        {
            user.address = it
        }

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF324A59)),
            shape = RoundedCornerShape(size = 30.dp),
            modifier = Modifier
                .width(316.dp)
                .height(75.dp)
                .padding(16.dp))
        {
            Text(
                text = "Save And Back",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 22.78.sp,
                    fontWeight = FontWeight(600),
                    color = Color.White,
                    textAlign = TextAlign.Center,
                )
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileRow(rowName: String, string: String, onTextChange : (String) -> Unit)
{
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(),)
    {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "image description",
            modifier = Modifier
                .padding(1.dp)
                .width(20.dp)
                .height(20.dp))

        var edit by remember{ mutableStateOf(false) }
        var edited by remember{ mutableStateOf(false) }
        var str by rememberSaveable{ mutableStateOf(string) }

        TextField(
            value = str,
            onValueChange = {
                str = it
                edited = true
            },
            label = {
                Text(
                    text = rowName,
                    style = TextStyle(
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black,))
            },
            textStyle = TextStyle(
                fontSize = 14.sp,
                lineHeight = 22.78.sp,
                fontWeight = FontWeight(600),
                color = Color.Black,),
            enabled = edit,
            colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent),
            modifier = Modifier
                .width(300.dp)
                .onFocusChanged { if (!it.isFocused and edited) edit = false })

        Image(
            painter = painterResource(id = R.drawable.edit),
            contentDescription = "edit button",
            modifier = Modifier
                .padding(1.dp)
                .width(24.dp)
                .height(24.dp)
                .clickable { edit = true })
    }
}

