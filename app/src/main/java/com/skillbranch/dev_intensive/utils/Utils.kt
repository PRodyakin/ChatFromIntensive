package com.skillbranch.devintensive.utils


object Utils {

    fun firstToUpperCase(word: String?): String? {
        return (word?.substring(0, 1)?.toUpperCase() + word?.substring(1))
    }

    fun parseFullName(fullName: String?, divider: String = " "): Pair<String?, String?> {

        var parts: List<String>? = fullName?.split(divider)

        if (parts.isNullOrEmpty() || fullName.isNullOrEmpty()) {
            return null to null
        } else if (" ".equals(fullName)) {
            return null to null
        }

        var firstName: String? = parts?.getOrNull(0)
        //var lastName = parts?.getOrNull(1);
        parts = parts?.drop(1)
        var lastName: String? = ""
        parts?.forEach { i -> lastName += divider + if (i.isEmpty()) null else firstToUpperCase(i) } ?: null

        when {
            lastName.isNullOrEmpty() -> lastName = null
            else -> lastName = lastName?.trim()
        }

        return firstToUpperCase(firstName) to lastName

    }

    fun transliteration(payload: String, divider: String = "_", reverse: Boolean = false): String {

        val payload = payload.toLowerCase()
        val abcCyr = mapOf<String, String>(
            "а" to "a",
            "б" to "b",
            "в" to "v",
            "г" to "g",
            "д" to "d",
            "е" to "e",
            "ё" to "jo",
            "ж" to "zh",
            "з" to "z",
            "и" to "i",
            "й" to "i",
            "к" to "k",
            "л" to "l",
            "м" to "m",
            "н" to "n",
            "о" to "o",
            "п" to "p",
            "р" to "r",
            "с" to "s",
            "т" to "t",
            "у" to "u",
            "ў" to "w",
            "ф" to "f",
            "х" to "h",
            "ц" to "ts",
            "ч" to "ch",
            "ш" to "sh",
            "щ" to "sch",
            "ы" to "",
            "э" to "e",
            "ю" to "ju",
            "я" to "ja",
            " " to divider
        )

        val dynMap: Map<String, String> = if (reverse) abcCyr.entries.associateBy({ it.value }, { it.key }) else abcCyr

        var result: String = ""
        for (i: Char in payload) {
            result += dynMap[i.toString()] ?: ""


        }

        val fullNameUpperCase: Pair<String?, String?> = parseFullName(fullName = result, divider = divider)

        return fullNameUpperCase.first + divider + fullNameUpperCase.second
    }


    fun toInicials(fullName: String): String? {

        val fullNameUpperCase: Pair<String?, String?> = parseFullName(fullName = fullName, divider = " ")
        return fullNameUpperCase.first?.substring(0, 1) + fullNameUpperCase.second?.substring(0, 1)

    }


}