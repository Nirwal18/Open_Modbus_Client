package com.nirwal.openmodbusclient.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.nirwal.openmodbusclient.ui.component.*
import com.nirwal.openmodbusclient.ui.component.addProject.AddProjectViewModel

@Composable
fun MyNavHost(navController:NavHostController){
    Surface(
        modifier = Modifier
        .fillMaxSize()
        .padding(8.dp),
        color=MaterialTheme.colors.surface
    ) {


        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,

            ) {
            composable(route = Screen.Home.route) {

                val homeViewModel: HomeViewModel = viewModel()
                HomeScreen(
                    homeViewModel = homeViewModel,
                    navController= navController
                )
            }
            composable(route = Screen.Notification.route) {
                Notification()
            }

            composable(route = Screen.AddProject.route) {
                val _viewModel: AddProjectViewModel = viewModel()
                AddProject(_viewModel = _viewModel, navController = navController)
            }

            composable(route = Screen.RegisterMap.route) {
                // val _viewModel:AddProjectViewModel = viewModel()
                RegisterMapView()
            }
        }
    }
}