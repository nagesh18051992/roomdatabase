package com.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer


class MainActivity : AppCompatActivity() {

    private val viewModel: UserViewmodel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user=User(2,"manda","Nageswar Rao")
        viewModel.addUser(user)

        viewModel.readAllData.observe(this, Observer { user ->
            Log.d("TAG","value====>${user}")
        })

    }
}