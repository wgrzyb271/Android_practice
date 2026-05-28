package com.example.lab_07_z2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.lab_07_z2.databinding.FragmentFifthBinding

class FifthFragment : Fragment() {

    private lateinit var binding: FragmentFifthBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_fifth, container, false)

        binding.btnToF4.setOnClickListener {
            findNavController().navigate(R.id.action_fifthFragment_to_fourthFragment)
        }

        return binding.root
    }
}