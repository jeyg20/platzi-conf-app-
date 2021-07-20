package com.jeygm.platziconf.view.adapter

import com.jeygm.platziconf.model.Conference

interface ScheduleListener {
    fun onConferenceClick(conference : Conference, position : Int)
}