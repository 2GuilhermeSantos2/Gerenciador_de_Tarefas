package com.example.gerenciartarefas.screen

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ModalDrawer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.DrawerValue
import androidx.compose.material.IconButton
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path.Companion.combine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gerenciartarefas.R
import com.example.gerenciartarefas.SearchBar.MyTopAppBar
import com.example.gerenciartarefas.ui.theme.GerenciarTarefasTheme
import com.google.android.material.search.SearchBar
import com.google.protobuf.Empty
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import androidx.compose.material3.Text as Text1


class Notes : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GerenciarTarefasTheme {


                val drawerState = rememberDrawerState(DrawerValue.Closed)
                val scope = rememberCoroutineScope()
                ModalDrawer(
                    modifier = Modifier.fillMaxSize(),
                    drawerState = drawerState,
                    drawerContent = {
                        Column(
                            modifier = Modifier
                                .background(
                                    color = colorResource
                                        (id = R.color.backgroundColor)
                                )
                                .fillMaxSize()
                        ) {
                            Text1(
                                text = "Bloco de Notas",
                                color = Color.White,
                                fontSize = 30.sp
                            )
                            Spacer(modifier = Modifier.height(10.dp))

                            val localView = LocalContext.current

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(47.dp)
                                    .clickable {
                                        scope.launch { drawerState.close() }

                                    },
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.outline_lightbulb_24),
                                    contentDescription = "Anotações",
                                    modifier = Modifier.size(40.dp), tint = Color.White
                                )

                                Spacer(Modifier.width(25.dp))
                                Text1(
                                    text = "Anotações",
                                    color = Color.White,
                                    fontSize = 20.sp,

                                    )
                            }

                            Spacer(Modifier.height(10.dp))
                            val contextReminder = LocalContext.current


                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(47.dp)
                                    .clickable {
                                        val intent = Intent(contextReminder, Reminder::class.java)
                                        contextReminder.startActivity(intent)

                                    },
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.outline_notifications_24),
                                    contentDescription = "Lembrentes",
                                    modifier = Modifier.size(40.dp), tint = Color.White
                                )

                                Spacer(Modifier.width(25.dp))
                                Text1(
                                    text = "Lembrentes",
                                    color = Color.White,
                                    fontSize = 20.sp,

                                    )
                            }

                            Spacer(Modifier.height(10.dp))

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(47.dp)
                                    .clickable {
                                        Toast
                                            .makeText(
                                                localView,
                                                "Criar novo marcador",
                                                Toast.LENGTH_SHORT
                                            )
                                            .show()
                                    },
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.baseline_add_24),
                                    contentDescription = "Criar novo marcador",
                                    modifier = Modifier.size(40.dp), tint = Color.White
                                )

                                Spacer(Modifier.width(25.dp))
                                Text1(
                                    text = "Criar um novo marcador",
                                    color = Color.White,
                                    fontSize = 20.sp,

                                    )

                            }

                            Spacer(Modifier.height(10.dp))

                            val contextArchive = LocalContext.current


                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(47.dp)
                                    .clickable {
                                        val intent = Intent(contextArchive, Archive::class.java)
                                        contextArchive.startActivity(intent)

                                    },
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.baseline_move_to_inbox_24),
                                    contentDescription = "Arquivar",
                                    modifier = Modifier.size(40.dp), tint = Color.White
                                )

                                Spacer(Modifier.width(25.dp))
                                Text1(
                                    text = "Arquivar",
                                    color = Color.White,
                                    fontSize = 20.sp,

                                    )

                            }

                            Spacer(Modifier.height(10.dp))

                            val contextTrash = LocalContext.current

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(47.dp)
                                    .clickable {
                                        val intent = Intent(contextTrash, Trash::class.java)
                                        contextTrash.startActivity(intent)

                                    },
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(R.drawable.outline_delete_24),
                                    contentDescription = "Lixeira",
                                    modifier = Modifier.size(40.dp), tint = Color.White
                                )


                                Spacer(Modifier.width(25.dp))

                                Text1(
                                    text = "Lixeira",
                                    color = Color.White,
                                    fontSize = (20.sp),

                                    )

                            }

                            Spacer(Modifier.height(10.dp))

                            val context = LocalContext.current

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(47.dp)
                                    .clickable {
                                        val intent = Intent(context, Settings::class.java)
                                        context.startActivity(intent)
                                    },
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.outline_settings_24),
                                    contentDescription = "Configurações",
                                    modifier = Modifier.size(40.dp), tint = Color.White
                                )

                                Spacer(Modifier.width(25.dp))

                                Text1(
                                    text = "Configurações",
                                    color = Color.White,
                                    fontSize = (20.sp),

                                    )

                            }

                            Spacer(Modifier.height(10.dp))
                            /*
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(47.dp)
                                .clickable {
                                    Toast
                                        .makeText(localView, "Ajuda e Feedback", Toast.LENGTH_SHORT)
                                        .show()
                                },
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.baseline_help_outline_24),
                                contentDescription = "Ajuda e Feedback",
                                modifier = Modifier.size(40.dp), tint = Color.White
                            )

                            Spacer(Modifier.width(25.dp))

                            Text(
                                text = "Ajuda e Feedback",
                                color = Color.White,
                                fontSize = (20.sp),

                                )

                        }

                        Spacer(Modifier.height(10.dp))*/
                            /*
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(47.dp)
                                .clickable {
                                    Toast
                                        .makeText(
                                            localView,
                                            "Atalhos do teclado",
                                            Toast.LENGTH_SHORT
                                        )
                                        .show()
                                },
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.outline_keyboard_24),
                                contentDescription = "Atalhos do teclado",
                                modifier = Modifier.size(40.dp), tint = Color.White
                            )

                            Spacer(Modifier.width(25.dp))

                            Text(
                                text = "Atalhos do teclado",
                                color = Color.White,
                                fontSize = (20.sp),


                                )


                        }*/


                        }

                    }
                ) {

                    MyTopAppBar(searchText = "FUNCIONA DESGRAÇA")


                    }


                }




            }
        }


    }




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}



