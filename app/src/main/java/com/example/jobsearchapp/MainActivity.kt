package com.example.jobsearchapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

//    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        } //TODO эти сетапы добавляют падинги снизу мешающие отображению контента.
//        val navView: BottomNavigationView = binding.navBarView
//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.main_fragment_container_host) as NavHostFragment
//        val navController = navHostFragment.navController
//        val navController = Navigation.findNavController(this, R.id.host_fragment_container)
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.fragmentFavourites, R.id.nav_button_responses, R.id.fragmentMain,
//                R.id.nav_button_messages, R.id.nav_button_profile
//            )
//        )
        val navController = findNavController(R.id.host_fragment_container)
//        setupActionBarWithNavController(navController, appBarConfiguration)
        val navView = findViewById<BottomNavigationView>(R.id.nav_bar_view)
        navView.setupWithNavController(navController)
    }
}