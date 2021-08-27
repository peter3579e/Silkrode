package com.peter.silkrode.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.peter.silkrode.data.Result
import com.peter.silkrode.data.User
import com.peter.silkrode.data.source.SilkrodeRepository
import com.peter.silkrode.network.SilkrodeApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class HomeViewModel(private val silkrodeRepository: SilkrodeRepository) : ViewModel() {

    val _userList = MutableLiveData<List<User>>()

    // The external LiveData interface to the property is immutable, so only this class can modify
    val userList: LiveData<List<User>>
        get() = _userList

    // Create a Coroutine scope using a job to be able to cancel when needed
    private var viewModelJob = Job()

    // the Coroutine runs using the Main (UI) dispatcher
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getFollowerList()
    }

    /**
     * track [SilkrodeRepository.getFollowerList]: -> [DefaultSilkrodeRepository] : [SilkrodeRepository] -> [SilkeodeRemoteDataSource] : [SilkrodeDataSource]
     */

    fun getFollowerList() {
        coroutineScope.launch {
            val result = silkrodeRepository.getFollowerList()

            _userList.value = when (result) {
                is Result.Success -> {
                    result.data
                }
                else -> {
                    null
                }
            }
        }
    }
}