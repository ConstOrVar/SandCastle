package ru.komar.profile_impl

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.komar.messenger.conversationlist.ConversationListEntry

class ProfileActivity : AppCompatActivity(), ConversationListEntry.FragmentEntry.Host {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val profileFeature = profileFeature()

        profileFeature.messengerFeature?.source()?.let { messageFeature ->
            val conversationScope = messageFeature
                .conversationListEntry()
                .fragmentEntry(this)

            val conversationListFragment = conversationScope.createFragment()

            conversationScope
                .editableFragment(conversationListFragment)
                ?.setOnConversationClick {
                TODO()
            }
        }
    }

}