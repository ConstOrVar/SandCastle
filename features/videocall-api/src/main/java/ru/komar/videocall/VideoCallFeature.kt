package ru.komar.sandcastle.videocall.api

import android.content.Intent
import java.util.*

interface VideoCallFeature {

    fun intentForVideoCall(uuid: UUID): Intent

}