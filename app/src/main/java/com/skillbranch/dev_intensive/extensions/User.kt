package com.skillbranch.dev_intensive.extensions

import com.skillbranch.dev_intensive.models.User
import com.skillbranch.dev_intensive.models.UserView
import com.skillbranch.dev_intensive.utils.Utils

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
