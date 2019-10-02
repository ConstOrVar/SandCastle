package ru.komar.sandcastle.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.komar.base.Projection
import ru.komar.sandcastle.videocall.api.VideoCallFeature
import javax.inject.Singleton

@Module
internal class VideoCallModule {

    @Singleton
    @Provides
    fun provideVideoCallFeatureProxy(context: Context): Projection<@JvmWildcard VideoCallFeature>? {
        return null
    }

}