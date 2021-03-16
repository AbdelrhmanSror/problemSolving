package com.company

fun main() {
    print(abbreviation("bbbbbbbbbbbbbbbbbbbbbbobbBbbbobbbbbbtbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbtbbbotbbbbbbbbbbbbbbbbbbbbbbBbbbbbbbbbbbbbbbbbbbbbbbbobbbbbbbbbbbbbbbbbbtbbbbbbbbBbbbbbbbbbbbbbbbtbtbbbbbbBbbbbbbbbbbbobbbbbbbbbbbbbbbbbbobbbbbbbbbbobbbBbbbbbbbbbbtbbbbbbbbbbbtbbbbbbbobbbbbbbbbbbbobbbbbbbobbbbbbbbbbbbbbbbtbbbbbbbbbbbbbbbbbbBbbbbbbbbbobbbBbbtbbbbbbbbbbboBobbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbobbtbbbtbbbbbbbbbbbbbbbobbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbBtbbbbbbbbbbbbbbbbbbbbbbbtbbbbbbbbbbbbbbbbbbbbbbbbbbbtbbbbbbtbbbbcbbbbbbbbtbbbbbbbbbbbbbbbbobbbbbbbbbbbbbbbbbbbbbbbbBbbbbbbbbbbbbbbbbbbbbbbbbobbBbbbbbbbbbbbbbbbobbbbbbbbbbbbobbbbbbbbbBbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbobbbbbbbbbbbbbbbbbbbbbbBbbbbBbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbobbbbbbbbBbbbbbbbbbbbBbbBbbbbbbbbbbbbbbbbbbbbbbbbtbbbbbbbbbbbbbbbbbbbbbbbtbbbobbbbbbbbbbbbbbbbbbbtbbbbbbbbbbbbbbbbtbobBbbbbbbbbbbbBoobbbbbbbbbbbbbbbbbbbobbbbbbbobbbbbbbbobobbbtbbBbtbbbbtbbbbbbbbbbbbbbbbbbbbbtbbbobbtbbbbbb"
            , "BBBBBBBBBBBBBBBBBBBBOBBBBOBBBBBBTBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBTBBBOBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBTBBBBBBBBBBBBBBBBBTBBBBBBBBBBBBBBOBBBBBBBBBBBBBOBBBBBBBBOBBBBBBBBBBBBBBBBBBBBTBBBBBBOBBBBBBBOBBOBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBTBBBBBBBBBOOBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBOBBTBBBTBBBBBBBBBBBBOBBBBBBBBBBBBBBBBBBBBBBBBBBBTBBBBBBBBBBBBBBBBBBTBBBBBBBBBBBBBBBBBBBBTBBBBTBBBBBBBBBBTBBBBBBBBBBBBBOBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBOBBBBBBBBBBBBBBBBBBBBBBBBBOBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBOBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBOBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBTBBBBBBBBBBBBBBBBBBBBTBBBOBBBBBBBBBBBBBTBBBBBBBBBBBBBBBTOBBBBBBBOBBBBBBBBBBBBBBBBOBBBBBBOBBBBBOBBTBBBBBBBBBBBBBBBBBBBBBBTBBBBBTBBBBB"))
}



// Complete the abbreviation function below.
fun abbreviation(a: String, b: String): String {
    //when both string are equal in size so no need for recursion
    //if we hit invalid case we know that it is impossible to make a equal to b
    when {
        a.length == b.length -> {
            for (i in a.indices) {
                if (a[i] != b[i] && a[i].toUpperCase() != b[i]) {
                    return "NO"
                }
            }
            return "YES"
        }
        //if a length is less than b length so no way of converting a to b
        a.length < b.length -> {
            return "NO"
        }
        else -> {
            return abbreviationRecursion(a, b)

        }
    }
}

fun String.isAllLowerCase(from: Int): Boolean {
    for (i in from until this.length) {
        if (this[i].isUpperCase()) {
            return false
        }
    }
    return true
}

fun abbreviationRecursion(a: String, b: String, i: Int = 0, j: Int = 0, isCapitalized: Boolean = false, stringMapAnswer: HashMap<String, String> = HashMap()): String {
    var p1 = i
    var p2 = j
    var isEqual: Boolean = false
    // println("$i  $j  $stringMapAnswer")
    when {
        p1 >= a.length && p2 >= b.length -> {
            return "YES"
        }
        p1 < a.length && p2 >= b.length -> {
            return if (a.isAllLowerCase(p1)) {
                "YES"
            } else {
                "NO"
            }

        }
        (a.length - p1) < (b.length - p2) || a[p1].isUpperCase() && a[p1] != b[p2] || isCapitalized && a[p1].toUpperCase() != b[p2] -> {
            return "NO"
        }
        a[p1] == b[p2] || (isCapitalized && a[p1].toUpperCase() == b[p2]) -> {
            isEqual = true
        }
    }
    //capitalize
    var answer: String
    //remove
    if (isEqual) {
        p1++
        p2++
    }
    if (stringMapAnswer.containsKey("${if (!isEqual) p1 + 1 else p1}$$p2")) {
        answer = stringMapAnswer["${if (!isEqual) p1 + 1 else p1}$$p2"]!!
    } else {
        answer = abbreviationRecursion(a, b, if (!isEqual) p1 + 1 else p1, p2, false, stringMapAnswer)
        stringMapAnswer["${if (!isEqual) p1 + 1 else p1}$$p2"] = answer
    }
    if (answer == "YES") return answer
    if (stringMapAnswer.containsKey("$p1$$p2"))
        answer = stringMapAnswer["$p1$$p2"]!!
    else {
        answer = abbreviationRecursion(a, b, p1, p2, true, stringMapAnswer)
        stringMapAnswer["$p1$$p2"] = answer
    }
    return answer
}
