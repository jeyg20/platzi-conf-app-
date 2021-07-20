package com.jeygm.platziconf.model

import java.io.Serializable
import java.util.*

class Conference: Serializable {
    lateinit var title: String
    lateinit var descriptions: String
    lateinit var tag: String
    lateinit var datetime: Date
    lateinit var speaker: String

}