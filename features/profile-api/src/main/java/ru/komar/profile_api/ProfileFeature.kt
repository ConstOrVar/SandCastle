package ru.komar.profile_api

import android.content.Intent
import java.util.*

interface ProfileFeature {

    fun intentForProfileList(): Intent

    fun intentForProfile(profileUuid: UUID): Intent

}