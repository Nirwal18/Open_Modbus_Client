package com.nirwal.openmodbusclient.customWidget

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.nirwal.openmodbusclient.model.ModBusDeviceType

@Composable
fun CustomOutlineDropDown1(
    modifier: Modifier=Modifier,
    title:String,
    items:List<String>,
    onClick: (position: Int) -> Unit
){
    var expanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(0) }



    Box(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = { expanded = true }),
        contentAlignment = Alignment.CenterStart
    ) {


        OutlinedTextField(
            value = if(selectedIndex==0)"" else items[selectedIndex],
            onValueChange = {},
            enabled = false,
            label = { Text(text = title) },
            modifier = Modifier.fillMaxWidth()
        )

        DropdownMenu(
            modifier = Modifier
                .background(MaterialTheme.colors.surface)
                .fillMaxWidth(),
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            items.forEachIndexed { index, s ->
                DropdownMenuItem(
                    onClick = {
                            selectedIndex = index
                            expanded = false
                            onClick(index)
                    }) {

                    Text(text = s)
                }
            }
        }
    }
}

@Composable
fun CustomOutlineDropDown(modifier: Modifier, items:List<String>,onClick: (position: Int) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val items = ModBusDeviceType.toList
    var selectedIndex by remember { mutableStateOf(0) }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .border(width = 1.dp, color = Color.Gray, shape = MaterialTheme.shapes.medium)
            .clickable(onClick = { expanded = true }),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(items[selectedIndex],modifier = Modifier.padding(start = 16.dp))
        DropdownMenu(
            modifier = Modifier
                .background(MaterialTheme.colors.surface)
                .fillMaxWidth(),
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            items.forEachIndexed { index, s ->
                DropdownMenuItem(
                    onClick = {
                        selectedIndex = index
                        expanded = false
                        onClick(index)
                    }) {

                    Text(text = s)
                }
            }
        }
    }
}
