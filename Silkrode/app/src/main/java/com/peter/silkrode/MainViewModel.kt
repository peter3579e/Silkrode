package com.peter.silkrode

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.peter.silkrode.util.CurrentFragmentType

class MainViewModel():ViewModel() {

    // Record current fragment to support data binding
    val currentFragmentType = MutableLiveData<CurrentFragmentType>()

}