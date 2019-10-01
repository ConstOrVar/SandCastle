package ru.komar.sandcastle

import android.app.Application
import ru.komar.base.DefaultFeatureOwner
import ru.komar.base.FeatureOwner
import ru.komar.messenger_impl.prepareMessengerFeature
import ru.komar.profile_impl.prepareProfileFeature
import ru.komar.sandcastle.di.DaggerAppComponent

internal class MyApp : Application(),
    FeatureOwner by DefaultFeatureOwner() {

    private val appComponent = DaggerAppComponent.factory()
        .create(this)

    override fun onCreate() {
        super.onCreate()

        prepareProfileFeature(appComponent, appComponent)
        prepareMessengerFeature(appComponent, appComponent)
    }

}