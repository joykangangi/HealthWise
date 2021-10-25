package com.example.healthwise.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.healthwise.DiseaseApplication
import com.example.healthwise.adapters.HealthAdapter
import com.example.healthwise.viewmodels.MainViewModel
import com.example.healthwise.databinding.CommonDiseasesFragmentBinding
import com.example.healthwise.utils.Resource
import com.example.healthwise.viewmodels.MainViewModelProviderFactory
import okhttp3.internal.checkOffsetAndCount


private val TAG = "CommonDiseasesFragment"
class CommonDiseasesFragment : Fragment() {
    private var _binding: CommonDiseasesFragmentBinding? = null
    private val binding get() = _binding!!
    lateinit var viewModel: MainViewModel
    lateinit var healthAdapter: HealthAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CommonDiseasesFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        setUpRecyclerView()

        viewModel.allArticles.observe(viewLifecycleOwner, Observer { response ->
            when(response) {
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let { healthResult ->
                        healthAdapter.differ.submitList(healthResult.diseases)
                    }
                }
                is Resource.Error -> {
                    showProgressBar()
                    response.message?.let { message->
                        Log.e(TAG, "An error occurred $message")
                    }
                }
                    is Resource.Loading -> {
                        showProgressBar()
                    }
                }
            })
        }

    private fun hideProgressBar() {
        binding.progressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }


    private fun setUpRecyclerView() {
        healthAdapter = HealthAdapter()
        binding.rvCommonDiseases.apply {
            adapter = healthAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}