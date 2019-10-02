package ru.komar.messenger_impl

import android.content.Context
import android.content.Intent
import ru.komar.base.Feature
import ru.komar.base.FeatureOwner
import ru.komar.base.Projection
import ru.komar.messenger.MessengerFeature
import ru.komar.profile_api.ProfileFeature
import ru.komar.versionable.Versionable
import java.util.*
import javax.inject.Inject

class MessengerFeatureImpl(
    override val context: Context
) : MessengerFeature,
    Feature {

    companion object : Versionable {

        override val key: String = "Messenger"

        override val version: String = "2.0.0"

    }

    @Inject
    lateinit var profileFeature: Projection<ProfileFeature>

    override fun intetForConversationList(): Intent {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun intetForConversation(conversationUuid: UUID): Intent {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}

fun Context.messengerFeature(): MessengerFeatureImpl {
    return (applicationContext as FeatureOwner).findFeature(MessengerFeatureImpl::class.java)!!
}