package com.company

import kotlin.math.round

/**
 * Gary is an avid hiker. He tracks his hikes meticulously, paying close attention to small details like topography.
 * During his last hike he took exactly  steps. For every step he took, he noted if it was an uphill, , or a downhill,
 * step. Gary's hikes start and end at sea level and each step up or down represents a  unit change in altitude.
 * We define the following terms:
 * A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea level and ending with a step down to sea level.
 * A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to sea level.
 * Given Gary's sequence of up and down steps during his last hike, find and print the number of valleys he walked through.
 * For example, if Gary's path is , he first enters a valley  units deep. Then he climbs out an up onto a mountain  units high.
 * Finally, he returns to sea level and ends his hike.
 * Function Description
 * Complete the countingValleys function in the editor below.
 * It must return an integer that denotes the number of valleys Gary traversed.
 * countingValleys has the following parameter(s):
 * s: a string describing his path
 */
// Complete the countingValleys function below.
fun countingValleys(s: String = "UDDDUDUU"): Int {
    var up = 0
    var down = 0
    var valley = 0
    for (i in s.indices) {
        /**
         * if up and down ==0 then we are on sea level
         * my rule is above see level we will increment the up value and decrement the down value
         * below sea level will increment the down value and decrement the up value
         */
        if (up == 0 && down == 0) {
            if (s[i] == 'U') {
                up++
                down--
            } else if (s[i] == 'D') {
                down++
                up--
            }
        } else if (s[i] == 'D') {
            //if down and we were above sea level then we decrement the value of down
            //otherwise we are below sea level so we increment the value of down
            if (up > 0) down--
            else down++
        } else if (s[i] == 'U') {
            //if up and we were below sea level then we decrement the value of up
            //otherwise we above sea level so we increment the value of up
            if (down > 0) up--
            else up++
        }
        //if the difference between the up and down when we where above sea level==-1
        //then we have returned to sea level so initialize every thing with 0
        if (up - kotlin.math.abs(down) == -1 && up >= 0) {
            up = 0
            down = 0

        }
        //if the difference between the down and up when we where below sea level==-1
        //then we have returned to sea level so initialize every thing with 0 and increment valley with 1
        else if (down - kotlin.math.abs(up) == -1 && down >= 0) {
            valley++
            up = 0
            down = 0
        }

    }
    return valley
}
