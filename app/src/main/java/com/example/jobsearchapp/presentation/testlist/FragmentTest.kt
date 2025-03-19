package com.example.jobsearchapp.presentation.testlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.jobsearchapp.MainViewModel
import com.example.jobsearchapp.R
import com.example.jobsearchapp.databinding.FragmentTestBinding
import com.example.jobsearchapp.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FragmentTest : Fragment() {

    private val binding by viewBinding(FragmentTestBinding::bind)

    private val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listTestRV = binding.rvTestContainer
        val adapterTest = TestAdapter()
        listTestRV.adapter = adapterTest

        viewModel.store.myLiveDataObservable.observe(viewLifecycleOwner) {
            adapterTest.submitList(it.vacancies)
        }
        adapterTest.onFavoriteClickListener = { netVacId ->
            viewModel.store.update { currentState ->
                val currentIds = currentState.favoriteVacancieIds
                val newIds = if (currentIds.contains(netVacId.id))
                    currentIds.filter { it != netVacId.id }.toSet()
                else currentIds + setOf(netVacId.id)
                return@update currentState.copy(favoriteVacancieIds = newIds)
            }
        }
        viewModel.refreshVacancie()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test, container, false)
    }

}