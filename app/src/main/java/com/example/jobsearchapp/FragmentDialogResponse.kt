package com.example.jobsearchapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isGone
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.textfield.TextInputEditText

class FragmentDialogResponse : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.response_fragment_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //TODO: тут клавиатура закрывает ввод
        val editTextMessage =
            view.findViewById<TextInputEditText>(R.id.edit_text_additional_message_response)
        view.findViewById<TextView>(R.id.tv_add_additional_message).setOnClickListener {
            it.isGone = true
            editTextMessage.isGone = false
        }
        view.findViewById<TextView>(R.id.button_response).setOnClickListener {
            findNavController().popBackStack()
        }
    }
}