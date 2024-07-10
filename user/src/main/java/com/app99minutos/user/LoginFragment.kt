package com.app99minutos.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.app99minutos.user.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.button.setOnClickListener {
            findNavController().navigate(com.app99minutos.core.R.id.home_nav_graph)
        }
        binding.id2.setOnClickListener {
            findNavController().navigate(R.id.register_nav_graph)
        }
        return binding.root
        // Inflate the layout for this fragment
    }
}