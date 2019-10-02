package ru.komar.sandcastle.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.komar.base.Projection
import ru.komar.profile_api.ProfileFeature
import ru.komar.profile_impl.ProfileFeatureImpl
import ru.komar.sandcastle.versionchecker.VersionCheckingProjection
import ru.komar.versionable.VersionChecker
import javax.inject.Singleton

@Module
internal class ProfileModule {

    @Singleton
    @Provides
    fun provideProfileFeatureImpl(context: Context): ProfileFeatureImpl {
        return ProfileFeatureImpl(context)
    }

    @Singleton
    @Provides
    fun provideProfileFeatureProxy(
        impl: ProfileFeatureImpl,
        checker: VersionChecker
    ): Projection<@JvmWildcard ProfileFeature> {
        return VersionCheckingProjection(checker, ProfileFeatureImpl.Companion, impl)
    }

}