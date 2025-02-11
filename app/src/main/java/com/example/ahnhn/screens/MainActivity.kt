package com.example.ahnhn.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.ahnhn.ui.theme.AhnHnTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AhnHnTheme {
                val navController = rememberNavController()
                val start = remember { mutableStateOf(false) }
                val coffee = remember { mutableStateOf(false) }
                val recipes = remember { mutableStateOf(false) }
                NavHost(
                    navController = navController,
                    startDestination = "start"
                ){
                    composable("coffee"){
                        Coffee(navController,
                            coffee = coffee)
                    }
                    composable("start"){
                        MyMood(navController,
                            start = start)
                    }
                    composable("recipes"){
                        Recipe(navController,
                            recipes = recipes
                        )
                    }
                }
            }
        }
    }
}
