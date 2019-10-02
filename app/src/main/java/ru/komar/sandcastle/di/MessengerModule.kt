package ru.komar.sandcastle.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.komar.base.Projection
import ru.komar.messenger.MessengerFeature
import ru.komar.messenger_impl.MessengerFeatureImpl
import ru.komar.sandcastle.versionchecker.VersionCheckingProjection
import ru.komar.versionable.VersionChecker
import javax.inject.Singleton

@Module
internal class MessengerModule {

    @Singleton
    @Provides
    fun provideMessengerFeatureImpl(context: Context): MessengerFeatureImpl {
        return MessengerFeatureImpl(context)
    }

    @Singleton
    @Provides
    fun provideMessengerFeatureProxy(
        impl: MessengerFeatureImpl,
        checker: VersionChecker
    ): Projection<@JvmWildcard MessengerFeature> {
        return VersionCheckingProjection(checker, MessengerFeatureImpl.Companion, impl)
    }

}