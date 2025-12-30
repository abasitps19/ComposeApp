package com.iot.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.iot.composeapp.presentation.compose.components.ScanfActivity
import com.iot.composeapp.presentation.grocery.LazyColumnWithStickyHeader
import com.iot.composeapp.presentation.lists.components.MyCard
import com.iot.composeapp.presentation.lists.components.MyList
import com.iot.composeapp.ui.theme.ComposeAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
       TestUI()

    }

    fun TestUI() = setContent{
        //setContent {
            ComposeAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    //ChekBoxActivity(this)
                    //switchActivity(context = this)
                    //RadioButtonActivity()
                    //ProgressIndicatiorActivity()
                    //LinearProgressActivity()
                    //ColumnActivity()

                    //ScanfActivity(this)
                    //MyCard()
                    LazyColumnWithStickyHeader()


                    // Counter()
                    // TextAndButtons()



                }

            }

//        }
    }

}














/* Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
OTALogin("BLE OTA", "Connecting to device",
    modifier = Modifier.padding(innerPadding))

 */
/*
val viewModel = hiltViewModel<BluetoothViewModel>()

val state by viewModel.state.collectAsState()
Surface(
color = MaterialTheme.colors.background

) {
DeviceScreen(
    state = state,
    onStartScan = viewModel::startScan,
    onStopScan = viewModel::stopScan
)
}
*/
