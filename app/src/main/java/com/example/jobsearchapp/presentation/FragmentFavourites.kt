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
import com.example.jobsearchapp.databinding.FragmentFavouritesBinding
import com.example.jobsearchapp.utils.viewBinding
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentFavourites : Fragment() {

    private val binding by viewBinding(FragmentFavouritesBinding::bind)

    private val viewModel: MainViewModel by activityViewModels()

    private val verticalAdapter = ListDelegationAdapter(
        vacanciesOneItemDelegate(
            {
                findNavController().navigate(
                    FragmentFavouritesDirections.actionFragmentFavouritesToFragmentVacancie(
                        it
                    )
                )
            }, {
                findNavController().navigate(
                    FragmentFavouritesDirections.actionFragmentFavouritesToFragmentDialogResponse(

                    )
                )
            })
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_favourites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.store.myLiveDataObservable.observe(viewLifecycleOwner) {

            binding.tvCountFavoriteVacancies.text =
                getString(
                    R.string.tv_count_favourites_title,
                    it.favoriteVacancieSet.size.toString()
                )
        }

        binding.rvVerticalContainerItemsListFavorites.adapter = verticalAdapter

        viewModel.store.myLiveDataObservable.observe(viewLifecycleOwner) {
            val listOfFavourites = it.networkData.networkVacancies?.filter { allVacancies ->
                allVacancies.isFavorite
            }
            verticalAdapter.apply {
                items = listOfFavourites
            }
        }

    }
}