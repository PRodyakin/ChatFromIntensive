package com.skillbranch.dev_intensive.models

import com.skillbranch.dev_intensive.utils.Utils
import java.util.*

data class User (
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    var lastVisit: Date? = null,
    val isOnline: Boolean = false,
    val id: String
) {

    constructor(id: String, firstName: String?, lastName: String?): this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )
    constructor(id: String) : this(id, firstName = "John", lastName = "Doe $id")

    init {
        println("I am life $id");
    }

    fun printMe(): Unit = println("""
        firstName: $firstName
        lastName: $lastName
        avatar: $avatar
        rating: $rating
        respect: $respect
        lastVisit: $lastVisit
        isOnline: $isOnline
        id: $id
        """.trimIndent());

    companion object Factory{
        private var lastId = 1


        fun makeUser(fullName:String?):User{
            lastId++
            val (firstName, lastName) = Utils.parseFullName(fullName)


            return User(id="$lastId", firstName = firstName,lastName = lastName)
        }
    }

}
