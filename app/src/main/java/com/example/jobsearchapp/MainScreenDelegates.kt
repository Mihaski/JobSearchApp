package com.example.jobsearchapp

import androidx.core.view.isGone
import androidx.core.view.isVisible
import com.example.data.HorizontalBaseClass
import com.example.data.MyOffers
import com.example.data.VerticalBaseClass
import com.example.data.model.NetworkVacancies
import com.example.jobsearchapp.databinding.OffersItemBinding
import com.example.jobsearchapp.databinding.VacanciesItemBinding
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

object MainScreenDelegates {

    fun vacanciesOneItemDelegate(
        itemClickedListener: (NetworkVacancies) -> Unit,
        buttonClickedListener: (NetworkVacancies) -> Unit,
        heartButtonClicked:(NetworkVacancies) -> Unit,
    ) =
        adapterDelegateViewBinding<NetworkVacancies, VerticalBaseClass, VacanciesItemBinding>(
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
            binding.buttCallsToVacancies.setOnClickListener {
                buttonClickedListener(item)
            }
            binding.buttFavoritesHeartBlueOrInactive.setOnClickListener {
                val resId = if (!item.isFavorite) {
                    item.isFavorite = true
                    R.drawable.heart_blue
                } else {
                    item.isFavorite = false
                    R.drawable.ic_favorites
                }
                binding.buttFavoritesHeartBlueOrInactive.setImageResource(
                    resId
                )
                heartButtonClicked(item)
            }
            bind {
                with(binding) {
                    jobTitle.text = item.title

                    when (item.lookingNumber) {

                        0 -> countCurrentlyViewing.isGone = true
                        1 -> countCurrentlyViewing.text =
                            getString(R.string.count_currently_viewing_text_1, item.lookingNumber)

                        2, 3, 4 -> countCurrentlyViewing.text = getString(
                            R.string.count_currently_viewing_text_2_3_4,
                            item.lookingNumber
                        )

                        else -> countCurrentlyViewing.text = getString(
                            R.string.count_currently_viewing_text_all_the_rest,
                            item.lookingNumber
                        )
                    }

                    city.text = item.address?.town
                    salary.text = item.salary?.short
                    experience.text = item.experience?.previewText
                    companyName.text = item.company
                    dateOfPublication.text = item.publishedDate
                    if (item.isFavorite)
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
