package com.nirwal.openmodbusclient.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.nirwal.openmodbusclient.ui.MyNavHost
import com.nirwal.openmodbusclient.ui.Screen
import com.nirwal.openmodbusclient.ui.component.addProject.AddProjectViewModel
import kotlinx.coroutines.launch

@Composable
fun MainScreen(navController:NavHostController, screenTitle:String){
    val scaffoldState = rememberScaffoldState(
        rememberDrawerState(DrawerValue.Closed)
    )
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState=scaffoldState,
        backgroundColor = MaterialTheme.colors.background,
        drawerContent ={
            MyDrawer{ route->
                navController.navigate(route = route){
                    launchSingleTop =true
                }
                scope.launch {  scaffoldState.drawerState.close() }
            }
        },

        drawerGesturesEnabled = true,

        topBar = {
            TopAppBar(
                title = { Text(text = screenTitle) },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu",
                        modifier = Modifier
                            .padding(8.dp)
                            .clickable(enabled = true) {
                                scope.launch {
                                    scaffoldState.drawerState.open()
                                }
                            }
                    )
                },

            )
        }

    ) {
        //draw all page on screen, manage navigation graph
        MyNavHost(navController = navController)
    }
}