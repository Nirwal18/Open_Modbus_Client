package com.nirwal.openmodbusclient.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nirwal.openmodbusclient.ui.Screen
import kotlinx.coroutines.launch



@Composable
fun MyDrawer(onClick: (route:String) -> Unit){
    
    val navigationList = listOf(Screen.Home,Screen.AddProject,Screen.Notification)
    var selected by remember { mutableStateOf(Screen.Home.route) }

    Column(modifier = Modifier.padding(8.dp)) {

        navigationList.forEach{
                item->


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .background(
                     if(selected==item.route) Color(0x336200EE) else MaterialTheme.colors.onPrimary
                    )
                    .clickable(
                        enabled = true,
                        onClick = {
                            selected = item.route
                            onClick(item.route)
                        }
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {


                   Icon(
                       modifier = Modifier
                           .padding(start = 16.dp)
                           .width(24.dp)
                           .height(24.dp),
                       imageVector = item.imageVector,
                       contentDescription = "Home",
                       tint = if(selected==item.route)MaterialTheme.colors.primaryVariant else Color.Gray
                   )

                   Text(
                       text = stringResource(id = item.titleStringId),
                       textAlign = TextAlign.Center,
                       modifier = Modifier.padding(start = 16.dp),
                       color = if(selected==item.route)MaterialTheme.colors.primaryVariant else Color.Gray
                   )


               }




            Spacer(modifier = Modifier.height(8.dp)) 
        }
        
       
    }
}