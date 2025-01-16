package com.example.jobsearchapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.navigation.fragment.navArgs
import com.example.data.Vacancies
import com.example.data.withouthttp.listOfVacancies
import com.example.jobsearchapp.databinding.FragmentVacancieBinding

private const val ARGS_ID_FRAG_VAC = "param1"

class FragmentVacancie : Fragment() {

//    private lateinit var idOfVacancies: String
    private val args by navArgs<FragmentVacancieArgs>()

    private val binding by viewBinding(FragmentVacancieBinding::bind)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_vacancie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
                binding.tvTitle.text = args.vacancies.title
    }

    override val defaultViewModelCreationExtras: CreationExtras
        get() = super.defaultViewModelCreationExtras

    companion object {

        fun newInstance(paramId: String) =
            FragmentVacancie().apply {
                arguments = Bundle().apply {
                    putString(ARGS_ID_FRAG_VAC, paramId)
                }
            }
    }
}