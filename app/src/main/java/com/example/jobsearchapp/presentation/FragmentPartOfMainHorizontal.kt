package com.example.jobsearchapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.data.withouthttp.listOfOffers
import com.example.jobsearchapp.MainScreenDelegates.myOffersOneItemDelegate
import com.example.jobsearchapp.R
import com.example.jobsearchapp.databinding.OffersItemsListBinding
import com.example.jobsearchapp.utils.viewBinding
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class FragmentPartOfMainHorizontal : Fragment() {

    private val binding by viewBinding(OffersItemsListBinding::bind) //!! IMPORTANT only onViewCreated

    private val horizontalAdapter = ListDelegationAdapter(
        myOffersOneItemDelegate
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvHorizontalContainerItemsList.adapter = horizontalAdapter
        horizontalAdapter.apply {
            items = listOfOffers
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.offers_items_list, container, false)
    }
}