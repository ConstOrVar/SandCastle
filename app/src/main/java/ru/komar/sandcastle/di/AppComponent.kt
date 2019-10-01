package ru.komar.sandcastle.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import ru.komar.calendar_api.CalendarFeature
import ru.komar.messenger_impl.MessengerFeatureInjector
import ru.komar.messenger_impl.MessengerFeatureProvider
import ru.komar.profile_impl.ProfileFeatureInjector
import ru.komar.profile_impl.ProfileFeatureProvider
import ru.komar.sandcastle.videocall.api.VideoCallFeature
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
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

@Module
internal class ProfileModule {

    @Singleton
    @Provides
    fun provideProfileFeatureImpl(context: Context): ru.komar.profile_impl.ProfileFeatureImpl {
        return ru.komar.profile_impl.ProfileFeatureImpl(context)
    }

    @Singleton
    @Provides
    fun provideProfileFeature(impl: ru.komar.profile_impl.ProfileFeatureImpl): ru.komar.profile_api.ProfileFeature {
        return impl
    }

}

@Module
internal class MessengerModule {

    @Singleton
    @Provides
    fun provideMessengerFeatureImpl(context: Context): ru.komar.messenger_impl.MessengerFeatureImpl {
        return ru.komar.messenger_impl.MessengerFeatureImpl(context)
    }

    @Singleton
    @Provides
    fun provideMessengerFeature(impl: ru.komar.messenger_impl.MessengerFeatureImpl): ru.komar.messenger.MessengerFeature {
        return impl
    }

}

@Module
internal class VideoCallModule {

    @Singleton
    @Provides
    fun provideVideoCallFeature(context: Context): VideoCallFeature? {
        return null
    }

}

@Module
internal class CalendarModule {

    @Singleton
    @Provides
    fun provideCalendarFeature(context: Context): CalendarFeature? {
        return null
    }

}