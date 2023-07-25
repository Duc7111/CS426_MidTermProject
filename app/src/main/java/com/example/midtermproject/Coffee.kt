package com.example.midtermproject

import androidx.compose.foundation.Image
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.midtermproject.ui.theme.MidtermProjectTheme

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

    override fun toString() : String
    {
        val sh = if(shot) "double" else "single"
        val se = if(select) "iced" else "hot"
        val si = if(size == Tristate.SMALL) "small" else if(size == Tristate.MEDIUM) "medium" else "large"
        val ic = if(ice == Tristate.SMALL) "less ice" else if(ice == Tristate.MEDIUM) "half ice" else "full ice"
        return sh + " | " + se + " | " + si + if(select) " | $ic" else ""
    }
}

fun totalPrice(clist : List<Coffee>) : Float
{
    var sum = 0f
    for(coffee in clist)
    {
        sum += coffee.calCost()
    }
    return sum
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
        )
    )
}

@Preview
@Composable
fun CoffeeContentPreview()
{
    MidtermProjectTheme {
        CoffeeImage(index = 1, Modifier)
        CoffeeText(1)
    }
}