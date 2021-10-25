package com.example.healthwise.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.healthwise.models.HealthResult
import com.example.healthwise.repository.MainRepository
import com.example.healthwise.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(
    val diseaseRepository: MainRepository
): ViewModel() {

    val allArticles: MutableLiveData<Resource<HealthResult>> = MutableLiveData()
    var breakingNewsPage = 1

    init {
        getAllArticles()
    }

    fun getAllArticles() = viewModelScope.launch {
        allArticles.postValue(Resource.Loading())
        val response = diseaseRepository.getAllDisease(breakingNewsPage)
        allArticles.postValue(handleBreakingNewsResponse(response))
    }

    private fun handleBreakingNewsResponse(response: Response<HealthResult>): Resource<HealthResult> {
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

