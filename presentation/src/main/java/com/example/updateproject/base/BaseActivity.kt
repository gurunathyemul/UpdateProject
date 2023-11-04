package com.example.updateproject.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.updateproject.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    open fun initUI() {}
    open fun registerListeners() {}
    open fun initObservers() {}
}