package com.example.healthwise.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.healthwise.DiseaseApplication
import com.example.healthwise.R
import com.example.healthwise.api.RetrofitInstance
import com.example.healthwise.viewmodels.MainViewModel
import com.example.healthwise.viewmodels.MainViewModelProviderFactory
import com.example.healthwise.databinding.ActivityMainBinding
import com.example.healthwise.repository.MainRepository
import com.google.android.material.bottomnavigation.BottomNavigationView

private val TAG = "MAIN_ACTIVITY"
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

   val viewModel: MainViewModel by viewModels {
        MainViewModelProviderFactory(( application as DiseaseApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentContainer = supportFragmentManager.findFragmentById(R.id.myNavHostFragment) as NavHostFragment
        navController = fragmentContainer.navController
        NavigationUI.setupActionBarWithNavController(this, navController)
    //By calling this method, the title in the action bar will automatically be updated when the destination changes

        val bottomAppBar: BottomNavigationView = binding.bottNav
        bottomAppBar.setupWithNavController(navController)

        val responses = RetrofitInstance.api
        Log.i(TAG,"called retrofit")
      /*
       val viewModelProviderFactory = MainViewModelProviderFactory( (application as DiseaseApplication).repository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(MainViewModel::class.java)
*/
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}