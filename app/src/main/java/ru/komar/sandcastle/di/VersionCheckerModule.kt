package ru.komar.sandcastle.di

import dagger.Module
import dagger.Provides
import ru.komar.sandcastle.versionchecker.FakeVersionChecker
import ru.komar.versionable.VersionChecker
import javax.inject.Singleton

@Module
internal class VersionCheckerModule {

    @Singleton
    @Provides
    fun provideVersionChecker(): VersionChecker {
        return FakeVersionChecker()
    }

}