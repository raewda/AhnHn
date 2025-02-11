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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ahnhn.R
import com.example.ahnhn.dcl.coffeeMore
import com.example.ahnhn.dcl.coffeeMore.a
import com.example.ahnhn.dcl.coffeeMore.acbs
import com.example.ahnhn.dcl.coffeeMore.cbwsasf
import com.example.ahnhn.dcl.coffeeMore.cclatte
import com.example.ahnhn.dcl.coffeeMore.cghc
import com.example.ahnhn.dcl.coffeeMore.fic
import com.example.ahnhn.dcl.coffeeMore.hamfw
import com.example.ahnhn.dcl.coffeeMore.icm
import com.example.ahnhn.dcl.coffeeMore.jccs
import com.example.ahnhn.dcl.coffeeMore.mbd
import com.example.ahnhn.dcl.coffeeMore.mimm
import com.example.ahnhn.dcl.coffeeMore.pbem
import com.example.ahnhn.dcl.coffeeMore.pc
import com.example.ahnhn.dcl.coffeeMore.ps
import com.example.ahnhn.dcl.coffeeMore.sc
import com.example.ahnhn.dcl.coffeeMore.sil
import com.example.ahnhn.dcl.coffeeMore.tfc
import com.example.ahnhn.dcl.coffeeMore.vc
import com.example.ahnhn.dcl.coffeeMore.wc
import com.example.ahnhn.dcl.coffeeMore.yppil
import com.example.ahnhn.ui.theme.five
import com.example.ahnhn.ui.theme.four
import com.example.ahnhn.ui.theme.one
import com.example.ahnhn.ui.theme.shadows
import com.example.ahnhn.ui.theme.three

@Composable
fun Recipe(
    navController: NavHostController,
    recipes: MutableState<Boolean>,
) {
    val recipes = listOf(
        sc, cclatte, pc, hamfw, ps, wc, cbwsasf, vc, sil, pbem, jccs, mimm, tfc, fic, mbd, acbs, a, yppil, cghc, icm
    )

    val scrollState = rememberScrollState()

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = five
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(scrollState,true, null, false)
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

            Text(
                "Jopa",
                fontSize = 44.sp,
                fontFamily = shadows,
                color = three,
                modifier = Modifier
                    .padding(horizontal = 10.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.aimage),
                    contentDescription = "image",
                    modifier = Modifier
                        .size(300.dp)
                )
            }

            Text(
                text = "ingredients",
                modifier = Modifier
                    .padding(horizontal = 10.dp),
                fontSize = 24.sp,
                fontFamily = shadows,
                color = four
            )

            Text(
                text = "recipe",
                modifier = Modifier
                    .padding(horizontal = 10.dp),
                fontSize = 24.sp,
                fontFamily = shadows,
                color = three
            )

        }
    }
}
