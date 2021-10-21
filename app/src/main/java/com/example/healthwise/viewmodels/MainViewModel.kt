package com.example.healthwise.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.healthwise.repository.MainRepository

class MainViewModel(
    val diseaseRepository: MainRepository
): ViewModel() {


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

