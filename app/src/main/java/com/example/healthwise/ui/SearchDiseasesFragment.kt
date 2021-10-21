package com.example.healthwise.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.healthwise.R
import com.example.healthwise.viewmodels.MainViewModel
import com.example.healthwise.databinding.FragmentSearchDiseasesBinding

class SearchDiseasesFragment : Fragment() {
    private var _binding: FragmentSearchDiseasesBinding? = null
    private val binding get() = _binding!!
    lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchDiseasesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}