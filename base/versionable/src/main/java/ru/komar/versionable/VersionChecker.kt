package ru.komar.versionable

interface VersionChecker {

    fun check(versionable: Versionable): Boolean

}