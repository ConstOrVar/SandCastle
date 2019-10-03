package ru.komar.sandcastle

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

// test fragment

interface PublicFragmentApi {
    fun setAny(any: Any)

    val fragment: Fragment
}

class TestFragment : Fragment(), PublicFragmentApi {

    interface Host {
        fun getDIContainer(): Any
    }

    companion object {

        fun createScopedContext(env: Host): TestFragmentScopedContext {
            return TestFragmentScopedContext()
        }

    }

    override fun setAny(any: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val fragment: Fragment = this

}

class TestFragmentScopedContext internal constructor() {

    fun createTestFragment(): PublicFragmentApi {
        return TestFragment()
    }

}

// test activity

class TestActivity : AppCompatActivity() {

    interface Host {
        fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    }

    companion object {

        fun createScopedContext(env: Any): TestActivityScopedContext {
            return TestActivityScopedContext()
        }

        fun createForResultScopedContext(env: Host): TestActivityForResultScopedContext {
            return TestActivityForResultScopedContext()
        }

    }

}

class TestActivityScopedContext internal constructor() {

    fun createIntent(context: Context): Intent = Intent(context, TestActivity::class.java)

}

class TestActivityForResultScopedContext internal constructor() {
    class SomeData

    fun createIntentForResult(context: Context): Intent = Intent(context, TestActivity::class.java)

    fun parseResult(data: Bundle?): SomeData {
        TODO()
    }

}