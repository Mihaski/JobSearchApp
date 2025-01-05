package com.example.jobsearchapp

import com.example.data.ListMainScreenHorizontalItem
import com.example.data.ListMainScreenVerticalItem
import com.example.data.Offers
import com.example.data.Vacancies
import com.example.data.withouthttp.listOfOffers
import com.example.data.withouthttp.listOfVacancies
import com.example.jobsearchapp.databinding.OffersItemLevelUpResumeBinding
import com.example.jobsearchapp.databinding.OffersItemNearVacanciesBinding
import com.example.jobsearchapp.databinding.OffersItemTemporaryJobBinding
import com.example.jobsearchapp.databinding.OffersItemsListBinding
import com.example.jobsearchapp.databinding.VacanciesItemBinding
import com.example.jobsearchapp.databinding.VacanciesItemsListBinding
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

object MainScreenDelegates {

    val vacanciesVerticalListDelegate =
        adapterDelegateViewBinding<Vacancies, ListMainScreenVerticalItem, VacanciesItemsListBinding>(
            { inflater, container ->
                VacanciesItemsListBinding.inflate(inflater, container, false).apply {
                    rvVerticalContainerMainFragment.adapter = vacanciesListAdapter
                }
            }
        ) {
            bind {
                (binding.rvVerticalContainerMainFragment.adapter as ListDelegationAdapter<List<ListMainScreenVerticalItem>>)
                    .apply {
                        items = listOfVacancies
                        notifyDataSetChanged()
                    }
            }
        }

    private val vacanciesDelegate =
        adapterDelegateViewBinding<Vacancies, ListMainScreenVerticalItem, VacanciesItemBinding>(
            { inflater, container ->
                VacanciesItemBinding.inflate(
                    inflater,
                    container,
                    false
                )
            }
        ) {
            bind {
                binding.jobTitle.text = item.title
                binding.countCurrentlyViewing.text = "Cdsfasdf ${item.lookingNumber} xtkjdtr"
                binding.city.text = item.town
                binding.salary.text = item.salaryShort
                binding.experience.text = item.previewExperienceText
                binding.companyName.text = item.company
                binding.dateOfPublication.text = item.publishedDate
            }
        }

    private val vacanciesListAdapter = ListDelegationAdapter(
        vacanciesDelegate
    )

    val offersHorizontalListDelegate =
        adapterDelegateViewBinding<Offers, ListMainScreenHorizontalItem, OffersItemsListBinding>(
            { inflater, container ->
                OffersItemsListBinding.inflate(inflater, container, false).apply {
                    rvHorizontalContainerMainFragment.adapter = offersAdapter
                }
            }
        ) {
            (binding.rvHorizontalContainerMainFragment.adapter as ListDelegationAdapter<List<ListMainScreenHorizontalItem>>)
                .apply {
                    items = listOfOffers
                    notifyDataSetChanged()
                }
        }

    private val offersNearDelegate =
        adapterDelegateViewBinding<Offers, ListMainScreenHorizontalItem, OffersItemNearVacanciesBinding>(
            { inflater, container ->
                OffersItemNearVacanciesBinding.inflate(
                    inflater,
                    container,
                    false
                )
            }
        ) {
            bind {
                binding.tvOffersTitle.text = item.title
            }
        }

    private val offersLevelDelegate =
        adapterDelegateViewBinding<Offers, ListMainScreenHorizontalItem, OffersItemLevelUpResumeBinding>(
            { inflater, container ->
                OffersItemLevelUpResumeBinding.inflate(
                    inflater,
                    container,
                    false
                )
            }
        ) {
            bind {
                binding.tvOffersTitle.text = item.title
            }
        }

    private val offersTemporaryDelegate =
        adapterDelegateViewBinding<Offers, ListMainScreenHorizontalItem, OffersItemTemporaryJobBinding>(
            { inflater, container ->
                OffersItemTemporaryJobBinding.inflate(
                    inflater,
                    container,
                    false
                )
            }
        ) {
            bind {
                binding.tvOffersTitle.text = item.title
            }
        }

    private val offersAdapter = ListDelegationAdapter(
        offersTemporaryDelegate, offersLevelDelegate, offersNearDelegate
    )
}