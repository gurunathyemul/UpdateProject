package com.example.updateproject.services

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.AndroidEntryPoint
import java.util.Random

@AndroidEntryPoint

class MyService : Service() {
    private var randomNumber = MutableLiveData<Int>()
    private var isNumberOn = true

    class MyBinder(private val service: MyService) : Binder() {
        fun getMyService(): MyService {
            return service
        }
    }

    private val iBinder: IBinder = MyBinder(this)

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreateService:${Thread.currentThread().name} ")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand:: startId -$startId  intent-$intent")
        object : Thread() {
            override fun run() {
                startRandomNumberGenerator()
            }
        }.start()
        return super.onStartCommand(intent, flags, startId)
//        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        Log.d(TAG, "onBind: ")
        return iBinder
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
        isNumberOn = false
    }


    override fun onUnbind(intent: Intent?): Boolean {
        Log.d(TAG, "onUnbind: ")
        return super.onUnbind(intent)
    }

    override fun onRebind(intent: Intent?) {
        super.onRebind(intent)
        Log.d(TAG, "onRebind: ")
    }

    var a = 10
    private fun startRandomNumberGenerator() {
        while (isNumberOn) {
            Thread.sleep(1000)
            val ranNum = Random().nextInt()
            randomNumber.postValue(ranNum)
            Log.d(TAG, "randomNumber: $randomNumber")
            Log.d(TAG, "onStartCommand:${Thread.currentThread().name} ")
        }
    }

    fun getRandomNumber():LiveData<Int> = randomNumber

    companion object {
        private const val TAG = "MyService"
    }

    /*
    START_REDELIVER_INTENT-> Auto starts when service destroy with intent(last value)
    START_STICKY-> Auto start & no intent
    START_NOT_STICKY -> Not Auto start & no intent
    */
}