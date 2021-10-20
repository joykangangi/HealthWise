package com.example.newsapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.newsapi.R
import com.example.newsapi.api.RetrofitInstance
import com.example.newsapi.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

const val TAG = "MAIN_ACTIVITY"
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

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
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}