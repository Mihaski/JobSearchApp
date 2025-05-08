package com.example.jobsearchapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.jobsearchapp.R
import com.example.jobsearchapp.databinding.FragmentVacancieBinding
import com.example.jobsearchapp.utils.viewBinding

class FragmentVacancie : Fragment() {

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
            findNavController().navigate(R.id.action_fragmentVacancie_to_fragmentDialogResponse)
        }
    }
}