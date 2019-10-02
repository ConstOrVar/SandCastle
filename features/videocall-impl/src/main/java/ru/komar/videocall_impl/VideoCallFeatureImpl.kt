package ru.komar.sandcastle.videocall.impl

import android.content.Context
import android.content.Intent
import ru.komar.profile_api.ProfileFeature
import ru.komar.base.Feature
import ru.komar.base.FeatureOwner
import ru.komar.base.Projection
import ru.komar.sandcastle.videocall.api.VideoCallFeature
import ru.komar.versionable.Versionable
import java.util.*
import javax.inject.Inject

class VideoCallFeatureImpl(
    override val context: Context
) : VideoCallFeature,
    Feature,
    Versionable {

    @Inject
    lateinit var profileFeature: Projection<ProfileFeature>

    override fun intentForVideoCall(uuid: UUID): Intent {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val key: String = "VideoCall"

    override val version: String = "1.0.1"

}

fun Context.videcallFeature(): VideoCallFeatureImpl {
    return (applicationContext as FeatureOwner).findFeature(VideoCallFeatureImpl::class.java)!!
}