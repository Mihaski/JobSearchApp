package com.example.jobsearchapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.host_fragment_container)
        val navView = findViewById<BottomNavigationView>(R.id.nav_bar_view)
        navView.setupWithNavController(navController)

        viewModel.store.myLiveDataObservable.observe(this) {
            navView.getOrCreateBadge(R.id.fragmentFavourites).apply {
                number = it.favoriteVacancieSet.size
                isVisible = it.favoriteVacancieSet.isNotEmpty()
            }
        }

        viewModel.navViewIsEnabled.observe(this) { turnON ->

            if (turnON == false) {
                with(navView.menu) {
                    findItem(R.id.fragmentMain).isEnabled = false
                    findItem(R.id.fragmentFavourites).isEnabled = false
                    findItem(R.id.nav_button_responses).isEnabled = false
                    findItem(R.id.nav_button_messages).isEnabled = false
                    findItem(R.id.nav_button_profile).isEnabled = false
                }

            } else {
                with(navView.menu) {
                    findItem(R.id.fragmentMain).isEnabled = true
                    findItem(R.id.fragmentFavourites).isEnabled = true
                    findItem(R.id.nav_button_responses).isEnabled = true
                    findItem(R.id.nav_button_messages).isEnabled = true
                    findItem(R.id.nav_button_profile).isEnabled = true
                }
            }

        }
    }

}