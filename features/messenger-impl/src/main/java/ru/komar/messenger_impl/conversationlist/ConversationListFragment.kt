package ru.komar.messenger_impl.conversationlist

import androidx.fragment.app.Fragment
import ru.komar.messenger.Conversation
import ru.komar.messenger.conversationlist.ConversationListEntry

internal class ConversationListFragment : Fragment(),
    ConversationListEntry.FragmentEntry.Editable {

    override fun setOnConversationClick(block: ((Conversation) -> Unit)?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
