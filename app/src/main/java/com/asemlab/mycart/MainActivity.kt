package com.asemlab.mycart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.asemlab.mycart.ui.navigation.Destination
import com.asemlab.mycart.ui.navigation.MyCartBottomBar
import com.asemlab.mycart.ui.navigation.MyCartNavHost
import com.asemlab.mycart.ui.theme.MyCartTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()

            MyCartTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    /*.padding(top = 32.dp)*/
                    bottomBar = { MyCartBottomBar(navController) }
                ) { innerPadding ->

                    MyCartNavHost(navController, Destination.TABLES, innerPadding)

                }
            }
        }
    }
}

