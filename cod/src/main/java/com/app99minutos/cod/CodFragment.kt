package com.app99minutos.cod

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

class CodFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Toast.makeText(requireContext(), "Inicio cod", Toast.LENGTH_SHORT).show()

        return inflater.inflate(R.layout.fragment_cod, container, false)
    }

}