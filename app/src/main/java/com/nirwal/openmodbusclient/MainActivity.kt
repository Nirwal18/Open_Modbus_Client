package com.nirwal.openmodbusclient

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.nirwal.openmodbusclient.ui.Screen
import com.nirwal.openmodbusclient.ui.component.*
import com.nirwal.openmodbusclient.ui.theme.OpenModbusClientTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val TAG = "MainActivity"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val screens = listOf(Screen.Home, Screen.Notification)
        setContent {
            val navController = rememberNavController()
            var screenTitle by remember {
                mutableStateOf("")
            }
        navController.addOnDestinationChangedListener{
                controller, destination, arguments ->

            screenTitle = destination.route.toString()

            }

            OpenModbusClientTheme {
              MainScreen(navController,screenTitle)

            }


        }
    }
}

