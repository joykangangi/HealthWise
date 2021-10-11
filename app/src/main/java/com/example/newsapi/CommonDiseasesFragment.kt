package com.example.newsapi

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class CommonDiseasesFragment : Fragment() {

    companion object {
        fun newInstance() = CommonDiseasesFragment()
    }

    private lateinit var viewModel: CommonDiseasesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.common_diseases_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CommonDiseasesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}