package ru.komar.sandcastle.versionchecker

import ru.komar.versionable.VersionChecker
import ru.komar.versionable.Versionable

class FakeVersionChecker : VersionChecker {

    override fun check(versionable: Versionable): Boolean {
        return true
    }

}