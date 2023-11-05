package com.example.updateproject.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.updateproject.base.BaseFragment
import com.example.updateproject.databinding.FragmentChatBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChatFragment : BaseFragment<NavigationActivity>() {
    private lateinit var binding: FragmentChatBinding
    private val args: ChatFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatBinding.inflate(inflater, container, false)
//        binding=DataBindingUtil.inflate(inflater, R.layout.fragment_chat,container,false) as FragmentChatBinding
        initUI()
        registerListeners()
        return binding.root
    }

    override fun initUI() {
        super.initUI()
        Log.d(TAG, "initUI: ${args.name}")
        binding.tvChat.text = args.name
    }

    override fun registerListeners() {
        super.registerListeners()
        binding.btnContacts.setOnClickListener {
            val navigateToContactsFragment =
                ChatFragmentDirections.actionChatFragmentToContactsFragment("Guru")
            findNavController().navigate(navigateToContactsFragment)
        }
        binding.btnStatus.setOnClickListener {
            val navigateToStatusFragment =
                ChatFragmentDirections.actionChatFragmentToStatusFragment()
            findNavController().navigate(navigateToStatusFragment)
        }
    }

    companion object {
        private const val TAG = "ChatFragment"
    }
}