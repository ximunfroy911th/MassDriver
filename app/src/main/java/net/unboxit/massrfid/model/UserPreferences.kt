package net.unboxit.massrfid.model

enum class SortOrder {
    NONE,
    ASC,
    DESC
}
data class UserPreferences(
    val showCompleted: Boolean,
    val shortOrder: SortOrder,
    val accessToken : String,
)
