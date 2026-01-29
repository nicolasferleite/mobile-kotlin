package com.example.calculadoraimc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculadoraimc.ui.theme.CalculadoraImcTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculadoraImcTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    calculadoraLayout(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun calculadoraLayout(modifier: Modifier) {
    var pesoInput by remember { mutableStateOf("") }
    var alturaInput by remember { mutableStateOf("") }

    var pesoParaCalcular by remember { mutableStateOf<Double?>(null) }
    var alturaParaCalcular by remember { mutableStateOf<Double?>(null) }
    var exibirResultado by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = stringResource(R.string.calc_imc),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 64.dp)
                .align(Alignment.Start)
        )

        EditNumberField(
            value = pesoInput,
            onValueChange = { pesoInput = it },
            label = R.string.peso,
            leadingIcon = R.drawable.peso,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )

        EditNumberField(
            value = alturaInput,
            onValueChange = { alturaInput = it },
            label = R.string.altura,
            leadingIcon = R.drawable.altura,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
        )

        Button(
            onClick = {
                val peso = pesoInput.toDoubleOrNull()
                val altura = alturaInput.toDoubleOrNull()

                exibirResultado = true

                if (peso != null && altura != null && altura > 0) {
                    pesoParaCalcular = peso
                    alturaParaCalcular = altura
                } else {
                    pesoParaCalcular = null
                    alturaParaCalcular = null
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        ) {
            Text(text = stringResource(R.string.calcular))
        }

        if (exibirResultado) {
            if (pesoParaCalcular != null && alturaParaCalcular != null) {
                CalculateImc(peso = pesoParaCalcular!!, altura = alturaParaCalcular!!)
            } else {
                Text(
                    text = "Digite valores válidos para peso e altura",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}

@Composable
fun EditNumberField(
    @StringRes label: Int,
    @DrawableRes leadingIcon: Int,
    keyboardOptions: KeyboardOptions,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        leadingIcon = {
            Icon(
                painter = painterResource(id = leadingIcon),
                contentDescription = null,
                modifier = Modifier.size(28.dp)
            )
        },
        singleLine = true,
        label = { Text(stringResource(label)) },
        keyboardOptions = keyboardOptions,
        modifier = modifier
    )
}

@Composable
fun CalculateImc(peso: Double, altura: Double) {
    val imc = peso / (altura * altura)
    val categoria = when {
        imc < 17 -> stringResource(R.string.categoria1)
        imc < 18.5 -> stringResource(R.string.categoria2)
        imc < 25 -> stringResource(R.string.categoria3)
        imc < 30 -> stringResource(R.string.categoria4)
        imc < 35 -> stringResource(R.string.categoria5)
        imc < 40 -> stringResource(R.string.categoria6)
        else -> stringResource(R.string.categoria7)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 24.dp)
    ) {
        Text(text = "Seu IMC é: %.2f".format(imc))
        Text(text = "Classificação: $categoria")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculadoraImcTheme {
        calculadoraLayout(modifier = Modifier)
    }
}