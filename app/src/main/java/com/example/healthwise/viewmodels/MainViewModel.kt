package com.example.healthwise.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.healthwise.models.Disease
import com.example.healthwise.models.HealthResult
import com.example.healthwise.repository.MainRepository
import com.example.healthwise.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(
    val diseaseRepository: MainRepository
): ViewModel() {

    val allArticles: MutableLiveData<Resource<HealthResult>> = MutableLiveData()
    var allDiseasesPage = 1

    val searchArticles: MutableLiveData<Resource<Disease>> = MutableLiveData()
    var searchingPage = 1

    init {
        getAllArticles()
    }

    fun getAllArticles() = viewModelScope.launch {
        allArticles.postValue(Resource.Loading())
        val response = diseaseRepository.getAllDisease(allDiseasesPage)
        allArticles.postValue(handleHomeDiseasesResponse(response))
    }

    fun searchArticles(searchQuery: String) = viewModelScope.launch {
        searchArticles.postValue(Resource.Loading())
        val response = diseaseRepository.searchDiseases(searchQuery, searchingPage)
        with(searchArticles) {
            postValue(handleSearchDiseasesResponse(response))
        }
    }


    private fun handleHomeDiseasesResponse(response: Response<HealthResult>): Resource<HealthResult> {
        if (response.isSuccessful) {
            response.body()?.let { healthResult ->
                return Resource.Success(healthResult)
            }
        }
        return Resource.Error(response.message())
    }

    private fun handleSearchDiseasesResponse(response: Response<Disease>): Resource<Disease> {
        if (response.isSuccessful) {
            response.body()?.let { healthResult ->
                return Resource.Success(healthResult)
            }
        }
        return Resource.Error(response.message())
    }

}



class MainViewModelProviderFactory(private val diseaseRepository: MainRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(diseaseRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}

