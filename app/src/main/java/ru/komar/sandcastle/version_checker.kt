package ru.komar.sandcastle

import ru.komar.base.Feature
import ru.komar.base.Projection
import ru.komar.versionable.VersionChecker
import ru.komar.versionable.Versionable

class VersionCheckerProjection<out T>(
    private val checker: VersionChecker,
    private val versionable: Versionable,
    private val target: T
) : Projection<T> where T: Feature, T: Versionable {

    override fun call(block: T.() -> Unit) {
        checkVersion()
        target.block()
    }

    @Throws(IllegalStateException::class)
    private fun checkVersion() {
        if(!checker.check(versionable)) {
            throw IllegalStateException("Wrong module = ${versionable.key} with version = ${versionable.version}")
        }
    }

}