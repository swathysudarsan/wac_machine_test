package com.example.sampleappwac.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel:ViewModel() {

    val showLoader: MutableLiveData<Boolean> = MutableLiveData()

}