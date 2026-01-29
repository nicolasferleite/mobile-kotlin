package com.example.gallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gallery.ui.theme.GalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GalleryTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GalleryLayout(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun GalleryLayout(modifier: Modifier = Modifier) {
    var currentStep by remember { mutableStateOf(1) }

    when (currentStep) {
        1 -> PageGallery(
            imageRes = R.drawable.fallen,
            titleRes = R.string.fallen1,
            subtitleRes = R.string.fallen2,
            currentStep = currentStep,
            onNext = { currentStep++ },
            onBack = { currentStep-- }
        )

        2 -> PageGallery(
            imageRes = R.drawable.yuurih,
            titleRes = R.string.yuurih1,
            subtitleRes = R.string.yuurih2,
            currentStep = currentStep,
            onNext = { currentStep++ },
            onBack = { currentStep-- }
        )

        3 -> PageGallery(
            imageRes = R.drawable.yekindar,
            titleRes = R.string.yekindar1,
            subtitleRes = R.string.yekindar2,
            currentStep = currentStep,
            onNext = { currentStep++ },
            onBack = { currentStep-- }
        )

        4 -> PageGallery(
            imageRes = R.drawable.kscerato,
            titleRes = R.string.kscerato1,
            subtitleRes = R.string.kscerato2,
            currentStep = currentStep,
            onNext = { currentStep++ },
            onBack = { currentStep-- }
        )

        5 -> PageGallery(
            imageRes = R.drawable.molodoy,
            titleRes = R.string.molodoy1,
            subtitleRes = R.string.molodoy2,
            currentStep = currentStep,
            onNext = { if (currentStep < 5) currentStep++ },
            onBack = { if (currentStep > 1) currentStep-- }
        )
    }
}

@Composable
fun PageGallery(
    imageRes: Int,
    titleRes: Int,
    subtitleRes: Int,
    currentStep: Int,
    onNext: () -> Unit,
    onBack: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize() .verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(imageRes),
            contentDescription = null,
            modifier = Modifier.size(300.dp)
        )

        Spacer(modifier = Modifier.height(40.dp))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(titleRes),
                fontSize = 48.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(subtitleRes),
                fontSize = 28.sp
            )
        }

        Spacer(modifier = Modifier.height(64.dp))

        Row {
            if (currentStep != 1) {
                Button(onClick = onBack) { Text("BACK") }
            } else {
                Spacer(modifier = Modifier.width(100.dp))
            }

            Spacer(modifier = Modifier.width(24.dp))

            if (currentStep != 5) {
                Button(onClick = onNext) { Text("NEXT") }
            } else {
                Spacer(modifier = Modifier.width(100.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGallery() {
    GalleryTheme {
        PageGallery(
            imageRes = R.drawable.molodoy,
            titleRes = R.string.molodoy1,
            subtitleRes = R.string.molodoy2,
            currentStep = 1,
            onNext = {},
            onBack = {}
        )
    }
}
