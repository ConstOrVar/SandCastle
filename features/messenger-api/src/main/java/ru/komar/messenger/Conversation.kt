package ru.komar.messenger

import java.util.*

data class Conversation(
    val uuid: UUID,
    val title: String,
    val createdAt: Date,
    val updatedAt: Date
)