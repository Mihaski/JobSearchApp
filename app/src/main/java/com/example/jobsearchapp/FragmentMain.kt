package com.example.jobsearchapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.data.Vacancies
import com.example.data.withouthttp.ListOfOfferses
import com.example.data.withouthttp.ListOfVacancis
import com.example.data.withouthttp.listOfOffers
import com.example.jobsearchapp.MainScreenDelegates.horizontalDelegate
import com.example.jobsearchapp.MainScreenDelegates.verticalDelegate
import com.example.jobsearchapp.databinding.FragmentMainBinding
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentMain.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentMain : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val binding by viewBinding(FragmentMainBinding::bind) //!! IMPORTANT only onViewCreated

    private val verticalAdapter = ListDelegationAdapter(
        verticalDelegate
    )
    private val horizontalAdapter = ListDelegationAdapter(
        horizontalDelegate
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvVerticalContainerMainFragment.adapter = verticalAdapter
        verticalAdapter.apply {
            items = listOf(ListOfVacancis(
                IntRange(1, 20).map {
                    Vacancies(
                        title = it.toString()
                    )
                }
            ))
            notifyDataSetChanged()
        }

        binding.rvHorizontalContainerMainFragment.adapter = horizontalAdapter
        horizontalAdapter.apply {
            items = listOf(ListOfOfferses(listOfOffers))
            notifyDataSetChanged()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentMain.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentMain().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}