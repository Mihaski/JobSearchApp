package com.example.jobsearchapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.data.Vacancies
import com.example.data.withouthttp.ListOfVacancis
import com.example.jobsearchapp.MainScreenDelegates.horizontalDelegate
import com.example.jobsearchapp.MainScreenDelegates.verticalDelegate
import com.example.jobsearchapp.databinding.FragmentTestBinding
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class FragmentTest:Fragment() {

    private val binding by viewBinding(FragmentTestBinding::bind) //!! IMPORTANT only onViewCreated

    private val verticalAdapter = ListDelegationAdapter(
        verticalDelegate
    )
    private val horizontalAdapter = ListDelegationAdapter(
        horizontalDelegate
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvTestContainer.adapter = verticalAdapter
        verticalAdapter.apply {
            items = listOf(ListOfVacancis(
                IntRange(1, 20).map {
                    Vacancies(
                        title = it.toString()
                    )
                }
            ))
            notifyDataSetChanged()
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test, container, false)
    }
}