package ru.komar.profile_impl

import android.content.Context
import android.content.Intent
import ru.komar.calendar_api.CalendarFeature
import ru.komar.messenger.MessengerFeature
import ru.komar.base.Feature
import ru.komar.base.FeatureOwner
import ru.komar.base.Projection
import ru.komar.profile_api.ProfileFeature
import ru.komar.sandcastle.videocall.api.VideoCallFeature
import ru.komar.versionable.Versionable
import java.util.*
import javax.inject.Inject

class ProfileFeatureImpl(
    override val context: Context
) : ProfileFeature,
    Feature,
    Versionable {

    @JvmField
    @Inject
    var messengerFeature: Projection<MessengerFeature>? = null

    @JvmField
    @Inject
    var videoCallFeature: Projection<VideoCallFeature>? = null

    @JvmField
    @Inject
    var calendarFeature: Projection<CalendarFeature>? = null


    override fun intentForProfileList(): Intent {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun intentForProfile(profileUuid: UUID): Intent {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val key: String = "Profile"

    override val version: String = "5.1.2"

}

fun Context.profileFeature(): ProfileFeatureImpl {
    return (applicationContext as FeatureOwner).findFeature(ProfileFeatureImpl::class.java)!!
}
