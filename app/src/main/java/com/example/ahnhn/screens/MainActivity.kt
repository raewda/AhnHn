package com.example.ahnhn.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.ui.Modifier
import com.example.ahnhn.ui.theme.AhnHnTheme
import com.example.ahnhn.ui.theme.five
import com.example.ahnhn.ui.theme.one
import com.example.ahnhn.ui.theme.three
import com.example.ahnhn.ui.theme.two

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AhnHnTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),
                    containerColor = five,
                    bottomBar = {
                        BottomAppBar (
                            actions = {
                                TextButton(
                                    onClick = {}
                                ) {
                                    Text("coffee",
                                        color = one
                                    )
                                }
                                TextButton(
                                    onClick = {}
                                ) {
                                    Text("my mood",
                                        color = three
                                    )
                                }
                            },
                            modifier = Modifier,
                            containerColor = two
                        )
                    }
                )
                { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {

                    }


                }
            }
        }
    }
}
