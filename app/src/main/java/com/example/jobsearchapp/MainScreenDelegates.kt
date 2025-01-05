package com.example.jobsearchapp

import androidx.core.view.isVisible
import com.example.data.HorizontalBaseClass
import com.example.data.Offers
import com.example.data.Vacancies
import com.example.data.VerticalBaseClass
import com.example.data.withouthttp.ListOfOfferses
import com.example.data.withouthttp.ListOfVacancis
import com.example.jobsearchapp.databinding.OffersItemBinding
import com.example.jobsearchapp.databinding.OffersItemsListBinding
import com.example.jobsearchapp.databinding.VacanciesItemBinding
import com.example.jobsearchapp.databinding.VacanciesItemsListBinding
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

object MainScreenDelegates {

    val verticalDelegate =
        adapterDelegateViewBinding<ListOfVacancis, VerticalBaseClass, VacanciesItemsListBinding>(
            { inflater, container ->
                VacanciesItemsListBinding.inflate(inflater, container, false).apply {
                    rvVerticalContainerItemsList.adapter = ListDelegationAdapter(vacanciesDelegate)
                }
            }
        ) {
            bind {
                (binding.rvVerticalContainerItemsList.adapter as ListDelegationAdapter<List<VerticalBaseClass>>)
                    .apply {
                        items = item.listVacanci
                        notifyDataSetChanged()
                    }
            }
        }

    private val vacanciesDelegate =
        adapterDelegateViewBinding<Vacancies, VerticalBaseClass, VacanciesItemBinding>(
            { inflater, container ->
                VacanciesItemBinding.inflate(
                    inflater,
                    container,
                    false
                )
            }
        ) {
            bind {
                with(binding) {
                    jobTitle.text = item.title
                    countCurrentlyViewing.text = "Cdsfasdf ${item.lookingNumber} xtkjdtr"
                    city.text = item.town
                    salary.text = item.salaryShort
                    experience.text = item.previewExperienceText
                    companyName.text = item.company
                    dateOfPublication.text = item.publishedDate
                }
            }
        }

    val horizontalDelegate =
        adapterDelegateViewBinding<ListOfOfferses, HorizontalBaseClass, OffersItemsListBinding>(
            { inflater, container ->
                OffersItemsListBinding.inflate(inflater, container, false).apply {
                    rvHorizontalContainerItemsList.adapter = ListDelegationAdapter(offersDelegate)
                }
            }
        ) {
            bind {
                (binding.rvHorizontalContainerItemsList.adapter as ListDelegationAdapter<List<HorizontalBaseClass>>)
                    .apply {
                        items = item.listOffers
                        notifyDataSetChanged()
                    }
            }
        }

    private val offersDelegate =
        adapterDelegateViewBinding<Offers, HorizontalBaseClass, OffersItemBinding>(
            { inflater, container ->
                OffersItemBinding.inflate(
                    inflater,
                    container,
                    false
                )
            }
        ) {
            bind {
                when (item.id) {
                    "near_vacancies" -> {}
                    "level_up_resume" -> {
                        with(binding) {
                            ivOffers.setImageResource(R.drawable.green_star)
                            ivOffers.setBackgroundColor(getColor(R.color.dark_green))
                        }
                    }

                    "temporary_job" -> {
                        with(binding) {
                            ivOffers.setImageResource(R.drawable.icon_paper_ok)
                            ivOffers.setBackgroundColor(getColor(R.color.dark_green))
                        }
                    }

                    else -> {
                        binding.ivOffers.isVisible = false
                    }
                }
                if (item.button == "") binding.tvUpCurriculumVitae.isVisible = false
                binding.tvOffersTitle.text = item.title
            }
        }
}