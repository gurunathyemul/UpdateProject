package com.example.updateproject.ui

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import com.example.updateproject.base.BaseActivity
import com.example.updateproject.databinding.ActivityServicesStartBinding
import com.example.updateproject.services.MyService

class ServicesStartActivity : BaseActivity() {
    private lateinit var myService: MyService
    private lateinit var myServiceBinder: MyService.MyBinder
    private var isServiceBound: Boolean = false
    private var serviceConnection: ServiceConnection? = null
    private lateinit var serviceIntent: Intent
    private lateinit var binding: ActivityServicesStartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServicesStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        initObservers()
        registerListeners()
    }

    override fun initUI() {
        Log.d(TAG, "onCreateActivity:${Thread.currentThread().name} ")

        serviceIntent = Intent(this, MyService::class.java)
    }

    override fun registerListeners() {
        binding.btnStartService.setOnClickListener {
            startService(serviceIntent)
        }

        binding.btnStopService.setOnClickListener {
            stopService(serviceIntent)
        }
        binding.btnBindService.setOnClickListener {
            bindMyService()
        }
        binding.btnUnBindService.setOnClickListener {
            unBindMyService()
        }
        binding.btnGetRandomNumber.setOnClickListener {
            getRandomNumber()
        }

        binding.btnNavigateActivity.setOnClickListener {
            binding.tvNumber.text = "NavActivity"
            val intentActivity = Intent(this, NavigationActivity::class.java)
            startActivity(intentActivity)
        }

    }

    private fun getRandomNumber() {
        if (isServiceBound) {
            myService.getRandomNumber().observe(this) {
                Log.d(TAG, "getRandomNumber: $it")
                binding.tvNumber.text = "$it"
            }
        }
    }

    private fun unBindMyService() {
        if (isServiceBound) {
            serviceConnection?.let {
                unbindService(it)
            }
            isServiceBound = false
        }
    }

    companion object {
        private const val TAG = "ServicesStartActivity"
    }

    private fun bindMyService() {
        if (serviceConnection == null) {
            serviceConnection = object : ServiceConnection {
                override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                    myServiceBinder = service as MyService.MyBinder
                    myService = myServiceBinder.getMyService()
                    isServiceBound = true
                }

                override fun onServiceDisconnected(name: ComponentName?) {
                    isServiceBound = false
                }
            }
        }
        serviceConnection?.let {
            bindService(serviceIntent, it, Context.BIND_AUTO_CREATE)
        }
    }
}