package com.example.ahnhn.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
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
import com.example.ahnhn.ui.theme.two

@Composable
fun Coffee(
    navController: NavHostController,
    coffee: MutableState<Boolean>,
) {

    val recipes = listOf(
        sc, cclatte, pc, hamfw, ps, wc, cbwsasf, vc, sil, pbem, jccs, mimm, tfc, fic, mbd, acbs, a, yppil, cghc, icm
    )

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = five,
        bottomBar =
        {
            BottomAppBar(
                actions = {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        TextButton(onClick = {
                            navController.navigate("coffee")
                        }) {
                            Text(
                                "coffee", color = three, fontFamily = shadows, fontSize = 36.sp
                            )
                        }
                        TextButton(onClick = {
                            navController.navigate("start")
                        }) {
                            Text(
                                "my mood", color = one, fontFamily = shadows, fontSize = 36.sp
                            )
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth(),
                containerColor = two
            )
        })
    { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        )
        {
            Text(
                text = "More Coffee",
                color = three,
                fontFamily = shadows,
                fontSize = 36.sp,
                modifier = Modifier
                    .padding(horizontal = 10.dp)
            )

            LazyColumn(
                modifier = Modifier,
                horizontalAlignment = Alignment.End
            ) {
                items(recipes) { item ->
                    coffeeMoreColumn(item)

                }
            }
        }
    }
}

@Composable
fun coffeeMoreColumn(item: coffeeMore) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp)
            .padding(horizontal = 15.dp)
            .height(100.dp),
        colors = CardDefaults.cardColors(three)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(vertical = 5.dp)
                .padding(horizontal = 15.dp),
            horizontalArrangement = Arrangement.Absolute.SpaceAround
        ) {

            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(60F, true)
            ) {
                Text(
                    text = stringResource(item.name),
                    fontSize = 20.sp,
                    fontFamily = shadows,
                    color = two,
                    modifier = Modifier,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Image(
                painter = painterResource(item.picture),
                contentDescription = "image",
                modifier = Modifier
                )

            TextButton(
                onClick = {
                    ""
                },
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(end = 10.dp)
            ) {
                Text(
                    text = "more...",
                    fontSize = 24.sp,
                    fontFamily = shadows,
                    color = one
                )
            }

        }
    }
}


