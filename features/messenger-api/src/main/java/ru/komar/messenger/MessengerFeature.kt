package ru.komar.messenger

import android.content.Intent
import java.util.*

interface MessengerFeature {
    fun intetForConversationList(): Intent

    fun intetForConversation(conversationUuid: UUID): Intent
}