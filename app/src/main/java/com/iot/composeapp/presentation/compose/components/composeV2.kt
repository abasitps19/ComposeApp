package com.iot.composeapp.presentation.compose.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun ChekBoxActivity(context: Context){
    var checked by remember { mutableStateOf(false) }
    Checkbox(
        checked = checked,
        { isChecked ->
            checked = isChecked
            Toast.makeText(
                context,
                "Is Checked:  $checked",
                Toast.LENGTH_SHORT
            ).show()

        }
    )
}

@Composable
fun switchActivity(context: Context) {
    var isChecked by remember { mutableStateOf(false) }

    Switch(
        checked = isChecked,
        onCheckedChange = {
            isChecked = it

            Toast.makeText(
                context,
                "you chosed $isChecked",
                Toast.LENGTH_LONG

            ).show()
        })
}

@Composable
fun RadioButtonActivity(context: Context){
    var selectedOption by remember {
        mutableStateOf("Option 1")
    }
    Column() {
        RadioButtonRow( "Option 1",
            selectedOption == "Option 1",
            { selectedOption = "Option 1"}

        )
        RadioButtonRow( "Option 2",
            selectedOption == "Option 2",
            { selectedOption = "Option 2"}

        )
        RadioButtonRow( "Option 3",
            selectedOption == "Option 3",
            { selectedOption = "Option 3"}

        )


    }
}

@Composable
fun RadioButtonRow(text:String, isSelected: Boolean, onSelected:()-> Unit){

    Row(verticalAlignment = Alignment.CenterVertically){
        RadioButton(
            selected = isSelected,
            onClick = onSelected,
            modifier = Modifier.padding(vertical = 4.dp)
        )
        Text(text = text)

    }

}

@Composable
fun ProgressIndicatiorActivity(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Column() {
            CircularProgressIndicator()
            Spacer(modifier = Modifier.padding(vertical = 10.dp))
            CircularProgressIndicator(0.7f, color = Color.Red)
            Spacer(modifier = Modifier.padding(vertical = 20.dp))
            LinearProgressIndicator(progress = 0.6f,
                color = Color.Red,
                trackColor = Color.Yellow
            )
        }
    }
}

@Composable
fun IncicateProgress(progress: Float){
    LinearProgressIndicator(progress,color = Color.Red, trackColor = Color.Yellow)
}

@Composable
fun IncreassProgress(onClick: ()-> Unit){
    Button(onClick = onClick) { Text(text="Increase Progress")}
}

@Composable
fun ProgressText(progress: Float){
    Text(text = "Progress is $progress")
}

@Composable
fun ColumnActivity(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()


    ) {
        Text(text="Top Line")
        Text(text = "Middle Line")
        Text(text = "Bottom Line")

    }
}


@Composable
fun LinearProgressActivity(){
    var progress by remember { mutableStateOf(0.0f) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(verticalArrangement = Arrangement.Center) {
            IncicateProgress(progress)
            IncreassProgress{
                progress += 0.1f
                if(progress > 1.0f){
                    progress = 0.0f
                }
            }
            ProgressText(progress)
        }
    }

}

