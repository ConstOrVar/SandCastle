package ru.komar.messenger.conversation

import android.content.Context
import android.content.Intent
import ru.komar.messenger.Conversation

interface ConversationEntry {

    fun intent(context: Context, conversation: Conversation): Intent

}