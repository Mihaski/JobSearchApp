package com.example.jobsearchapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.data.withouthttp.listOfVacancies
import com.example.jobsearchapp.MainScreenDelegates.vacanciesOneItemDelegate
import com.example.jobsearchapp.databinding.VacanciesItemsListBinding
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class FragmentPartOfMainVertical : Fragment() {

    private val binding by viewBinding(VacanciesItemsListBinding::bind) //!! IMPORTANT only onViewCreated

    private val verticalAdapter = ListDelegationAdapter(
        vacanciesOneItemDelegate {
//            parentFragmentManager.beginTransaction()
//                .replace(R.id.vertical_container_for_rv, FragmentVacancie.newInstance(it.id))
//                .commit()
            findNavController().navigate(
                FragmentMainDirections.actionFragmentMainToFragmentVacancie(
                    it
                )
            )
        }
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvVerticalContainerItemsListWithoutScreen.adapter = verticalAdapter
        verticalAdapter.apply {
            items = listOfVacancies
            notifyDataSetChanged()
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