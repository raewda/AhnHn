package com.example.ahnhn.screens

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ahnhn.dcl.coffeeMore

import com.example.ahnhn.ui.theme.AhnHnTheme


class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
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

                    // recipes/{id} - передаю параметр id, navArgument задаёт получаемые аргументы, несколько через запятую. arguments требует передачу параметров

                    composable("recipes/{id}", arguments = listOf(navArgument("id"){
                        NavType.StringType
                    })){
                        Recipe(navController,
                            recipes = recipes,
                            item = coffeeMore.getById(it.arguments?.getString("id")!!.toInt())
                        )
                    }
                }
            }
        }
    }
}
