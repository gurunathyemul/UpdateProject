package com.example.updateproject.bindingpackage

import android.os.Bundle
import com.example.updateproject.base.BaseActivity
import com.example.updateproject.databinding.ActivitySampleBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OneWayBindingActivity : BaseActivity() {
    private lateinit var binding: ActivitySampleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    override fun initUI() {
        super.initUI()
        binding.tvName.text = "Gurunath"
    }

    companion object {
    }
}