package com.example.gerenciartarefas.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gerenciartarefas.R
import com.example.gerenciartarefas.ui.theme.GerenciarTarefasTheme
import androidx.compose.ui.graphics.DefaultAlpha


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
                    Text(text = stringResource(R.string.settings), color = Color.White)
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

        Text(
            modifier = Modifier
                .padding(start = 20.dp)
                .fillMaxWidth(.75f),
            text = stringResource(R.string.display_options),
            color = Color.White,
            fontSize = 20.sp,

            )


        Spacer(modifier.height(10.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(47.dp)
        ) {

            Spacer(modifier.width(20.dp))

            Text(
                text = stringResource(R.string.add_new_items_to_bottom),
                color = Color.White,
                fontSize = 15.sp
            )

            Spacer(modifier.width(20.dp))

            var checked by remember { mutableStateOf(true) }

            Switch(
                checked = checked,
                onCheckedChange = {
                    checked = it
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = colorResource(R.color.bottomSwitchTrack),
                    checkedTrackColor = colorResource(R.color.bottomSwtich),
                    uncheckedThumbColor = colorResource(R.color.bottomSwitchDisable),
                    uncheckedTrackColor = colorResource(R.color.bottomSwitchDisableTrack)
                ),

                modifier = Modifier.fillMaxWidth(.75f)

            )
        }

        Spacer(modifier.height(10.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)

        ) {

            Spacer(modifier.width(20.dp))

            Text(
                text = stringResource(R.string.move_checked_items_to_bottom),
                color = Color.White,
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(.75f)
            )



            Spacer(modifier.width(20.dp))

            var checked by remember { mutableStateOf(true) }

            Switch(
                checked = checked,
                onCheckedChange = {
                    checked = it
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = colorResource(R.color.bottomSwitchTrack),
                    checkedTrackColor = colorResource(R.color.bottomSwtich),
                    uncheckedThumbColor = colorResource(R.color.bottomSwitchDisable),
                    uncheckedTrackColor = colorResource(R.color.bottomSwitchDisableTrack)
                ),
                modifier = Modifier.fillMaxWidth(.44f)

            )
        }

        Spacer(modifier.height(10.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)

        ) {

            Spacer(modifier.width(20.dp))

            Text(
                text = stringResource(R.string.display_rich_link_previews),
                color = Color.White,
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(.75f)
            )



            Spacer(modifier.width(20.dp))

            var checked by remember { mutableStateOf(true) }

            Switch(
                checked = checked,
                onCheckedChange = {
                    checked = it
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = colorResource(R.color.bottomSwitchTrack),
                    checkedTrackColor = colorResource(R.color.bottomSwtich),
                    uncheckedThumbColor = colorResource(R.color.bottomSwitchDisable),
                    uncheckedTrackColor = colorResource(R.color.bottomSwitchDisableTrack)
                ),
                modifier = Modifier.fillMaxWidth(.44f)

            )
        }

        Spacer(modifier.height(10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Spacer(modifier.width(20.dp))

            Text(
                stringResource(R.string.Theme),
                color = Color.White,
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(.52f)
            )

            Spacer(modifier.width(20.dp))

            Text(
                stringResource(R.string.system_default),
                color = Color.White,
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(85f)
            )

        }


        Spacer(modifier.height(10.dp))


        Spacer(modifier.height(10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Spacer(modifier.width(20.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth(.75f),
                text = stringResource(R.string.reminder_defaults),
                color = Color.White,
                fontSize = 20.sp,

                )
        }

        Spacer(modifier.height(10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                //.height(50.dp)
        ) {
            Spacer(modifier.width(20.dp))

            Text(
                stringResource(R.string.morning),
                color = Color.White,
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(.70f)
            )

            Spacer(modifier.width(20.dp))

            Text(
                stringResource(R.string.dafault_hour),
                color = Color.White,
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(90f)
            )

        }

        Spacer(modifier.height(5.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                //.height(50.dp)
        ) {
            Spacer(modifier.width(20.dp))

            Text(
                stringResource(R.string.afternoon),
                color = Color.White,
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(.70f)
            )

            Spacer(modifier.width(20.dp))

            Text(
                stringResource(R.string.dafault_hour),
                color = Color.White,
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(90f)
            )

        }

        Spacer(modifier.height(5.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                //.height(50.dp)
        ) {
            Spacer(modifier.width(20.dp))

            Text(
                stringResource(R.string.evening),
                color = Color.White,
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(.70f)
            )

            Spacer(modifier.width(20.dp))

            Text(
                stringResource(R.string.dafault_hour),
                color = Color.White,
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(90f)
            )

        }

        Spacer(modifier.height(10.dp))


        Spacer(modifier.height(10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Spacer(modifier.width(20.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth(.75f),
                text = stringResource(R.string.enable_sharing),
                color = Color.White,
                fontSize = 20.sp,

                )


        }
        Spacer(modifier.height(10.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(47.dp)
        ) {

            Spacer(modifier.width(20.dp))

            Text(
                text = stringResource(R.string.sharing),
                color = Color.White,
                fontSize = 15.sp,
                modifier = Modifier.fillMaxWidth(.70f)
            )

            Spacer(modifier.width(20.dp))

            var checked by remember { mutableStateOf(true) }

            Switch(
                checked = checked,
                onCheckedChange = {
                    checked = it
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = colorResource(R.color.bottomSwitchTrack),
                    checkedTrackColor = colorResource(R.color.bottomSwtich),
                    uncheckedThumbColor = colorResource(R.color.bottomSwitchDisable),
                    uncheckedTrackColor = colorResource(R.color.bottomSwitchDisableTrack)
                ),

                modifier = Modifier.fillMaxWidth(.90f)

            )
        }

    }









        @Composable
        fun GreetingPreview7() {
            GerenciarTarefasTheme {
                Greeting6("Android")
            }
        }
    }
