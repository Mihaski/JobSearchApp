package com.example.jobsearchapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.navigation.fragment.navArgs

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FragmentVacancie : Fragment() {


    private var param1: String? = null
    private var param2: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_vacancie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override val defaultViewModelCreationExtras: CreationExtras
        get() = super.defaultViewModelCreationExtras

    companion object {

        fun newInstance(param1: String, param2: String) =
            FragmentVacancie().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}