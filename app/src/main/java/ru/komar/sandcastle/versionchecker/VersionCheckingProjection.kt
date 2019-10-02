package ru.komar.sandcastle.versionchecker

import ru.komar.base.Feature
import ru.komar.base.Projection
import ru.komar.versionable.VersionChecker
import ru.komar.versionable.Versionable

class VersionCheckingProjection<T>(
    private val checker: VersionChecker,
    private val versionable: Versionable,
    private val target: T
) : Projection<T> where T: Feature {

    override fun source(): T {
        checkVersion()
        return target
    }

    @Throws(IllegalStateException::class)
    private fun checkVersion() {
        if(!checker.check(versionable)) {
            throw IllegalStateException("Wrong module = ${versionable.key} with version = ${versionable.version}")
        }
    }

}