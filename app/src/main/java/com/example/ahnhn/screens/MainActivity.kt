package com.example.ahnhn.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.sp
import com.example.ahnhn.ui.theme.AhnHnTheme
import com.example.ahnhn.ui.theme.five
import com.example.ahnhn.ui.theme.one
import com.example.ahnhn.ui.theme.shadows
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
                                Row(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    horizontalArrangement = Arrangement.SpaceAround
                                ) {
                                    TextButton(
                                        onClick = {}
                                    ) {
                                        Text(
                                            "coffee",
                                            color = one,
                                            fontFamily = shadows,
                                            fontSize = 36.sp
                                        )
                                    }
                                    TextButton(
                                        onClick = {}
                                    ) {
                                        Text(
                                            "my mood",
                                            color = three,
                                            fontFamily = shadows,
                                            fontSize = 36.sp
                                        )
                                    }
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth(),
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
