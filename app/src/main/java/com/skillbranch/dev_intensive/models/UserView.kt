package com.skillbranch.devintensive.models

class UserView(
    val id:String,
    val fullname:String,
    val nickName:String,
    val avatar:String? = null,
    val status:String? = "offline",
    val initials:String? = null
)
{

    fun printMe(){
        println("""
        id: $id
        fullname: $fullname
        nickName: $nickName
        avatar: $avatar
        status: $status
        initials: $initials
        """.trimIndent())
    }

}