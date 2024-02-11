package com.example.gerenciartarefas.SearchBar

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.MutableStateFlow
import java.util.prefs.NodeChangeEvent
import javax.inject.Inject
import com.example.gerenciartarefas.SearchBar.User

private const val TAG = "SearchViewDemoViewModel"

@HiltViewModel
class UserSearchViewModel @Inject constructor(private val userRepository: UserRepository) :
        ViewModel() {
    private var allUsers: ArrayList<User> = ArrayList<User>()
    private val searchText: MutableStateFlow<String> = MutableStateFlow("")
    private val showProgressBar: MutableStateFlow<Boolean> = MutableStateFlow(false)
    private val matchedUsers: MutableStateFlow<List<User>> = MutableStateFlow(arrayListOf())

    val userSearchModelState =
        combine(searchText, matchedUsers, showProgressBar) { text, matchedUsers, showProgress ->
            UserSearchModelState(
                text,
                matchedUsers,
                showProgress
            )
        }

    init
    {
        retriveUsers()
    }

    fun retriveUsers() {
        val users = userRepository.getUsers()
        if (users != null) {
            allUsers.addAll(users)
        }
    }

    fun onSearchTextChanged(changedSearchText: String){
        searchText.value = changedSearchText
        if(changedSearchText.isNotEmpty()){
            matchedUsers.value = arrayListOf()
        }

        val usersFromSearch = allUsers.filter { x ->
            x.username.contains(changedSearchText,true) ||
            x.email.contains(changedSearchText, true) ||
            x.name.contains(changedSearchText, true)
        }

        matchedUsers.value = usersFromSearch
    }
    fun onClearClick(){
        searchText.value = ""
        matchedUsers.value = arrayListOf()
    }
}