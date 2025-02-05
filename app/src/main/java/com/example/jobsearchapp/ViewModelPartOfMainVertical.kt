package com.example.jobsearchapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.data.Vacancies

class ViewModelPartOfMainVertical(
    application: Application,
) : AndroidViewModel(application) {

    private val _vacancies = MutableLiveData<Vacancies>()
    val vacancies: LiveData<Vacancies>
        get() = _vacancies



}