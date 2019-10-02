package ru.komar.sandcastle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.komar.profile_impl.profileFeature
import ru.komar.sandcastle.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        profileFeature().messengerFeature?.call {
            val intent = intetForConversationList()
            startActivity(intent)
        }
    }
}
