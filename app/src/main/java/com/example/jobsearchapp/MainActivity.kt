package com.example.jobsearchapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.jobsearchapp.state.ApplicationState
import com.example.jobsearchapp.state.Store
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var store: Store<ApplicationState>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController = findNavController(R.id.host_fragment_container)
        val navView = findViewById<BottomNavigationView>(R.id.nav_bar_view)
        navView.setupWithNavController(navController)

        store.myLiveDataObservable.observe(this) {
            navView.getOrCreateBadge(R.id.fragmentFavourites).apply {
                number = it.favoriteVacancieIds.size
                isVisible = it.favoriteVacancieIds.isNotEmpty()
            }
        }
    }
}