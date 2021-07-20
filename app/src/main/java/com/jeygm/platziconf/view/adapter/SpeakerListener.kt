package com.jeygm.platziconf.view.adapter

import com.jeygm.platziconf.model.Speaker

interface SpeakerListener {
    fun onSpeakerClicked(speaker: Speaker, position: Int)
}