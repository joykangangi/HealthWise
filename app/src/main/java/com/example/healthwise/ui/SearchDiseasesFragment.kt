package com.example.healthwise.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.healthwise.adapters.HealthAdapter
import com.example.healthwise.databinding.FragmentSearchDiseasesBinding
import com.example.healthwise.models.Disease
import com.example.healthwise.utils.Constants.Companion.SEARCH_DISEASES_TIME_DELAY
import com.example.healthwise.utils.Resource
import com.example.healthwise.viewmodels.MainViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


private const val TAG = "SearchDiseasesFragment"

class SearchDiseasesFragment : Fragment() {
    private var _binding: FragmentSearchDiseasesBinding? = null
    private val binding get() = _binding!!
    lateinit var viewModel: MainViewModel
   // lateinit var healthAdapter: HealthAdapter

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
        setUpView()

        var job: Job? = null
        binding.searchEt.addTextChangedListener { editable->
            //whenever we type smth we cancel the current job and start a new job,
            //we then set the new job to the mainScope
            job?.cancel()
            job = MainScope().launch {
                delay(SEARCH_DISEASES_TIME_DELAY)
                editable?.let {
                    if (editable.toString().isNotEmpty()) {
                        viewModel.searchArticles(editable.toString())
                    }
                }
            }
        }

        viewModel.searchArticles.observe(viewLifecycleOwner, { response ->
            when(response) {
                is Resource.Success -> {
                    hideProgressBar()
                   //response.data?.let { healthResult ->
                       // .differ.submitList(healthResult)
                   // }
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
        binding.paginationProgressBar.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        binding.paginationProgressBar.visibility = View.VISIBLE
    }


    private fun setUpView() {

        binding.apply {
            searchRes.text = 
            date.text = disease.data_updated_at
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}