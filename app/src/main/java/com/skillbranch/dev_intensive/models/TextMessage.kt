package com.skillbranch.devintensive.models

import com.skillbranch.devintensive.extensions.humanizeDiff
import java.util.*

class TextMessage(
    id: String,
    from: User?,
    chat: Chat,
    isIncomming: Boolean = false,
    date: Date = Date(),
    var text: String?
) : BaseMessage(id, from, chat, isIncomming, date) {
    override fun formatMessage(): String {
        return "$id ${from?.firstName} " +
                "${if (isIncomming) "получил" else "отправил"} сообщение \"$text\" ${date.humanizeDiff()}"
    }
}
