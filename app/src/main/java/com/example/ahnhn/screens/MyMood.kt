package com.example.ahnhn.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ahnhn.dcl.Horoscope
import com.example.ahnhn.ui.theme.five
import com.example.ahnhn.ui.theme.four
import com.example.ahnhn.ui.theme.one
import com.example.ahnhn.ui.theme.shadows
import com.example.ahnhn.ui.theme.three
import com.example.ahnhn.ui.theme.two

@Composable
fun MyMood(
    navController: NavHostController,
    start: MutableState<Boolean>,
    horoscope: Horoscope,
) {
    val signs = listOf(
        "aries",
        "taurus",
        "gemini",
        "cancer",
        "leo",
        "virgo",
        "libra",
        "scorpio",
        "sagittarius",
        "capricorn",
        "aquarius",
        "pisces"
    )
    val zodiacName = remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = five,
        bottomBar = {
            BottomAppBar(
                actions = {
                    Row(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        TextButton(
                            onClick = {
                                navController.navigate("coffee")
                            }
                        ) {
                            Text(
                                "coffee",
                                color = one,
                                fontFamily = shadows,
                                fontSize = 36.sp
                            )
                        }
                        TextButton(
                            onClick = {
                                navController.navigate("start")
                            }
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
                .fillMaxSize(),
            horizontalAlignment = Alignment.Start
        ) {

            Text(
                "Sweat day",
                fontSize = 44.sp,
                fontFamily = shadows,
                color = three
            )

            LazyRow(
                modifier = Modifier
            ) {
                items(signs) { item ->
                    for (i in 0..signs.size) {
                        Button(
                            onClick = {
                                zodiacName.value = signs[i]
                            },
                            modifier = Modifier
                                .size(40.dp, 20.dp),
                            colors = ButtonDefaults.buttonColors(one)
                        ) {
                            Text(
                                text = zodiacName.value,
                                fontSize = 20.sp,
                                fontFamily = shadows,
                                color = four
                            )

                        }
                    }
                }

            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                horoscope.personal_life?.let {
                    Text(
                        text = it,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 8.dp)
                    )
                }
                horoscope.profession?.let {
                    Text(
                        text = it,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 8.dp)
                    )
                }
                horoscope.health?.let {
                    Text(
                        text = it,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 8.dp)
                    )
                }
                horoscope.emotions?.let {
                    Text(
                        text = it,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 8.dp)
                    )
                }
                horoscope.travel?.let {
                    Text(
                        text = it,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 8.dp)
                    )
                }
                horoscope.luck?.let {
                    Text(
                        text = it,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 4.dp, bottom = 8.dp)
                    )
                }

            }
        }
    }
}