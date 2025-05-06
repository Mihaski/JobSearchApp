package com.example.jobsearchapp

import androidx.core.view.isVisible
import com.example.data.HorizontalBaseClass
import com.example.data.MyOffers
import com.example.data.MyVacancies
import com.example.data.VerticalBaseClass
import com.example.jobsearchapp.databinding.OffersItemBinding
import com.example.jobsearchapp.databinding.VacanciesItemBinding
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

object MainScreenDelegates {

    fun vacanciesOneItemDelegate(itemClickedListener: (MyVacancies) -> Unit) =
        adapterDelegateViewBinding<MyVacancies, VerticalBaseClass, VacanciesItemBinding>(
            { inflater, container ->
                VacanciesItemBinding.inflate(
                    inflater,
                    container,
                    false
                )
            }
        ) {
            binding.root.setOnClickListener {
                itemClickedListener(item)
            }
            binding.buttFavoritesHeartBlueOrInactive.setOnClickListener {
                val resId = if (item.isFavorite == "false") {
                    item.isFavorite = "true"
                    R.drawable.heart_blue
                } else {
                    item.isFavorite = "false"
                    R.drawable.ic_favorites
                }
                binding.buttFavoritesHeartBlueOrInactive.setImageResource(
                    resId
                )
            }
            bind {
                with(binding) {
                    jobTitle.text = item.title
                    countCurrentlyViewing.text =
                        "Сейчас просматривает ${item.lookingNumber} человек"
                    city.text = item.town
                    salary.text = item.salaryShort
                    experience.text = item.previewExperienceText
                    companyName.text = item.company
                    dateOfPublication.text = item.publishedDate
                    if (item.isFavorite == "true")
                        buttFavoritesHeartBlueOrInactive.setImageResource(
                            R.drawable.heart_blue
                        )
                }
            }
        }

    val myOffersOneItemDelegate =
        adapterDelegateViewBinding<MyOffers, HorizontalBaseClass, OffersItemBinding>(
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
