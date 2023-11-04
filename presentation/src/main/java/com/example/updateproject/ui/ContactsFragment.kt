package com.example.updateproject.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.updateproject.base.BaseFragment
import com.example.updateproject.databinding.FragmentContactsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContactsFragment : BaseFragment<NavigationActivity>() {
    private lateinit var binding: FragmentContactsBinding
    private val myArgs: ContactsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContactsBinding.inflate(inflater, container, false)
        initUI()
        registerListeners()
        return binding.root
    }

    override fun initUI() {
        super.initUI()
        binding.tvContacts.text = myArgs.name
    }

    override fun registerListeners() {
        super.registerListeners()
        binding.btnChat.setOnClickListener {
            val navigateToChatFragment =
                ContactsFragmentDirections.actionContactsFragmentToChatFragment("Chat")
            findNavController().navigate(navigateToChatFragment)
        }
        binding.btnStatus.setOnClickListener {
            val navigateToStatusFragment =
                ContactsFragmentDirections.actionContactsFragmentToStatusFragment()
            findNavController().navigate(navigateToStatusFragment)
        }
    }

    companion object {
        private const val TAG = "ContactsFragment"
    }
}