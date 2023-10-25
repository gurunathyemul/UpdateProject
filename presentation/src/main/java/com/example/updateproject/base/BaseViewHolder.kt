package com.example.updateproject.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.updateproject.BR

class BaseViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(
        mViewModel: BaseAndroidViewModel,
        obj: Any?,
        position: Int,
        selectedPosition: Int,
        mTextVisibility: Boolean
    ) {
        binding.setVariable(BR.mViewModel, mViewModel)
        binding.setVariable(BR.obj, obj)
        binding.setVariable(BR.position, position)
        binding.setVariable(BR.selectedPosition, selectedPosition)
        binding.setVariable(BR.mTextVisibility, mTextVisibility)
        binding.executePendingBindings()
    }
}