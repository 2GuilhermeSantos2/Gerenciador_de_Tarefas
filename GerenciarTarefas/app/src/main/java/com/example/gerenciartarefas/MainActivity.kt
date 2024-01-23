package com.example.gerenciartarefas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.captionBarPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.ModalDrawer
import androidx.compose.material.DrawerValue
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val drawerState = rememberDrawerState(DrawerValue.Closed)
            ModalDrawer(
                modifier = Modifier.fillMaxSize(),
                drawerState = drawerState,
                drawerContent = {
                    Column (modifier = Modifier.background(color = colorResource
                        (id = R.color.backgroundColor)).fillMaxSize()) {
                        Text(text = "Bloco de Notas",
                            color = Color.White,
                            fontSize = 30.sp
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Row(modifier = Modifier.height(47.dp)){
                            Icon(painter = painterResource(R.drawable.outline_lightbulb_24),
                                contentDescription = "Anotações",
                                modifier = Modifier.size(40.dp), tint = Color.White
                            )
                            Spacer(Modifier.width(5.dp))
                            Text(text = "Anotações",
                                color = Color.White,
                                fontSize = 20.sp
                            )
                        }
                    }

                }
            ){
                val scope = rememberCoroutineScope()
                TopAppBar(title = { Text(text = "Anotações")},
                    navigationIcon = {
                        Icon(Icons.Filled.Menu,
                            contentDescription = "",
                            modifier = Modifier.clickable {
                                scope.launch { drawerState.open() }
                            })
                    })

            }

            // A surface container using the 'background' color from the theme


        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}