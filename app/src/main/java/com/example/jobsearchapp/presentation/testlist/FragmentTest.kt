package com.example.jobsearchapp.presentation.testlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.data.withouthttp.listOfVacancies
import com.example.jobsearchapp.R
import com.example.jobsearchapp.databinding.FragmentTestBinding
import com.example.jobsearchapp.utils.viewBinding

class FragmentTest : Fragment() {

    private val binding by viewBinding(FragmentTestBinding::bind) //!! IMPORTANT only onViewCreated

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listTestRV = binding.rvTestContainer
        val adapterTest = TestAdapter()
        listTestRV.adapter = adapterTest

        adapterTest.submitList(listOfVacancies)

        adapterTest.onVacancieClickListener = {
            if (it.isFavorite == "false") it.isFavorite = "true"
            else it.isFavorite = "false"
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