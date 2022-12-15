package com.roomdatabase

import androidx.lifecycle.LiveData

class UserRepository (private val userDao:UserDao){

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun sendData(user: User){
        userDao.addUser(user)
    }

    suspend fun deleteData(){
        userDao.deleteAllUsers()
    }
}