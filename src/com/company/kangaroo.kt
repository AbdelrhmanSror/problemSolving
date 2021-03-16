package com.company


// Complete the kangaroo function below.
fun kangaroo(x1: Int, v1: Int, x2: Int, v2: Int): String {
    var p1 = x1
    var p2 = x2
    if (p1 < p2 && v1 > v2) {
        while (p1 <= p2) {
            if (p1 == p2) {
                val jump1 = (p1 - x1) / v1
                val jump2 = (p2 - x2) / v2
                if (jump1 == jump2) {
                    return "YES"
                }
            }
            p1 += v1
            p2 += v2
        }
    } else if (x2 < x1 && v2 > v1) {
        while (p2 <= p1) {
            if (p1 == p2) {
                val jump1 = (p1 - x1) / v1
                val jump2 = (p2 - x2) / v2
                if (jump1 == jump2) {
                    return "YES"
                }
            }
            p1 += v1
            p2 += v2
        }

    }
    return "NO"


}
