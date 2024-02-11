package com.example.gerenciartarefas.SearchBar

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.google.protobuf.ExperimentalApi

@Composable
@OptIn(ExperimentalComposeUiApi::class  )
fun MyTopAppBar(
    searchText: String,
    placeholderText: String = "",
    onSearchTextVChange: (String) -> Unit = {},
    onClearClick: () -> Unit = {},
    onNavigateBack: () -> Unit = {}
) {
    val context = LocalContext.current
    TopAppBar(title = { Text("") },
        navigationIcon = {
            Icon(Icons.Default.ArrowBack,
                contentDescription = "",
                modifier = Modifier.clickable {
                    Toast.makeText(
                        context,
                        "voltando",
                        Toast.LENGTH_SHORT
                    ).show()
                })
        },
        actions = {})

    var showClearButton by remember { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusRequester = remember { FocusRequester() }
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    var searchText by remember { mutableStateOf("") }
    OutlinedTextField(value = searchText, onValueChange = { it ->
        searchText = it
    },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp)
            .onFocusChanged { focusState -> showClearButton = (focusState.isFocused) }
            .focusRequester(focusRequester),
        placeholder = { Text("") },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            backgroundColor = Color.Transparent,
            cursorColor = LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
        ),
        trailingIcon = {
            AnimatedVisibility(visible = showClearButton, enter = fadeIn(), exit = fadeOut()) {
                IconButton(onClick = { onClearClick() }) {
                    Icon(
                        imageVector =
                        Icons.Filled.Close, contentDescription = ""
                    )
                }

            }
        },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() })
    )
}
    @Composable
    fun NoSearchResult(){
        Column(modifier = Modifier
            .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = CenterHorizontally){
            Text(text = "Sem resultados compativeis")
        }
    }



@Composable
@ExperimentalAnimationApi
@ExperimentalComposeUiApi
fun SearchBarUI(
    searchText:String,
    placeholderText:String="",
    onSearchTextVChange:(String)->Unit={},
    onClearClick:()->Unit = {},
    onNavigateBack: ()-> Unit = {},
    matchesFound: Boolean,
    results:@Composable () -> Unit={}
){

    Box{
       Column(modifier = Modifier.fillMaxSize()){
           MyTopAppBar(
               searchText,
               placeholderText,
               onSearchTextVChange,
               onClearClick,
               onNavigateBack
           )
           if(matchesFound){
               Text("Resultados", modifier = Modifier.padding(8.dp), fontWeight = FontWeight.Bold)
           }else{
               if(searchText.isNotEmpty()){
                   NoSearchResult()
               }
           }
       }
    }

}


