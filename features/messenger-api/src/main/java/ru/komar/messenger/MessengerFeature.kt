package ru.komar.messenger

import ru.komar.messenger.conversation.ConversationEntry
import ru.komar.messenger.conversationlist.ConversationListEntry

interface MessengerFeature {

    fun conversationListEntry(): ConversationListEntry

    fun conversationEntry(): ConversationEntry

}