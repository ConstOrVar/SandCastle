package ru.komar.messenger_impl

import android.content.Context
import android.content.Intent
import ru.komar.base.Feature
import ru.komar.base.FeatureOwner
import java.util.*
import javax.inject.Inject

class MessengerFeatureImpl(override val context: Context) : ru.komar.messenger.MessengerFeature,
    Feature {
    private lateinit var profileFeature: ru.komar.profile_api.ProfileFeature

    override fun intetForConversationList(): Intent {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun intetForConversation(conversationUuid: UUID): Intent {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Inject
    fun setProfileFeature(profileFeature: ru.komar.profile_api.ProfileFeature) {
        this.profileFeature = profileFeature
    }

}

fun Context.messengerFeature(): MessengerFeatureImpl {
    return (applicationContext as FeatureOwner).findFeature(MessengerFeatureImpl::class.java)!!
}