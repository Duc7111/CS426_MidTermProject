package com.example.midtermproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.example.midtermproject.ui.theme.MidtermProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Room.databaseBuilder(
            applicationContext,
            Database::class.java,
            "Database"
        ).build()

        val dao = db.databaseDao()
        val ad = AsynchronousData(dao)

        ad.newUser(User("Guest"))

        setContent {
            MidtermProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen(ad, "Guest")
                }
            }
        }
    }
}





