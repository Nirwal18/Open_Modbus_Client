package com.nirwal.openmodbusclient.ui.component

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.*

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.nirwal.openmodbusclient.R
import com.nirwal.openmodbusclient.model.ModBusDeviceType
import com.nirwal.openmodbusclient.model.Project
import com.nirwal.openmodbusclient.ui.Screen

private const val TAG = "Home"

@Composable
fun HomeScreen(homeViewModel: HomeViewModel, navController: NavHostController){

    val projets = homeViewModel.getProjects()

        LazyColumn(
            modifier = Modifier.padding(8.dp),
        ) {


            items(projets) { project->
                ProjectCard(project = project,onClick = {
                    Log.d(TAG, "HomeScreen: card clicked")
                    navController.navigate(Screen.RegisterMap.route) {
                        launchSingleTop = true
                    }
                })
                Spacer(Modifier.height(8.dp))
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 24.dp, end = 24.dp),
            contentAlignment = Alignment.BottomEnd
        ){
            FloatingActionButton(
                onClick = {

                    navController.navigate(Screen.AddProject.route) {
                    launchSingleTop = true
                }
                          },
                backgroundColor = MaterialTheme.colors.secondary
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add project",
                    tint = MaterialTheme.colors.onSecondary
                )
            }
        }


}




@Composable
fun ProjectCard(project:Project, onClick: ()->Unit ){

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(enabled = true, onClick = onClick),
        backgroundColor = MaterialTheme.colors.surface,
       // border = BorderStroke(1.dp, Color.Gray ),
        elevation = 8.dp
    ) {
        Column{
            Text(
                text = project.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.secondary)
                    .padding(4.dp),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.onSecondary,
                style = MaterialTheme.typography.h6
            )

            Text(
                text = "Communication: ${project.comType}",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.subtitle1
            )

            Text(
                text = "Device: ${project.device}",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.subtitle1
            )


//            Row(
//                modifier=Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.End
//            ) {
//                IconButton(
//                    modifier= Modifier
//                        .height(48.dp)
//                        .width(48.dp),
//                    onClick = {}
//                ){
//                    Icon(
//                        imageVector = Icons.Default.Edit,
//                        contentDescription = stringResource(id = R.string.edit)
//                    )
//                }
//
//                IconButton(
//                    modifier= Modifier
//                        .height(48.dp)
//                        .width(48.dp),
//                    onClick = { /*TODO*/ }
//                ) {
//                    Icon(
//                        imageVector = Icons.Default.Delete,
//                        contentDescription = stringResource(id = R.string.delete)
//                    )
//
//                }
//            }

        }

    }
}


/*
@Composable
fun addProjectDialog(){
    val openDialog = remember{ mutableStateOf(true)}
    var editTitle by remember { mutableStateOf("") }


    if(openDialog.value){
        Dialog(
            onDismissRequest = { openDialog.value = false},
            content =
            {
                Surface(
                    color = MaterialTheme.colors.surface
                ) {


                Column(modifier = Modifier.padding(8.dp),)
                {
                    Text(
                        text = "New project",
                        modifier = Modifier.fillMaxWidth()
                            .padding(4.dp),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.h6
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        modifier= Modifier.fillMaxWidth(),
                        value = editTitle,
                        onValueChange = {
                            editTitle = it
                        },
                        enabled = true,
                        label = {
                            Text(text = "Title")
                        })

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        modifier= Modifier.fillMaxWidth(),
                        value = editTitle,
                        onValueChange = {
                            editTitle = it
                        },
                        enabled = true,
                        label = {
                            Text(text = "")
                        })

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        TextButton(onClick = { /*TODO*/ }) {
                            Text(text = "OK")
                        }

                        TextButton(onClick = { openDialog.value=false}) {
                            Text(text ="Cancel")

                        }
                    }

                }
                }
            }


        )
    }
}

 */

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen(homeViewModel = HomeViewModel(SavedStateHandle()), rememberNavController())
}

