package com.example.lab_07_z2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.lab_07_z2.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false)


        binding.btnToF2.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }


        binding.btnToF5.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_fifthFragment)
        }

        return binding.root
    }
}