package com.peter.silkrode.ui.userdetail

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

class UserDetailViewModel(private val silkrodeRepository: SilkrodeRepository, name: String) :
    ViewModel() {


    val _userDetail = MutableLiveData<User>()

    // The external LiveData interface to the property is immutable, so only this class can modify
    val userDetail: LiveData<User>
        get() = _userDetail

    // Create a Coroutine scope using a job to be able to cancel when needed
    private var viewModelJob = Job()

    // the Coroutine runs using the Main (UI) di spatcher
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getInfo(name)
    }

    /**
     * track [SilkrodeRepository.getMyUserDetail]: -> [DefaultSilkrodeRepository] : [SilkrodeRepository] -> [SilkeodeRemoteDataSource] : [SilkrodeDataSource]
     * @param name: the input String
     */


    fun getInfo(name: String) {
        coroutineScope.launch {
            val result = silkrodeRepository.getMyUserDetail(name)

            _userDetail.value = when (result) {
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