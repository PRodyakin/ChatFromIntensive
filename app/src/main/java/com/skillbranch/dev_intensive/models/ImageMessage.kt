package com.skillbranch.devintensive.models

import com.skillbranch.devintensive.extensions.doFormat
import com.skillbranch.devintensive.extensions.humanizeDiff
import java.util.*

class ImageMessage(
    id: String,
    from: User?,
    chat: Chat,
    isIncomming: Boolean = false,
    date: Date = Date(),
    var image: String?
) : BaseMessage(id, from, chat, isIncomming, date) {
    override fun formatMessage(): String {
        return "$id ${from?.firstName}" +
                "${if (isIncomming) "получил" else "отправил"} изображение \"$image\" ${date.humanizeDiff()}"
    }
}