package ru.komar.sandcastle.videocall.impl

import android.content.Context
import android.content.Intent
import ru.komar.profile_api.ProfileFeature
import ru.komar.base.Feature
import ru.komar.base.FeatureOwner
import ru.komar.sandcastle.videocall.api.VideoCallFeature
import java.util.*
import javax.inject.Inject

class VideoCallFeatureImpl(override val context: Context) : VideoCallFeature, Feature {
    private lateinit var profileFeature: ProfileFeature

    override fun intentForVideoCall(uuid: UUID): Intent {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Inject
    fun setProfileFeature(profileFeature: ProfileFeature) {
        this.profileFeature = profileFeature
    }

}

fun Context.videcallFeature(): VideoCallFeatureImpl {
    return (applicationContext as FeatureOwner).findFeature(VideoCallFeatureImpl::class.java)!!
}