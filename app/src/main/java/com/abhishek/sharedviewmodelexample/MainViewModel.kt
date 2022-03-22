package com.abhishek.sharedviewmodelexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val selectedUrl = MutableLiveData<String>()
}