package com.example.jobsearchapp.state

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class Store<T>(initialState:T) {

    private val _myLiveDataObservable = MutableLiveData(initialState)
    val myLiveDataObservable: LiveData<T>
        get() = _myLiveDataObservable

    fun update(updateBlock: (T) -> T){
        val newState = _myLiveDataObservable.value?.let { updateBlock(it) }
        _myLiveDataObservable.value = newState
    }
}