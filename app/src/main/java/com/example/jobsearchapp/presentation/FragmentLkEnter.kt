package com.example.jobsearchapp.presentation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.jobsearchapp.MainViewModel
import com.example.jobsearchapp.R
import com.example.jobsearchapp.databinding.FragmentLkEnterBinding
import com.example.jobsearchapp.utils.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentLkEnter : Fragment() {

    private val binding by viewBinding(FragmentLkEnterBinding::bind)

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_lk_enter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonContinue.setOnClickListener {
            binding.etEmail.clearFocus()
            viewModel.validateEmail(binding.etEmail.text.toString())
            binding.etEmail.requestFocus()
            if (viewModel.validateEmail(binding.etEmail.text.toString()))
                findNavController().navigate(R.id.action_fragmentLkEnter_to_fragment_approved)
        }

        binding.etEmail.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus &&
                binding.etEmail.text.toString() == getString(R.string.text_EditText)
            ) binding.etEmail.setText("")
            if (!hasFocus && binding.etEmail.text.toString() == "") binding.etEmail.setText(
                getString(R.string.text_EditText)
            )
        }

        binding.etEmail.addTextChangedListener(object :
            TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                viewModel.resetErrorInputEmail()
            }

            override fun afterTextChanged(p0: Editable?) {}
        })

        viewModel.errorInputEmail.observe(viewLifecycleOwner) {
            if (it) binding.tvErrorTextInput.isVisible = true
            else binding.tvErrorTextInput.isGone = true
        }
    }

}