package ru.komar.messenger_impl.conversationlist

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import ru.komar.messenger.conversationlist.ConversationListEntry

internal class DefaultConversationListEntry : ConversationListEntry {

    override fun intent(context: Context): Intent {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun <T> fragmentEntry(host: T): ConversationListEntry.FragmentEntry
            where T: Activity,
                  T : ConversationListEntry.FragmentEntry.Host {
        return DefaultFragmentEntry()
    }

    override fun <T> fragmentEntry(host: T): ConversationListEntry.FragmentEntry
            where T: Fragment,
                  T : ConversationListEntry.FragmentEntry.Host {
        return DefaultFragmentEntry()
    }

    private class DefaultFragmentEntry :
        ConversationListEntry.FragmentEntry {

        override fun createFragment(): Fragment {
            return ConversationListFragment()
        }

        override fun editableFragment(fragment: Fragment): ConversationListEntry.FragmentEntry.Editable? {
            return fragment as? ConversationListFragment
        }


    }
}