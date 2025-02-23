package com.example.ahnhn.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ahnhn.dcl.coffeeMore
import com.example.ahnhn.ui.theme.five
import com.example.ahnhn.ui.theme.four
import com.example.ahnhn.ui.theme.one
import com.example.ahnhn.ui.theme.shadows
import com.example.ahnhn.ui.theme.three

@Composable
fun Recipe(
    navController: NavHostController,
    recipes: MutableState<Boolean>,
    item: coffeeMore
) {
    val scrollState = rememberScrollState()

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = five
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(scrollState, true, null, false)
        ) {

            TextButton(
                onClick = {
                    navController.navigate("coffee")
                }
            ) {
                Text(
                    text = "back",
                    fontSize = 24.sp,
                    fontFamily = shadows,
                    color = one
                )
            }

            coffeeRecipe(item)

        }
    }
}

@Composable
fun coffeeRecipe(
    item: coffeeMore
) {
    Text(
        text = stringResource(item.name),
        fontSize = 44.sp,
        fontFamily = shadows,
        color = three,
        modifier = Modifier
            .padding(horizontal = 10.dp),
        lineHeight = 50.sp
    )

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(item.picture),
            contentDescription = "image",
            modifier = Modifier
                .size(300.dp)
        )
    }

    Text(
        text = stringResource(item.ingredients),
        modifier = Modifier
            .padding(horizontal = 10.dp),
        fontSize = 24.sp,
        fontFamily = shadows,
        color = four
    )

    Text(
        text = stringResource(item.recipe),
        modifier = Modifier
            .padding(horizontal = 10.dp),
        fontSize = 24.sp,
        fontFamily = shadows,
        color = three
    )
}
