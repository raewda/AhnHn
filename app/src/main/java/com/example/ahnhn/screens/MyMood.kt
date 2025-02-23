package com.example.ahnhn.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ahnhn.PreferenceManagerImpl
import com.example.ahnhn.dcl.coffeeMore
import com.example.ahnhn.ui.theme.five
import com.example.ahnhn.ui.theme.four
import com.example.ahnhn.ui.theme.one
import com.example.ahnhn.ui.theme.shadows
import com.example.ahnhn.ui.theme.three
import com.example.ahnhn.ui.theme.two
import com.example.ahnhn.viewm.MyMoodViewModel
import java.util.Date

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MyMood(
    navController: NavHostController,
    start: MutableState<Boolean>,
    viewModel: MyMoodViewModel = MyMoodViewModel()
) {
    // эта штука сохраняет данные ключ-значение
    val date = PreferenceManagerImpl(LocalContext.current)

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

    // смотрим за изменениями во вью модели
    val horoscopeData = viewModel.horoscopeData.collectAsState()

    val scrollState = rememberScrollState()

    val cofrecipe = remember { mutableStateOf(coffeeMore.a as coffeeMore) }

    val colst = remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        val savedDay = date.getString("day")
        if (savedDay == null || Date().date > savedDay.toInt()){
            cofrecipe.value = coffeeMore.randomCoffee()
            date.saveString("id", cofrecipe.value.id.toString())
            date.saveString("day", Date().date.toString())
        }
        else{
            val id = date.getString("id")?.toInt()
            cofrecipe.value = coffeeMore.getById(id?:0)
        }
    }

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
                .fillMaxSize()
                .verticalScroll(scrollState, true, null, false),
            horizontalAlignment = Alignment.Start
        ) {

            Text(
                text = "raewda production",
                modifier = Modifier
                    .padding(start = 10.dp),
                fontSize = 24.sp,
                fontFamily = shadows,
                color = two
            )

            Text(
                "Sweat day",
                fontSize = 44.sp,
                fontFamily = shadows,
                color = four,
                modifier = Modifier
                    .padding(horizontal = 10.dp)
            )

            Column(
                modifier = Modifier
                    .padding(bottom = 10.dp)

            ) {

                CoffeeMoreRandom(cofrecipe.value)

                LazyRow(
                    modifier = Modifier
                ) {
                    items(signs) { item ->
                        Button(
                            onClick = {
                                // передаём стейт зз
                                viewModel.horoscopeGive(item)
                                colst.value = item
                            },
                            modifier = Modifier
                                .padding(horizontal = 2.dp),
                            colors = ButtonDefaults.buttonColors(
                                if (colst.value == item){
                                    five
                                }
                                else{
                                    one
                                }
                            )
                        ) {
                            Text(
                                text = item,
                                fontSize = 20.sp,
                                fontFamily = shadows,
                                color = four
                            )
                        }
                    }

                }

                Column {
                    Text(
                        text = horoscopeData.value.data?.horoscopeData ?: "",
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                            .padding(vertical = 10.dp),
                        fontSize = 24.sp,
                        fontFamily = shadows,
                        color = four
                    )
                }
            }
        }
    }
}

@Composable
fun CoffeeMoreRandom(
    cofrecipe: coffeeMore,
) {
    Text(
        text = stringResource(cofrecipe.name),
        fontSize = 40.sp,
        fontFamily = shadows,
        color = three,
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .fillMaxWidth(),
        lineHeight = 50.sp,
        textAlign = TextAlign.Center
    )

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(cofrecipe.picture),
            contentDescription = "image",
            modifier = Modifier
                .size(300.dp)
        )
    }

    Text(
        text = stringResource(cofrecipe.ingredients),
        modifier = Modifier
            .padding(horizontal = 10.dp),
        fontSize = 24.sp,
        fontFamily = shadows,
        color = four,

    )

    Text(
        text = stringResource(cofrecipe.recipe),
        modifier = Modifier
            .padding(horizontal = 10.dp)
            .padding(bottom = 15.dp),
        fontSize = 24.sp,
        fontFamily = shadows,
        color = three
    )
}