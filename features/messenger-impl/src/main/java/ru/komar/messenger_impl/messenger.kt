package ru.komar.messenger_impl

import ru.komar.base.FeatureOwner
import ru.komar.base.prepareFeature

interface MessengerFeatureProvider {
    fun messengerFeature(): MessengerFeatureImpl
}

interface MessengerFeatureInjector {
    fun injectMessengerDependencies(messengerFeature: MessengerFeatureImpl)
}

fun FeatureOwner.prepareMessengerFeature(provider: MessengerFeatureProvider, injector: MessengerFeatureInjector) {
    prepareFeature(provider::messengerFeature, injector::injectMessengerDependencies)
}