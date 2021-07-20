package com.jeygm.platziconf.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jeygm.platziconf.model.Conference
import com.jeygm.platziconf.network.Callback
import com.jeygm.platziconf.network.FireStoreService
import java.lang.Exception

class ScheduleViewModel : ViewModel() {
   val fireStoreService = FireStoreService()
   var listSchedule : MutableLiveData<List<Conference>> = MutableLiveData()
   var isLoading = MutableLiveData<Boolean>()

   fun refresh() {
      getScheduleFromFirebase()
   }

   private fun getScheduleFromFirebase() {
      fireStoreService.getSchedule(object : Callback<List<Conference>> {
         override fun onSuccess(result: List<Conference>) {
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