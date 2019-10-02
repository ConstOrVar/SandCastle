package ru.komar.base

import java.lang.Exception

interface Projection<out T> {

    @Throws(Exception::class)
    fun source(): T

}