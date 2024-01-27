package com.example.gerenciartarefas.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gerenciartarefas.R
import com.example.gerenciartarefas.ui.theme.GerenciarTarefasTheme

class Settings : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GerenciarTarefasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting6("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting6(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .background(color = colorResource(id = R.color.backgroundCinza))
    ) {
        val scope = rememberCoroutineScope()
        Spacer(modifier.width(25.dp))
        TopAppBar(
            title = {
                Row {
                    Spacer(modifier = Modifier.width(25.dp))
                    Text(text = "Configurações", color = Color.White)
                }
            },
            navigationIcon = {
                Icon(Icons.Filled.ArrowBack,
                    contentDescription = "Voltar",
                    modifier = Modifier.clickable {
                    }, tint = Color.White
                )
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(colorResource(id = R.color.backgroundCinza))
        )

        Row(modifier = Modifier
            .fillMaxWidth()
            .height(47.dp)
            ){

            Spacer(modifier.width(25.dp))

            Text(text = "Opções de Exibição",
                color = Color.White,
                fontSize = 30.sp)
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .height(47.dp)) {

            Spacer(modifier.width(25.dp))

            Text(text = "Adicionar novos itens à parte inferior",
                color = Color.White,
                fontSize = 18.sp)

        }

    }


    @Composable
    fun GreetingPreview7() {
        GerenciarTarefasTheme {
            Greeting6("Android")
        }
    }
}