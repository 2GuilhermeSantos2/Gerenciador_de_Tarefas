package com.example.gerenciartarefas.SearchBar

import com.google.protobuf.Empty

data class UserSearchModelState(
    val searchText: String = "",
    val users: List<User> = arrayListOf(),
    val sowProgressBar: Boolean = false
){
    companion object{
        val Empty = UserSearchModelState()
    }
}