package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonApp() {
    var currentStep by remember { mutableStateOf(1) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Lemonade",
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFFFFF00)
                ),
                modifier = Modifier.statusBarsPadding()
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = MaterialTheme.colorScheme.background
        ) {
            when (currentStep) {
                1 -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Image(
                            painter = painterResource(R.drawable.lemon_tree),
                            contentDescription = "Árvore de Limão",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .wrapContentSize()
                                .clickable { currentStep = 2 }
                                .clip(RoundedCornerShape(16.dp))
                                .background(Color(0xFFC3ECD2))
                                .padding(20.dp, 8.dp)
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        Text(text = stringResource(R.string.lemon_tree))
                    }
                }
                2 -> {
                    var randomValue = (2..4).random()
                    var click = 0
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Image(
                            painter = painterResource(R.drawable.lemon_squeeze),
                            contentDescription = "Lemon",
                            modifier = Modifier
                                .wrapContentSize()
                                .clickable {
                                    if (click == randomValue) {
                                        currentStep = 3
                                    } else {
                                        click++
                                    }
                                }
                                .clip(RoundedCornerShape(16.dp))
                                .background(Color(0xFFC3ECD2))
                                .padding(20.dp, 8.dp)
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        Text(text = stringResource(R.string.lemon))
                    }
                }
                3 -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Image(
                            painter = painterResource(R.drawable.lemon_drink),
                            contentDescription = "Lemon Drink",
                            modifier = Modifier
                                .wrapContentSize()
                                .clickable { currentStep = 4 }
                                .clip(RoundedCornerShape(16.dp))
                                .background(Color(0xFFC3ECD2))
                                .padding(20.dp, 8.dp)
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        Text(text = stringResource(R.string.glass_of_lemonade))
                    }
                }
                4 -> {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Image(
                            painter = painterResource(R.drawable.lemon_restart),
                            contentDescription = "Empty Glass",
                            modifier = Modifier
                                .wrapContentSize()
                                .clickable { currentStep = 1 }
                                .clip(RoundedCornerShape(16.dp))
                                .background(Color(0xFFC3ECD2))
                                .padding(20.dp, 8.dp)
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        Text(text = stringResource(R.string.empty_glass))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonApp()
    }
}
