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
                tvSalaryFull.text = salary?.full
                experience.text = getString(R.string.exp_text_field, experience)
                tvSchedules.text = schedules.toString()

                when (appliedNumber) {
                    0 -> containerRespondedCount.isGone = true
                    1 -> tvRespondedCount.text =
                        getString(R.string.tv_responded_count_1, appliedNumber)

                    2, 3, 4 -> tvRespondedCount.text =
                        getString(R.string.tv_responded_count_2_3_4, appliedNumber)

                    else -> tvRespondedCount.text =
                        getString(R.string.tv_responded_count_all_the_rest, appliedNumber)
                }
                when (lookingNumber) {
                    0 -> containerLookingNumber.isGone = true
                    1 -> tvLookingNumber.text =
                        getString(R.string.tv_looking_number_1, lookingNumber)

                    2, 3, 4 -> tvLookingNumber.text =
                        getString(R.string.tv_looking_number_2_3_4, lookingNumber)

                    else -> tvLookingNumber.text =
                        getString(R.string.tv_looking_number_all_the_rest, lookingNumber)
                }

                tvCompanyName.text = company
                tvStreet.text =
                    getString(R.string.tv_street, address?.town, address?.street, address?.house)
                tvFieldDescription.text = description
                tvFieldResponsibilities.text = responsibilities
                tvArrayQuestions1.text = questions.toString()
            }
        }

        binding.buttonAppliedVacancie.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentVacancie_to_fragmentDialogResponse)
        }
    }
}