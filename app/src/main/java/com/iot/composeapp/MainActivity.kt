package com.iot.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgs
import androidx.navigation.navArgument
import com.iot.composeapp.presentation.grocery.LazyColumnWithStickyHeader
import com.iot.composeapp.presentation.navgations.Screen1Argu
import com.iot.composeapp.presentation.navgations.Screen1Simple
import com.iot.composeapp.presentation.navgations.Screen2Argu
import com.iot.composeapp.presentation.navgations.Screen2Simple
import com.iot.composeapp.ui.theme.ComposeAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
       //TestUI()
        TestNavigation()

    }

    fun TestNavigation() = setContent {
        ComposeAppTheme {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                //Navigation controller NavController
                //Navigation between composable
                val navController = rememberNavController()

                //Navigation Host
                //defines the nave graph, start and composable destination
                NavHost(navController = navController,
                    startDestination = "first") {
                    //define first composable screen
                    composable("first"){ Screen1Argu(navController) }
                    composable(
                        route = "second/{userName}/{Age}",
                        arguments = listOf(
                            //passing a list of named nav args
                            navArgument(name = "userName"){ type = NavType.StringType},
                            navArgument(name="Age"){ type = NavType.StringType}

                        )
                    ){
                        backStackEntry ->
                        Screen2Argu(
                            navController,
                            backStackEntry.arguments?.getString("userName").toString(),
                            backStackEntry.arguments?.getString("Age").toString()
                        ) }
                }
            }
        }

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
