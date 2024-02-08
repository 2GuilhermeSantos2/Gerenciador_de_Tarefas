package com.example.gerenciartarefas.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.gerenciartarefas.R
import com.example.gerenciartarefas.ui.theme.GerenciarTarefasTheme

class Trash : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GerenciarTarefasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeging8(name = "Lixeira")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeging8(name: String, modifier: Modifier =  Modifier) {
    Column(
        modifier = Modifier
            .background(color = colorResource(id = R.color.backgroundCinza))
    ) {
        val scope = rememberCoroutineScope()
        Spacer(modifier = modifier.width(25.dp))
        TopAppBar(title = {
            Row {
                Spacer(modifier = Modifier.width(25.dp))
                Text(text = stringResource(R.string.title_activity_arquivado), color = Color.White)
            }
        },
            navigationIcon = {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = "Voltar",
                    modifier = Modifier.clickable {

                    }, tint = Color.White

                )
            },

            colors = TopAppBarDefaults.smallTopAppBarColors(colorResource(id = R.color.backgroundCinza))

        )

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    painter = painterResource(id = R.drawable.outline_delete_24),
                    contentDescription = "",
                    modifier = Modifier.size(150.dp),
                    tint = Color.White
                )

                Text(text = "Nenhuma nota na lixeira",color = Color.White)
            }
        }

    }
}
