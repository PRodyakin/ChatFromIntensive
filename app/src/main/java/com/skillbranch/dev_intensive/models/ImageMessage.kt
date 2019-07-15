package com.skillbranch.dev_intensive.models

import com.skillbranch.dev_intensive.extensions.doFormat
import com.skillbranch.dev_intensive.extensions.humanizeDiff
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