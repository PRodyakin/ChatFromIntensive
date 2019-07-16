package com.skillbranch.devintensive.extensions

import com.skillbranch.devintensive.models.User
import com.skillbranch.devintensive.models.UserView
import com.skillbranch.devintensive.utils.Utils

fun User.toUserView():UserView{

    val nickName = Utils.transliteration("$firstName $lastName");
    val initials = Utils.toInicials("$firstName $lastName")
    val status = if(lastVisit == null) "Ёще ни разу не был" else if(isOnline) "online" else "Последний раз был ${lastVisit?.humanizeDiff()}"

    return UserView(
        id,
        fullname = "$firstName $lastName",
        initials = initials,
        avatar = avatar,
        status = status,
        nickName = nickName)

}
