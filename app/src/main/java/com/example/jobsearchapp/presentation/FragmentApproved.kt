package com.example.jobsearchapp.presentation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.jobsearchapp.R
import com.example.jobsearchapp.databinding.FragmentApprovedBinding
import com.example.jobsearchapp.utils.AsteriskPasswordTransformationMethod
import com.example.jobsearchapp.utils.viewBinding

class FragmentApproved : Fragment() {

    private val args by navArgs<FragmentApprovedArgs>()

    private val binding by viewBinding(FragmentApprovedBinding::bind)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_approved, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        with(binding) {

            tvTitleForConcatEmail.text =
                getString(R.string.args_concat_email, args.emailFromLkEnter)

            passCodeNumber1.transformationMethod =
                AsteriskPasswordTransformationMethod()

            buttonApply.setOnClickListener {
                if (binding.passCodeNumber1.text?.isNotBlank() == true
                    && binding.passCodeNumber2.text.toString() != ""
                    && binding.passCodeNumber3.text.toString() != ""
                    && binding.passCodeNumber4.text.toString() != ""
                ) findNavController().navigate(R.id.action_fragment_approved_to_fragmentMain)
            }

            passCodeNumber1.addTextChangedListener(object :
                TextWatcher {
                override fun beforeTextChanged(s:CharSequence?,start:Int,count:Int,after:Int){}
                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun afterTextChanged(p0: Editable?) {passCodeNumber2.requestFocus()}
            })
            passCodeNumber2.addTextChangedListener(object :
                TextWatcher {
                override fun beforeTextChanged(s:CharSequence?,start:Int,count:Int,after:Int){}
                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun afterTextChanged(p0: Editable?) {passCodeNumber3.requestFocus()}
            })
            passCodeNumber3.addTextChangedListener(object :
                TextWatcher {
                override fun beforeTextChanged(s:CharSequence?,start:Int,count:Int,after:Int){}
                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun afterTextChanged(p0: Editable?) {passCodeNumber4.requestFocus()}
            })
        }
    }
}