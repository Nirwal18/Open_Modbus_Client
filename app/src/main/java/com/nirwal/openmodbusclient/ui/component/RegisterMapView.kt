package com.nirwal.openmodbusclient.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nirwal.openmodbusclient.customWidget.CustomOutlineDropDown1


@Composable
fun RegisterMapView() {
    var registerAdd by remember { mutableStateOf("0001")}
    var registerCount by remember { mutableStateOf("10")}

    var count by remember {
        mutableStateOf(0)
    }

    Column(modifier = Modifier.padding(8.dp)) {


        Row(horizontalArrangement = Arrangement.SpaceBetween,) {
            OutlinedTextField(
                modifier = Modifier
                    .weight(0.6f)
                    .padding(end = 4.dp),
                value = registerAdd,
                onValueChange = { registerAdd = it },
                label = { Text("Register Address") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )


            OutlinedTextField(
                modifier = Modifier
                    .weight(0.4f)
                    .padding(start = 4.dp),
                value = registerCount,
                onValueChange = { registerCount = it },
                label = { Text("Address Count") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }

        Spacer(Modifier.height(8.dp))

        CustomOutlineDropDown1(
            title = "Data Type",
            items = listOf("HEX","DEC","BIN","FLOAT 16"),
            onClick={}
        )

        Spacer(Modifier.height(16.dp))


        LazyColumn {

            items(count = registerCount.toInt()) {

                RegisterItem(address = it.toString(), data = "100", unit = "DEC")
                Spacer(Modifier.height(8.dp))


            }

        }
    }


}

/*
fun RegisterConstrainSet():ConstraintSet{
    return( ConstraintSet {
        val editText1 = createRefFor("editText1")
        val editText2 = createRefFor("editText2")
        val myLazyList = createRefFor("myLazyList")

        constrain(editText1){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(editText2.start)
            width = Dimension.percent(.4f)
        }
        constrain(editText2){
            top.linkTo(editText1.top)
            start.linkTo(editText1.end)
            end.linkTo(parent.end)
            width = Dimension.percent(.4f)

        }
        constrain(myLazyList){
            top.linkTo(editText1.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
        }



    })

}

 */

@Composable
fun RegisterItem(address:String, data:String, unit:String){
    Card( modifier = Modifier.fillMaxWidth(),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(
                text = address,
                style = MaterialTheme.typography.subtitle2
            )
            Row {

                Text(
                    text = data,
                    style = MaterialTheme.typography.body1
                )
                Text(
                    text = unit,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(start = 4.dp)
                )

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun RegisterMapViewPreview(){

 RegisterMapView()

//    RegisterItem(address = "100", data = "23AA", unit ="HEX" )
}

