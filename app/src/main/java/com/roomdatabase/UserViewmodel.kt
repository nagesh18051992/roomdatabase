package com.roomdatabase

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UserViewmodel(application: Application):AndroidViewModel(application) {

    val readAllData: LiveData<List<User>>
    private val repository: UserRepository

    init {
        val userDao = AppDatabase.getDatabase(application).userDao()
        repository= UserRepository(userDao)
        readAllData = repository.readAllData
    }

    fun addUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.sendData(user)
        }
    }

    fun deleteUser() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteData()
        }
    }
}

