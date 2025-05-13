package com.example.jobsearchapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.jobsearchapp.MainScreenDelegates.vacanciesOneItemDelegate
import com.example.jobsearchapp.MainViewModel
import com.example.jobsearchapp.R
import com.example.jobsearchapp.databinding.VacanciesItemsListBinding
import com.example.jobsearchapp.utils.favoritesUpdateLambdaMainViewModel
import com.example.jobsearchapp.utils.viewBinding
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentPartOfMainVertical : Fragment() {

    //!! IMPORTANT only onViewCreated
    private val binding by viewBinding(VacanciesItemsListBinding::bind)

    private val viewModel: MainViewModel by activityViewModels()

    private val verticalAdapter = ListDelegationAdapter(
        vacanciesOneItemDelegate({
            findNavController().navigate(
                FragmentMainDirections.actionFragmentMainToFragmentVacancie(
                    it
                )
            )
        }, {
            findNavController().navigate(
                FragmentMainDirections.actionFragmentMainToFragmentDialogResponse(

                )
            )
        }, { netVacId ->
            favoritesUpdateLambdaMainViewModel(viewModel, netVacId)
        })
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.resetNavViewIsEnable()
        binding.rvVerticalContainerItemsListWithoutScreen.adapter = verticalAdapter

        viewModel.store.myLiveDataObservable.observe(viewLifecycleOwner) {
            verticalAdapter.apply {
                items = it.networkData.networkVacancies
                notifyItemRangeChanged(
                    0,
                    it.networkData.networkVacancies?.size ?: 0
                )
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.vacancies_items_list, container, false)
    }
}