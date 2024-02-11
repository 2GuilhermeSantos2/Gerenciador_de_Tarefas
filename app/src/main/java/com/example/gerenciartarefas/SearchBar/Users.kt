package com.example.gerenciartarefas.SearchBar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun User(users:List<User>?,onClick: (User)->Unit){
    users?.forEach{ user ->
        UserRow(user = user){
            onClick(user)
        }
        Divider()
    }
}

@Composable
fun UserRow(user:User, onClick:()->Unit){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .clickable { onClick() }
    ) {
        Text(user.name,fontSize=14.sp,fontWeight= FontWeight.Bold)
        Spacer(modifier = Modifier.height(2.dp))
        Text(user.email)
        Spacer(modifier = Modifier.height(4.dp))
    }
}