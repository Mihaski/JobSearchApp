package com.example.jobsearchapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.jobsearchapp.databinding.FragmentVacancieBinding

//private const val ARGS_ID_FRAG_VAC = "param1"

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
        binding.buttonArrowBack.setOnClickListener {
            findNavController().popBackStack()
        }
        with(args.vacancies) {
            binding.apply {
                tvTitle.text = title
                tvSalaryFull.text = salaryFull
                experience.text = "Требуемый опыт: ${experienceText}"
                tvSchedules.text = schedules
                if (appliedNumber == "") containerRespondedCount.isGone = true else
                    if (appliedNumber == "2" || appliedNumber == "3" || appliedNumber == "4")
                        tvRespondedCount.text = "${appliedNumber} человека уже откликнулись"
                    else tvRespondedCount.text = "${appliedNumber} человек уже откликнулись"

                when (lookingNumber) {
                    "" -> containerLookingNumber.isGone = true
                    "2" -> tvLookingNumber.text = "${lookingNumber} человека сейчас смотрят"
                    "3" -> tvLookingNumber.text = "${lookingNumber} человека сейчас смотрят"
                    "4" -> tvLookingNumber.text = "${lookingNumber} человека сейчас смотрят"
                    else -> tvLookingNumber.text = "${lookingNumber} человек сейчас смотрят"
                }
                tvCompanyName.text = company
                tvStreet.text = "$town, $street, $house"
                tvFieldDescription.text = description
                tvFieldResponsibilities.text = responsibilities
                tvArrayQuestions1.text = questions
            }
        }
        binding.buttonAppliedVacancie.setOnClickListener {
            findNavController().navigate(FragmentVacancieDirections.actionFragmentVacancieToFragmentDialogResponse())
        }
//        binding.tvTitle.text=args.vacancies.title
//        binding.tvSalaryFull.text=args.vacancies.salaryFull
//        binding.experience.text="Требуемый опыт: ${args.vacancies.experienceText}"
//        binding.tvSchedules.text=args.vacancies.schedules
    }

    override val defaultViewModelCreationExtras: CreationExtras
        get() = super.defaultViewModelCreationExtras

//    companion object {
//
//        fun newInstance(paramId: String) =
//            FragmentVacancie().apply {
//                arguments = Bundle().apply {
//                    putString(ARGS_ID_FRAG_VAC, paramId)
//                }
//            }
//    }
}