package com.roomdatabase

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Query("DELETE FROM user")
    suspend fun deleteAllUsers()

    @Query("SELECT * from user ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>

}