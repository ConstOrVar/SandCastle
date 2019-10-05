package ru.komar.messenger.conversationlist

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import ru.komar.messenger.Conversation

interface ConversationListEntry {

    fun intent(context: Context): Intent

    fun <T> fragmentEntry(host: T): FragmentEntry where T: Activity, T: FragmentEntry.Host

    fun <T> fragmentEntry(host: T): FragmentEntry where T: Fragment, T: FragmentEntry.Host

    interface FragmentEntry {
        interface Host

        interface Editable {
            fun setOnConversationClick(block: ((Conversation) -> Unit)?)
        }

        fun createFragment(): Fragment

        fun editableFragment(fragment: Fragment): Editable?
    }

}