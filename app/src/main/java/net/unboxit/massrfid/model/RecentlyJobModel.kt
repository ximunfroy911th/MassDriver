package net.unboxit.massrfid.model

import java.util.Date

data class RecentlyJobModel(
    val id: String,
    val name: String,
    val done: Boolean,
    val create: Date
)
