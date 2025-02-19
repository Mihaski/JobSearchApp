package com.example.jobsearchapp.presentation.testlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import com.example.jobsearchapp.MainViewModel
import com.example.jobsearchapp.R
import com.example.jobsearchapp.databinding.FragmentTestBinding
import com.example.jobsearchapp.utils.viewBinding
import kotlinx.coroutines.launch

class FragmentTest : Fragment() {

    private val binding by viewBinding(FragmentTestBinding::bind) //!! IMPORTANT only onViewCreated

    private val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listTestRV = binding.rvTestContainer
        val adapterTest = TestAdapter()
        listTestRV.adapter = adapterTest

        viewModel.store.myLiveDataObservable.observe(viewLifecycleOwner) {
            adapterTest.submitList(it.vacancies)
        }
        viewModel.refreshVacancie()

        adapterTest.onVacancieClickListener = {
//            val currentState = viewModel.store.myLiveDataObservable.value
            if (it.isFavorite == "false") it.isFavorite = "true"
            else it.isFavorite = "false"
            viewModel.refreshVacancie()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test, container, false)
    }

//    private fun onFavoriteIconClicked(selectedProductId: Int) {
//        viewModel.viewModelScope.launch {
//            viewModel.store.update { currentState ->
//                val currentFavoriteIds = currentState.favoriteVacancieIds
//                val newFavoriteIds = if (currentFavoriteIds.contains(selectedProductId))
//                    currentFavoriteIds.filter { it != selectedProductId }.toSet()
//                else currentFavoriteIds + setOf(selectedProductId)
//                return@update currentState.copy(favoriteProductIds = newFavoriteIds)
//            }
//        }
//    }
}