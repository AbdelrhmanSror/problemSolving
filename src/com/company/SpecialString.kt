package com.company

import java.util.*


fun main() {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val result = substrCount(5, s)
    val result2 = substrCount2(5, s)
    println(result)
    println(result2)

}

data class Point(var key: Char, var count: Long)

// Complete the substrCount function below.
fun substrCount2(n: Int, s: String): Long {
    var s = s
    s = "$s "
    val l = ArrayList<Point>()
    var count: Long = 1
    var ch = s[0]
    for (i in 1 until s.length) {
        if (ch == s[i]) count++ else {
            l.add(Point(ch, count))
            count = 1
            ch = s[i]
        }
    }
    count = 0
    if (l.size >= 3) {
        val itr: Iterator<Point> = l.iterator()
        var prev: Point
        var curr: Point
        var next: Point
        curr = itr.next()
        next = itr.next()
        count = curr.count * (curr.count + 1) / 2
        for (i in 1 until l.size - 1) {
            prev = curr
            curr = next
            next = itr.next()
            count += curr.count * (curr.count + 1) / 2
            if (prev.key == next.key && curr.count == 1L) count += if (prev.count > next.count) next.count else prev.count
        }
        count += next.count * (next.count + 1) / 2
    } else {
        for (curr in l) {
            count += curr.count * (curr.count + 1) / 2
        }
    }
    return count
}


data class SpecialString(var char: Char, var number: Long, var isFinished: Boolean = false)

// Complete the substrCount function below.
fun substrCount(n: Int, s: String): Long {
    var conscutiveStringCounter = 0L
    var normalCounter = 0L
    var indexCounter = 1L
    var x: SpecialString? = null
    for (i in s.indices) {
        when {
            (i + 1) < s.length && s[i] == s[i + 1] -> {
                conscutiveStringCounter += indexCounter
                println("normalCounter  $normalCounter $indexCounter  $conscutiveStringCounter ${s[i]}  $i")
                indexCounter++
                if (x == null || s[i] != x.char) {
                    x = SpecialString(s[i], indexCounter)
                } else if (s[i] == x.char) {
                    if (!x.isFinished) {
                        x.number = indexCounter
                    } else {
                        if (indexCounter <= x.number) {
                            if (indexCounter == x.number)
                                x.isFinished = false
                            conscutiveStringCounter += 1
                        } else {
                            x = SpecialString(s[i], indexCounter)

                        }
                    }
                }

            }
            (i + 2) < s.length && s[i] == s[i + 2] -> {
                normalCounter += conscutiveStringCounter + 1
                println("normalCounter  $normalCounter $indexCounter  $conscutiveStringCounter ${s[i]}  $i")
                conscutiveStringCounter = 0L
                indexCounter = 1L
                x?.let {
                    if (it.isFinished)
                        x = null
                    else {
                        it.isFinished = true
                    }

                }

            }
            else -> {
                normalCounter += conscutiveStringCounter
                println("normalCounter  $normalCounter $indexCounter  $conscutiveStringCounter ${s[i]}  $i")
                conscutiveStringCounter = 0L
                indexCounter = 1L
                if (x != null &&((i+2)<s.length&&x!!.char!=s[i+2])) x = null


            }
        }
    }
    normalCounter += conscutiveStringCounter + s.length
    println("normalCounter  $normalCounter $indexCounter  $conscutiveStringCounter ${s.length} ")

    return normalCounter


}