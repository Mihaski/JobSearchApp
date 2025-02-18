package com.example.jobsearchapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.data.withouthttp.listOfVacancies
import com.example.jobsearchapp.MainScreenDelegates.vacanciesOneItemDelegate
import com.example.jobsearchapp.R
import com.example.jobsearchapp.databinding.FragmentFavouritesBinding
import com.example.jobsearchapp.utils.viewBinding
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class FragmentFavourites : Fragment() {

    private val binding by viewBinding(FragmentFavouritesBinding::bind)

    private val verticalAdapter = ListDelegationAdapter(
        vacanciesOneItemDelegate {
            findNavController().navigate(
                FragmentFavouritesDirections.actionFragmentFavouritesToFragmentVacancie(
                    it
                )
            )
        }
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
        val listOfFavourites = listOfVacancies.toMutableList().apply {
            this.removeIf { it.isFavorite == "false" }
        }
        binding.rvVerticalContainerItemsListFavorites.adapter = verticalAdapter
        verticalAdapter.apply {
            items = listOfFavourites
        }
    }
}