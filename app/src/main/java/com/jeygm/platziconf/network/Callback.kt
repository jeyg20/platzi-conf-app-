package com.jeygm.platziconf.network

import java.lang.Exception

interface Callback<T> {
    fun onSuccess(result : T)

    fun onFail(exception: Exception)
}
