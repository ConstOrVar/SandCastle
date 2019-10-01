package ru.komar.base

interface FeatureOwner {
    fun <F: Feature> register(feature: F)
    fun <F: Feature> findFeature(clazz: Class<F>): F?
}

class DefaultFeatureOwner : FeatureOwner {
    private val features = mutableMapOf<Class<out Feature>, Feature>()

    override fun <F : Feature> register(feature: F) {
        features[feature::class.java] = feature
    }

    override fun <F : Feature> findFeature(clazz: Class<F>): F? {
        return features[clazz] as F?
    }

}

inline fun <reified F: Feature> FeatureOwner.prepareFeature(provider: () -> F, initBlock: (F) -> Unit) {
    val feature = provider()
    initBlock(feature)
    register(feature)
}