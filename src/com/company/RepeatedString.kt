package com.company



// Complete the repeatedString function below.
fun repeatedString(s: String, n: Long): Long {

    val noRepeatedstring: Long = n / s.length
    val noCharReminderString: Int = n.rem(s.length).toInt()
    var counter = 0L
    var rem_counter = 0
    return if (n >= s.length) {
        for (i in s.indices) {
            if (s[i] == 'a') {
                counter++
                if (i < noCharReminderString) rem_counter++
            }
        }
        counter * noRepeatedstring + rem_counter
    } else  {
        for (i in 0..noCharReminderString) {
            if (s[i] == 'a') counter++
        }
        counter
    }


}
