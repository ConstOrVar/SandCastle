package ru.komar.sandcastle.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import ru.komar.base.Projection
import ru.komar.calendar_api.CalendarFeature
import ru.komar.messenger_impl.MessengerFeatureInjector
import ru.komar.messenger_impl.MessengerFeatureProvider
import ru.komar.profile_api.ProfileFeature
import ru.komar.profile_impl.ProfileFeatureImpl
import ru.komar.profile_impl.ProfileFeatureInjector
import ru.komar.profile_impl.ProfileFeatureProvider
import ru.komar.sandcastle.VersionCheckerProjection
import ru.komar.sandcastle.videocall.api.VideoCallFeature
import ru.komar.versionable.VersionChecker
import ru.komar.versionable.Versionable
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

@Module
internal class ProfileModule {

    @Singleton
    @Provides
    fun provideProfileFeatureImpl(context: Context): ProfileFeatureImpl {
        return ru.komar.profile_impl.ProfileFeatureImpl(context)
    }

    @Singleton
    @Provides
    fun provideProfileFeatureProxy(
        impl: ProfileFeatureImpl,
        checker: VersionChecker
    ): Projection<@JvmWildcard ProfileFeature> {
        return VersionCheckerProjection(checker, impl, impl)
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
    fun provideMessengerFeatureProxy(
        impl: ru.komar.messenger_impl.MessengerFeatureImpl,
        checker: VersionChecker
    ): Projection<@JvmWildcard ru.komar.messenger.MessengerFeature> {
        return VersionCheckerProjection(checker, impl, impl)
    }

}

@Module
internal class VideoCallModule {

    @Singleton
    @Provides
    fun provideVideoCallFeatureProxy(context: Context): Projection<@JvmWildcard VideoCallFeature>? {
        return null
    }

}

@Module
internal class CalendarModule {

    @Singleton
    @Provides
    fun provideCalendarFeatureProxy(context: Context): Projection<@JvmWildcard CalendarFeature>? {
        return null
    }

}

@Module
internal class VersionCheckerModule {

    @Singleton
    @Provides
    fun provideVersionChecker(): VersionChecker {
        return object : VersionChecker {

            override fun check(versionable: Versionable): Boolean {
                return true
            }

        }
    }

}