package com.example.gerenciartarefas

import android.os.Bundle
import android.widget.Space
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.captionBarPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
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
            val drawerState = rememberDrawerState(DrawerValue.Open)
            ModalDrawer(
                modifier = Modifier.fillMaxSize(),
                drawerState = drawerState,
                drawerContent = {
                    Column (modifier = Modifier
                        .background(
                            color = colorResource
                                (id = R.color.backgroundColor)
                        )
                        .fillMaxSize()) {
                        Text(text = "Bloco de Notas",
                            color = Color.White,
                            fontSize = 30.sp
                        )
                        Spacer(modifier = Modifier.height(10.dp))

                        val localView = LocalContext.current

                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .height(47.dp)
                            .clickable {
                                Toast
                                    .makeText(localView, "Anotações", Toast.LENGTH_SHORT)
                                    .show()
                            },
                            verticalAlignment =  Alignment.CenterVertically){
                            Icon(painter = painterResource(R.drawable.outline_lightbulb_24),
                                contentDescription = "Anotações",
                                modifier = Modifier.size(40.dp), tint = Color.White)

                            Spacer(Modifier.width(25.dp))
                            Text(text = "Anotações",
                                color = Color.White,
                                fontSize = 20.sp,

                            )
                        }

                        Spacer(Modifier.height(10.dp))


                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .height(47.dp)
                            .clickable {
                                Toast
                                    .makeText(localView, "Lembrentes", Toast.LENGTH_SHORT)
                                    .show()
                            },
                            verticalAlignment = Alignment.CenterVertically){
                            Icon(painter = painterResource(R.drawable.outline_notifications_24),
                                contentDescription = "Lembrentes",
                                modifier = Modifier.size(40.dp), tint = Color.White)

                            Spacer(Modifier.width(25.dp))
                            Text(text = "Lembrentes",
                                color = Color.White,
                                fontSize = 20.sp,

                            )
                        }

                        Spacer(Modifier.height(10.dp))

                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .height(47.dp)
                            .clickable {
                                Toast
                                    .makeText(localView, "Criar novo marcador", Toast.LENGTH_SHORT)
                                    .show()
                            },
                            verticalAlignment = Alignment.CenterVertically){
                            Icon(painter = painterResource(R.drawable.baseline_add_24),
                                contentDescription = "Criar novo marcador",
                                modifier = Modifier.size(40.dp), tint = Color.White)

                            Spacer(Modifier.width(25.dp))
                            Text(text = "Criar um novo marcador",
                                color = Color.White,
                                fontSize = 20.sp,

                            )

                        }

                        Spacer(Modifier.height(10.dp))

                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .height(47.dp)
                            .clickable {
                                Toast
                                    .makeText(localView, "Arquivo", Toast.LENGTH_SHORT)
                                    .show()
                            },
                            verticalAlignment = Alignment.CenterVertically) {
                            Icon(painter = painterResource(R.drawable.baseline_move_to_inbox_24),
                                contentDescription = "Arquivo",
                                modifier = Modifier.size(40.dp), tint = Color.White)

                            Spacer(Modifier.width(25.dp))
                            Text(text = "Arquivo",
                                color = Color.White,
                                fontSize = 20.sp,

                            )

                        }

                        Spacer(Modifier.height(10.dp))

                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .height(47.dp)
                            .clickable {
                                Toast
                                    .makeText(localView, "Lixeira", Toast.LENGTH_SHORT)
                                    .show()
                            },
                            verticalAlignment = Alignment.CenterVertically){
                            Icon(painter = painterResource(R.drawable.outline_delete_24),
                                contentDescription = "Lixeira",
                                modifier = Modifier.size(40.dp), tint = Color.White)


                            Spacer(Modifier.width(25.dp))

                            Text(text = "Lixeira",
                                color = Color.White,
                                fontSize = (20.sp),

                            )

                        }

                        Spacer(Modifier.height(10.dp))

                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .height(47.dp)
                            .clickable {
                                Toast
                                    .makeText(localView, "Configurações", Toast.LENGTH_SHORT)
                                    .show()
                            },
                            verticalAlignment = Alignment.CenterVertically) {
                            Icon(painter = painterResource(id = R.drawable.outline_settings_24),
                                contentDescription = "Configurações",
                                modifier = Modifier.size(40.dp), tint = Color.White)

                            Spacer(Modifier.width(25.dp))

                            Text(text = "Configurações",
                                color = Color.White,
                                fontSize = (20.sp),

                            )

                        }

                        Spacer(Modifier.height(10.dp))

                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .height(47.dp)
                            .clickable {
                                Toast
                                    .makeText(localView, "Ajuda e Feedback", Toast.LENGTH_SHORT)
                                    .show()
                            },
                            verticalAlignment = Alignment.CenterVertically) {
                            Icon(painter = painterResource(R.drawable.baseline_help_outline_24),
                                contentDescription = "Ajuda e Feedback",
                                modifier = Modifier.size(40.dp), tint = Color.White)

                            Spacer(Modifier.width(25.dp))

                            Text(text = "Ajuda e Feedback",
                                color = Color.White,
                                fontSize = (20.sp),

                            )

                        }

                        Spacer(Modifier.height(10.dp))

                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .height(47.dp)
                            .clickable {
                                Toast
                                    .makeText(localView, "Atalhos do teclado", Toast.LENGTH_SHORT)
                                    .show()
                            },
                            verticalAlignment = Alignment.CenterVertically) {
                            Icon(painter = painterResource(R.drawable.outline_keyboard_24),
                                contentDescription = "Atalhos do teclado",
                                modifier = Modifier.size(40.dp), tint = Color.White)

                            Spacer(Modifier.width(25.dp))

                            Text(text = "Atalhos do teclado",
                                color = Color.White,
                                fontSize = (20.sp),


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

//forçando git