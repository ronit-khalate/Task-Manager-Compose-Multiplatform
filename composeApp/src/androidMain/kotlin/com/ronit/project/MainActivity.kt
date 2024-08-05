package com.ronit.project

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import auth.presentation.login.LoginScreen
import auth.presentation.register.RegistrationScreen
import core.navigation.Screen
import task_feature.presentation.TaskListScreen
import task_feature.presentation.components.AddTaskTopBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window,false)

        setContent {

            val navController = rememberNavController()
            NavHost(navController =navController , startDestination = Screen.LoginScreen.route ){

                composable(route = Screen.LoginScreen.route){

                    LoginScreen(navController = navController)
                }

                composable(route= Screen.RegistrationScreen.route){

                    RegistrationScreen()
                }

                composable(route = Screen.AddTaskScreen.route){

                    AddTaskTopBar(innerPadding = 24.dp)
                }

                composable(route = Screen.TaskListScreen.route){
                    TaskListScreen()
                }

            }
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}