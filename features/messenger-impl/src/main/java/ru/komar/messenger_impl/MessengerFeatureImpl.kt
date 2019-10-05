package ru.komar.messenger_impl

import android.content.Context
import ru.komar.base.Feature
import ru.komar.base.FeatureOwner
import ru.komar.base.Projection
import ru.komar.messenger.conversation.ConversationEntry
import ru.komar.messenger.conversationlist.ConversationListEntry
import ru.komar.messenger.MessengerFeature
import ru.komar.messenger_impl.conversation.DefaultConversationEntry
import ru.komar.messenger_impl.conversationlist.DefaultConversationListEntry
import ru.komar.profile_api.ProfileFeature
import ru.komar.versionable.Versionable
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

    override fun conversationListEntry(): ConversationListEntry {
        return DefaultConversationListEntry()
    }

    override fun conversationEntry(): ConversationEntry {
        return DefaultConversationEntry()
    }
}

fun Context.messengerFeature(): MessengerFeatureImpl {
    return (applicationContext as FeatureOwner).findFeature(MessengerFeatureImpl::class.java)!!
}