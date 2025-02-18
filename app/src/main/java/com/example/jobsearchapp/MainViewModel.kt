package com.example.jobsearchapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.data.Vacancie

class MainViewModel(
    application: Application,
) : AndroidViewModel(application) {

    private val _vacancie = MutableLiveData<Vacancie>()
    val vacancie: LiveData<Vacancie>
        get() = _vacancie



}