package com.skillbranch.devintensive


import com.skillbranch.devintensive.extensions.*
import com.skillbranch.devintensive.models.BaseMessage
import com.skillbranch.devintensive.models.Chat
import com.skillbranch.devintensive.models.TextMessage
import com.skillbranch.devintensive.models.User
import com.skillbranch.devintensive.utils.Utils
import org.junit.Test

import org.junit.Assert.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun test_instance() {
        val user = User("1");
        val user3 = User("3",lastName = "Weak",firstName = "Joe")
        val user2 = User("2", lastName = "Asdfa",firstName = "Joe")
        println("${user.printMe()} ${user2.printMe()}  ${user3.printMe()}")
    }

    @Test
    fun test_factory() {
        val user = User.makeUser("John Cena")
        val user2 = User.makeUser("John Wick")
        val user3 = User.makeUser("John List")
    }
    @Test
    fun test_decomposition() {
        val user = User.makeUser("John Cena")

        fun getUserInfo() = user


        val (id, firstname,lastName) = getUserInfo()
        print(user.lastVisit?.doFormat())

    }

    @Test
    fun test_date_humanize() {


        println(Date().add(-336,TimeUnits.DAY).humanizeDiff())
        println(Date().add(-337,TimeUnits.DAY).humanizeDiff())
        println(Date().add(-7,TimeUnits.DAY).humanizeDiff())

        println(Date().add(-3,TimeUnits.HOUR).humanizeDiff())
        println(Date().add(-2,TimeUnits.HOUR).humanizeDiff())
        println(Date().add(-1,TimeUnits.HOUR).humanizeDiff())

        println(Date().add(-3,TimeUnits.MINUTE).humanizeDiff())
        println(Date().add(-2,TimeUnits.MINUTE).humanizeDiff())
        println(Date().add(-1,TimeUnits.MINUTE).humanizeDiff())

        println(Date().add(-3,TimeUnits.SECOND).humanizeDiff())
        println(Date().add(-2,TimeUnits.SECOND).humanizeDiff())
        println(Date().add(-1,TimeUnits.SECOND).humanizeDiff())


        println(Date().add(-5,TimeUnits.DAY).humanizeDiff())
        println(Date().add(-5,TimeUnits.HOUR).humanizeDiff())
        println(Date().add(-5,TimeUnits.MINUTE).humanizeDiff())
        println(Date().add(-5,TimeUnits.SECOND).humanizeDiff())

        println(Date().add(-21,TimeUnits.DAY).humanizeDiff())
        println(Date().add(-21,TimeUnits.HOUR).humanizeDiff())
        println(Date().add(-21,TimeUnits.MINUTE).humanizeDiff())
        println(Date().add(-21,TimeUnits.SECOND).humanizeDiff())

    }

    @Test
    fun test_transliter() {

        val name:String = "Никола Тесла Петрович"


        println(Utils.transliteration(name,reverse = false, divider = " "))

    }

    @Test
    fun test_name_parser() {

        val name:String = "Никола Тесла Петрович"


        println(Utils.parseFullName("Никола Тесла Петрович"))
        println(Utils.parseFullName(null))
        println(Utils.parseFullName(""))
        println(Utils.parseFullName(" "))
        println(Utils.parseFullName("John"))

    }


    @Test
    fun test_data_mapping() {

        val user = User.makeUser("Никола Тесла Петрович")
        val userVarargs = user.toUserView();

        userVarargs.printMe()

        println()

        val user2 = user.copy(lastVisit = Date().add(-5,TimeUnits.SECOND)).toUserView()
        //println(Utils.transliteration(name,reverse = false, divider = " "))

        user2.printMe()
    }

    @Test
    fun test_abstract_factory() {

        val user = User.makeUser("Никола Тесла Петрович")
        val txtMessage = BaseMessage.makeMessage(user, Chat("0"),payload = "some text", type = "text")
        val imgMessage = BaseMessage.makeMessage(user, Chat("0"),payload = "img url", type = "image")

        println(txtMessage.formatMessage())
        println(imgMessage.formatMessage())
    }


}
