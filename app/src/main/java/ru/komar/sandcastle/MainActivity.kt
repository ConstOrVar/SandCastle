package ru.komar.sandcastle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.komar.profile_impl.profileFeature

class MainActivity : AppCompatActivity()/*, TestFragment.Host*//*, TestActivity.Host*/ {

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

        val testFragmentContext = TestFragment
            .createScopedContext(this)
        val fragmentPublicApi = testFragmentContext.createTestFragment()
        supportFragmentManager
            .beginTransaction()
            .add(0, fragmentPublicApi.fragment)
            .commit()

        val testActivityScopedContext = TestActivity
            .createScopedContext(this)
        testActivityScopedContext.createIntent(this)

        val testActivityForResultScopedContext = TestActivity
            .createForResultScopedContext(this)
        testActivityForResultScopedContext.createIntentForResult(this)
    }

/*    override fun getDIContainer(): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }*/

}
