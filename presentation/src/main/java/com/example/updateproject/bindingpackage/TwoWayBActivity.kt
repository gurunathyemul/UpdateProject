package com.example.updateproject.bindingpackage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.updateproject.utils.User
import com.example.updateproject.databinding.ActivityTwoWayBBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TwoWayBActivity : AppCompatActivity() {
    private lateinit var bindingActivity: ActivityTwoWayBBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingActivity = ActivityTwoWayBBinding.inflate(layoutInflater)
        setContentView(bindingActivity.root)
        val user=User()
        bindingActivity.user = user
        user.lastName="Yemul"
    }
}