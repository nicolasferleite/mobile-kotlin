package com.example.cartaodevisita

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cartaodevisita.ui.theme.CartaoDeVisitaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CartaoDeVisitaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        title = "Nícolas Ferreira",
                        subTitle = "Android Developer Extraordinaire",
                        numero = "+11 (123) 444 555 666",
                        socialMedia = "@nicolasferreira_l",
                        mail = "nicolasferreiraleite@gmail.com",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(title: String, subTitle: String, numero: String, socialMedia: String, mail:String, modifier: Modifier = Modifier) {
    val logo = painterResource(R.drawable.android_logo)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFD2E8D4))
    ) {
        Box {
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)) {
                Image(
                    painter = logo,
                    contentDescription = null,
                    Modifier.background(Color(0xFF073042)) .height(120.dp) .width(120.dp)
                )
                Text(
                    text = title,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Light,
                    color = Color(0xFF000000)
                )
                Text(
                    text = subTitle,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0C7141)
                )
            }
        }
        Box {
            Column(horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceAround) {
                Row(modifier = Modifier.padding(top = 16.dp)) {
                    Icon(
                        imageVector = Icons.Filled.Call,
                        contentDescription = "Icone de Telefone",
                        tint = Color(0xFF0C7141)
                    )
                    Text(
                        text = numero,
                        modifier = Modifier.padding(start = 16.dp),
                        color = Color(0xFF000000)
                    )
                }
                Row(modifier = Modifier.padding(top = 16.dp)) {
                    Icon(
                        imageVector = Icons.Filled.Share,
                        contentDescription = "Icone de Compartilhar",
                        tint = Color(0xFF0C7141)
                    )
                    Text(
                        text = socialMedia,
                        modifier = Modifier.padding(start = 16.dp),
                        color = Color(0xFF000000)
                    )
                }
                Row(modifier = Modifier.padding(top = 16.dp)) {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = "Icone de Email",
                        tint = Color(0xFF0C7141)
                    )
                    Text(
                        text = mail,
                        modifier = Modifier.padding(start = 16.dp),
                        color = Color(0xFF000000)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CartaoDeVisitaTheme {
        Greeting(
            title = "Nícolas Ferreira Leite",
            subTitle = "Android Developer Extraordinaire",
            numero = "+11 (123) 444 555 666",
            socialMedia = "@nicolasferreira_l",
            mail = "nicolasferreiraleite@gmail.com"
        )
    }
}