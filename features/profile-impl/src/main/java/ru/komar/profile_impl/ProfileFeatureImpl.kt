package ru.komar.profile_impl

import android.content.Context
import android.content.Intent
import ru.komar.calendar_api.CalendarFeature
import ru.komar.messenger.MessengerFeature
import ru.komar.base.Feature
import ru.komar.base.FeatureOwner
import ru.komar.sandcastle.videocall.api.VideoCallFeature
import java.util.*
import javax.inject.Inject

class ProfileFeatureImpl(override val context: Context) : ru.komar.profile_api.ProfileFeature,
    Feature {
    private var messengerFeature: MessengerFeature? = null
    private var videoCallFeature: VideoCallFeature? = null
    private var calendarFeature: CalendarFeature? = null

    override fun intentForProfileList(): Intent {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun intentForProfile(profileUuid: UUID): Intent {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Inject
    fun setMessengerFeature(messengerFeature: MessengerFeature?) {
        this.messengerFeature = messengerFeature
    }

    @Inject
    fun setVideoCallFeature(videoCallFeature: VideoCallFeature?) {
        this.videoCallFeature = videoCallFeature
    }

    @Inject
    fun setCalendarFeature(calendarFeature: CalendarFeature?) {
        this.calendarFeature = calendarFeature
    }

}

fun Context.profileFeature(): ProfileFeatureImpl {
    return (applicationContext as FeatureOwner).findFeature(ProfileFeatureImpl::class.java)!!
}
