package ru.komar.calendar_api

import android.content.Intent
import java.util.*

interface CalendarFeature {

    fun intentForCalendar(profileUuid: UUID): Intent

}