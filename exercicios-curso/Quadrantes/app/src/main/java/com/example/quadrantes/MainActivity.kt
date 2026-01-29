package com.example.quadrantes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quadrantes.ui.theme.QuadrantesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuadrantesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        title1 = "Text composable\n",
                        text1 = "Displays text and follows the recommended Material Design guidelines.\n",
                        title2 = "Image composable\n",
                        text2 = "Creates a composable that lays out and draws a given Painter class object.\n",
                        title3 = "Row composable\n",
                        text3 = "A layout composable that places its children in a horizontal sequence.\n",
                        title4 = "Column composable\n",
                        text4 = "A layout composable that places its children in a vertical sequence.\n",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(title1: String, title2: String, title3: String, title4: String, text1: String,
             text2: String, text3: String, text4: String,modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row(modifier = Modifier.weight(1f)) {
            Quadrante(
                title = title1,
                text = text1,
                modifier = Modifier.weight(1f) .background(Color(0xFFEADDFF))
            )
            Quadrante(
                title = title2,
                text = text2,
                modifier = Modifier.weight(1f) .background(Color(0xFFD0BCFF))
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            Quadrante(
                title = title3,
                text = text3,
                modifier = Modifier.weight(1f) .background(Color(0xFFB69DF8))
            )
            Quadrante(
                title = title4,
                text = text4,
                modifier = Modifier.weight(1f) .background(Color(0xFFF6EDFF))
            )
        }
    }
}

@Composable
fun Quadrante(title: String, text: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize() .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = text
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    QuadrantesTheme {
        Greeting(
            title1 = "Text composable\n",
            text1 = "Displays text and follows the recommended Material Design guidelines.\n",
            title2 = "Image composable\n",
            text2 = "Creates a composable that lays out and draws a given Painter class object.\n",
            title3 = "Row composable\n",
            text3 = "A layout composable that places its children in a horizontal sequence.\n",
            title4 = "Column composable\n",
            text4 = "A layout composable that places its children in a vertical sequence.\n"
        )
    }
}