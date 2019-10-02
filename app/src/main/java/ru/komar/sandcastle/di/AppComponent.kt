package ru.komar.sandcastle.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.komar.messenger_impl.MessengerFeatureInjector
import ru.komar.messenger_impl.MessengerFeatureProvider
import ru.komar.profile_impl.ProfileFeatureInjector
import ru.komar.profile_impl.ProfileFeatureProvider
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        VersionCheckerModule::class,
        ProfileModule::class,
        MessengerModule::class,
        CalendarModule::class,
        VideoCallModule::class
    ]
)
interface AppComponent :
    ProfileFeatureProvider,
    MessengerFeatureProvider,
    ProfileFeatureInjector,
    MessengerFeatureInjector {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

}









