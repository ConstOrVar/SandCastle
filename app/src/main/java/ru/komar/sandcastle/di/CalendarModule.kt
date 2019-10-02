package ru.komar.sandcastle.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.komar.base.Projection
import ru.komar.calendar_api.CalendarFeature
import javax.inject.Singleton

@Module
internal class CalendarModule {

    @Singleton
    @Provides
    fun provideCalendarFeatureProxy(context: Context): Projection<@JvmWildcard CalendarFeature>? {
        return null
    }

}