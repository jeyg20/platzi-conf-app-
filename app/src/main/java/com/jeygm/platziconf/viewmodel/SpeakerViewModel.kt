package com.jeygm.platziconf.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jeygm.platziconf.model.Speaker
import com.jeygm.platziconf.network.Callback
import com.jeygm.platziconf.network.FireStoreService
import java.lang.Exception

class SpeakerViewModel : ViewModel() {
    val fireStoreService = FireStoreService()
    var listSchedule : MutableLiveData<List<Speaker>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh() {
        getSpeakersFromFirebase()
    }

    private fun getSpeakersFromFirebase() {
        fireStoreService.getSpeakers(object : Callback<List<Speaker>> {
            override fun onSuccess(result: List<Speaker>) {
                listSchedule.postValue(result)
                proccesFinished()
            }

            override fun onFail(exception: Exception) {
                proccesFinished()
            }
        })
    }

    private fun proccesFinished() {
        isLoading.value = true
    }
}