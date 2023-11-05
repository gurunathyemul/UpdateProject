package com.example.updateproject.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.updateproject.base.BaseActivity
import com.example.updateproject.databinding.ActivityNavigationBinding
import com.example.updateproject.services.MyService
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NavigationActivity : BaseActivity() {
    private lateinit var intentSer: Intent
    private lateinit var binding: ActivityNavigationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d(TAG, "onCreate: NavigationActivity")
        initUI()
        registerListeners()
    }

    override fun initUI() {
        intentSer = Intent(this, MyService::class.java)
        startService(intentSer)
    }
    override fun registerListeners() {
        binding.stopService.setOnClickListener {
            stopService(intentSer)
        }
    }

    companion object {
        private const val TAG = "NavigationActivity"
    }
}