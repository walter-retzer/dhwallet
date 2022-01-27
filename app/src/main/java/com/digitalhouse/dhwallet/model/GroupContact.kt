package com.digitalhouse.dhwallet.model

class GroupContact(
    val type: GroupType,
    val title: String? = null,
    val image: String? = null,
    val name: String? = null,
    val contactType: ContactType? = null
)

enum class GroupType {
    TITLE,
    CONTENT
}
