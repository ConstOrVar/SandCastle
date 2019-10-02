package ru.komar.sandcastle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.komar.profile_impl.profileFeature

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            profileFeature().messengerFeature?.let {
                val conversationIntent = it.source().intetForConversationList()
                startActivity(conversationIntent)
            }
        } catch (e: Exception) {
            TODO()
        }
    }
}
