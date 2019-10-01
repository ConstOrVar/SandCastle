package ru.komar.profile_impl

import ru.komar.base.FeatureOwner
import ru.komar.base.prepareFeature

interface ProfileFeatureProvider {
    fun profileFeature(): ProfileFeatureImpl
}

interface ProfileFeatureInjector {
    fun injectProfileDependencies(profileFeature: ProfileFeatureImpl)
}

fun FeatureOwner.prepareProfileFeature(provider: ProfileFeatureProvider, injector: ProfileFeatureInjector) {
    prepareFeature(provider::profileFeature, injector::injectProfileDependencies)
}