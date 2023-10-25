package com.example.updateproject.base

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.updateproject.R


@Suppress("UNCHECKED_CAST")
open class BaseFragment<T> : Fragment() {
    var mActivity: T? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.mActivity = context as T
    }

    open fun initUI() {}
    open fun registerListeners() {}
    open fun initObservers() {}
}