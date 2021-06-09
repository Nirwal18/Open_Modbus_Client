package com.nirwal.openmodbusclient.ui.component

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.nirwal.openmodbusclient.model.ModBusDeviceType
import com.nirwal.openmodbusclient.ui.Screen
import com.nirwal.openmodbusclient.ui.component.addProject.AddProjectViewModel


@Composable
fun AddProject(_viewModel:AddProjectViewModel,navController:NavController) {
    val project by remember {
        mutableStateOf(_viewModel.getProject())
    }

    var isEdited by remember { mutableStateOf(false) }
    var showTitleDialog by remember { mutableStateOf(false) }
    var showComDialog by remember { mutableStateOf(false) }
    var showDeviceDialog by remember { mutableStateOf(false) }
    var showDeviceAddDialog by remember { mutableStateOf(false) }
    var showStationIdDialog by remember { mutableStateOf(false) }


    Surface(modifier = Modifier.fillMaxSize()) {


        Card(
            modifier = Modifier
                .wrapContentSize()
                .padding(8.dp),
            elevation = 10.dp
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            ) {


                Text(
                    text = project.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable(enabled = isEdited, onClick = {
                            showTitleDialog = true
                        }),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h4
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = "Communication type :",
                        modifier = Modifier.weight(.5f),
                        style = MaterialTheme.typography.subtitle1
                    )

                    Text(
                        text = project.comType,
                        modifier = Modifier
                            .weight(.5f)
                            .clickable(enabled = isEdited, onClick = {
                                showComDialog = true
                            }),
                        style = MaterialTheme.typography.subtitle2
                    )


                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = "Device :",
                        modifier = Modifier.weight(.5f),
                        style = MaterialTheme.typography.subtitle1
                    )

                    Text(
                        text = project.device,
                        modifier = Modifier
                            .weight(.5f)
                            .clickable(enabled = isEdited, onClick = {
                                showDeviceDialog = true
                            }),
                        style = MaterialTheme.typography.subtitle2
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = "Device Address :",
                        modifier = Modifier.weight(.5f),
                        style = MaterialTheme.typography.subtitle1
                    )

                    Text(
                        text = project.communicationAddress,
                        modifier = Modifier
                            .weight(.5f)
                            .clickable(enabled = isEdited,
                                onClick = {
                                    showDeviceAddDialog = true
                                }),
                        style = MaterialTheme.typography.subtitle2
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = "Station ID :",
                        modifier = Modifier.weight(.5f),
                        style = MaterialTheme.typography.subtitle1
                    )

                    Text(
                        text = project.deviceId.toString(),
                        modifier = Modifier
                            .weight(.5f)
                            .clickable(
                                enabled = isEdited,
                                onClick = {
                                    showStationIdDialog = true
                                }),
                        style = MaterialTheme.typography.subtitle2
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                //

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    if (isEdited) {
                        OutlinedButton(
                            onClick = {
                                isEdited = false
                                _viewModel.updateProject(project)
                            }
                        ) {
                            Text(text = "Save")
                        }

                        OutlinedButton(
                            onClick = {
                                project.updateCurrent( _viewModel.getProject())
                                Log.d("TAG", "AddProject: "+_viewModel.getProject().title)
                               // isEdited = false
                            }
                        ) {
                            Text(text = "Cancel")
                        }
                    } else {

                        // Edit Button
                        OutlinedButton(
                            onClick = {isEdited =true}
                        ) {
                            Text(text = "Edit")
                        }

                        OutlinedButton(
                            onClick = {
                                navController.navigate(Screen.RegisterMap.route) {
                                    launchSingleTop = true
                                }
                            }
                        ) {
                            Text(text = "GOTO Register map")
                        }

                    }

                }
            }

        }

        // INFO: Dialog show hide logic


            if (showTitleDialog) {
                OpenDialog(
                    defaultValue = project.title,
                    dialogTitle = "Project title",
                    onClick = { value, isOk ->
                        if (isOk) {
                            project.title = value
                        }

                        showTitleDialog = false
                    }
                )
            }

            if (showComDialog) {
                OpenDialog(
                    defaultValue = project.comType,
                    dialogTitle = "Communication type",
                    onClick = { value, isOk ->
                        if (isOk) {
                            project.comType = value
                        }

                        showComDialog = false
                    }
                )
            }

            if (showDeviceDialog) {
                OpenDialog(
                    defaultValue = project.device,
                    dialogTitle = "Device",
                    onClick = { value, isOk ->
                        if (isOk) {
                            project.device = value
                        }
                        showDeviceDialog = false
                    }
                )
            }

            if (showDeviceAddDialog) {
                OpenDialog(
                    defaultValue = project.communicationAddress,
                    dialogTitle = "Device Address",
                    onClick = { value, isOk ->
                        if (isOk) {
                            project.communicationAddress = value
                        }
                        showDeviceAddDialog = false
                    }
                )
            }

            if (showStationIdDialog) {
                OpenDialog(
                    defaultValue = project.deviceId.toString(),
                    dialogTitle = "Station ID",
                    onClick = { value, isOk ->
                        if (isOk) {
                            project.deviceId = value.toInt()
                        }
                        showStationIdDialog = false
                    }
                )
            }
        }


}


@Composable
fun OpenDialog(dialogTitle:String, defaultValue:String, onClick: (value:String,isOk:Boolean)-> Unit) {

    var mValue by remember { mutableStateOf(defaultValue) }
    var showDialog by remember { mutableStateOf(true) }
    if (showDialog) {


        Dialog(
            onDismissRequest = { showDialog = true },
            content = {
                Surface(
                    color = MaterialTheme.colors.surface,
                    shape = MaterialTheme.shapes.medium
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = mValue,
                            onValueChange = { mValue = it },
                            enabled = true,
                            label = { Text(text = dialogTitle) }
                        )

                        Row(
                            modifier = Modifier.padding(top = 8.dp),
                            horizontalArrangement = Arrangement.spacedBy(
                                8.dp, alignment = Alignment.CenterHorizontally
                            )
                        ) {
                            OutlinedButton(
                                onClick = {
                                    showDialog = false
                                    onClick("",false)
                                          },
                                modifier = Modifier.weight(weight = 1f)
                            ) {
                                Text(text = "CANCEL")
                            }
                            OutlinedButton(
                                onClick = {
                                    onClick(mValue, true)
                                    showDialog = false

                                },
                                modifier = Modifier.weight(weight = 1f)
                            ) {
                                Text(text = "OK")
                            }
                        }
                    }
                }

            }
        )
    }
}




