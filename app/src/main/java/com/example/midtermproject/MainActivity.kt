package com.example.midtermproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.room.Room
import com.example.midtermproject.ui.theme.MidtermProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db: AppDatabase by lazy {AppDatabase.getDatabase(this)}

        val dao = db.databaseDao()
        val ad = AsynchronousData(dao)
        val username = "Guest"
        val screen = ConstrainedLayoutReference(id = "screen")
        val botNav = ConstrainedLayoutReference(id = "bottom navigation")

        var order = Order(0, username, "")//init here to prevent remembered var recalculate this

        //ad.newUser(User(username))
        //ad.initCoffee()

        setContent {
            var state by remember { mutableStateOf(0) }
            var prev = 0
            var chosen = 0

            var user by remember { mutableStateOf(User()) }
            var clist by remember { mutableStateOf(emptyList<Coffee>()) }
            var cart by remember { mutableStateOf(emptyList<Order>()) }
            var onGoing by remember { mutableStateOf(emptyList<Order>()) }
            var history by remember { mutableStateOf(emptyList<Order>()) }

            ad.getUser(username) { user = it }
            ad.getAllCoffee { clist = it }

            MidtermProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                )
                {
                    ConstraintLayout(
                        modifier = Modifier
                            .fillMaxSize()
                    )
                    {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .constrainAs(screen)
                                {
                                    top.linkTo(parent.top)
                                }
                        )
                        {
                            when(state)
                            {
                                0 ->
                                    HomeScreen(ad, user, clist,
                                        onOrder = {o, i -> order = o; chosen = i},
                                        onStateChange = { prev = state; state = it },
                                        onLoyaltyGain = { user.loyaltyPoint -= 8; user.point += 100; state = 1 })
                                1 ->
                                    Rewards(user, history,
                                        onStateChange = { state = it},
                                        onLoyaltyGain = { user.loyaltyPoint -= 8; user.point += 100 } )
                                2 ->
                                    Orders(ad, username, onGoing, history)
                                    {
                                        history = history + onGoing
                                        for(o in onGoing)
                                        {
                                            user.loyaltyPoint += o.quantity
                                            user.point += o.quantity*pts
                                        }
                                        onGoing = emptyList()
                                    }
                                3 ->
                                    Profile(ad, user)
                                    {
                                        state = it
                                    }
                                4 ->
                                    Cart(ad, username, cart, prev, onBack = {state = it},
                                        onCheckOut = {
                                            onGoing = onGoing + cart
                                            cart = emptyList()
                                            state = 6} )
                                5 ->
                                    DetailScreen(
                                        coffee = clist[chosen],
                                        order,
                                        onOrderChange = {
                                            order = it
                                            cart = cart + it},
                                        onStateChange = { state = it }
                                    )
                                6 ->
                                    OrderSuccess()
                                    {
                                        state = it
                                    }
                                7 -> Redeem(clist, user,
                                    onRedeem = {
                                        user.point -= redeemPts
                                        onGoing = onGoing + it
                                    },
                                    onStateChange = {
                                        state = it
                                    })
                            }

                        }
                        if(state < 3)
                        {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .constrainAs(botNav)
                                    {
                                        bottom.linkTo(parent.bottom, 20.dp)

                                    }
                            )
                            {
                                BottomNavigation(state)
                                {
                                    state = it
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun BottomNavigation(state: Int, onStateChange: (Int) -> Unit)
{
    val icons = Array<Painter?>(3){null}
    icons[0] = painterResource(id = R.drawable.navigation_0)
    icons[1] = painterResource(id = R.drawable.navigation_1)
    icons[2] = painterResource(id = R.drawable.navigation_2)
    TabRow(
        selectedTabIndex = state,
        containerColor = Color.White,
        modifier = Modifier
            .shadow(
                elevation = 50.dp,
                spotColor = Color(0x1F000000),
                ambientColor = Color(0x1F000000)
            )
            .width(324.dp)
            .clip(RoundedCornerShape(size = 20.dp)),)
    {
        icons.forEachIndexed{ i, icon ->
            Tab(
                selected = state == i,
                onClick = {
                    onStateChange(i)
                },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Gray,
            )
            {
                if (icon != null) {
                    Icon(
                        painter = icon,
                        contentDescription = "navigation icon $i",
                        modifier = Modifier
                            .padding(20.dp)
                            .width(25.dp)
                            .height(25.dp))
                }
            }
        }
    }
}





