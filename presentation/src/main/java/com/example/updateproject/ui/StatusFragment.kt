package com.example.updateproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.updateproject.base.BaseFragment
import com.example.updateproject.databinding.FragmentStatusBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StatusFragment : BaseFragment<NavigationActivity>() {
    private lateinit var binding: FragmentStatusBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStatusBinding.inflate(inflater, container, false)
        registerListeners()
        return binding.root
    }

    override fun registerListeners() {
        super.registerListeners()
        binding.btnContacts.setOnClickListener {
            val navigateToContactsFragment =
                StatusFragmentDirections.actionStatusFragmentToContactsFragment()
            findNavController().navigate(navigateToContactsFragment)
        }
        binding.btnChat.setOnClickListener {
            val navigateToChatFragment =
                StatusFragmentDirections.actionStatusFragmentToChatFragment("A")
            findNavController().navigate(navigateToChatFragment)
        }
    }

    companion object {
        private const val TAG = "StatusFragment"
    }
}