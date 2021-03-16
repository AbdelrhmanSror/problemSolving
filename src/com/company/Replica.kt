package com.company


fun main() {
    checkMagazine(arrayOf("i", "wish", "i", "achieve", "my", "dream"), arrayOf("i", "wish", "my", "dream"))
}

// Complete the checkMagazine function below.
fun checkMagazine(magazine: Array<String>, note: Array<String>): Unit {
    val magazineNote = HashMap<String, Int?>()
    magazine.forEach {
        if (magazineNote.containsKey(it)) {
            magazineNote[it] = magazineNote[it]?.plus(1)
        } else {
            magazineNote[it] = 1
        }
    }
    note.forEach {
        if (!magazineNote.contains(it)) {
            print("No")
            return
        } else {
            if (magazineNote[it]!! == 1) {
                magazineNote.remove(it)
            } else {
                magazineNote[it] = magazineNote[it]?.minus(1)
            }
        }


    }
    print("Yes")


}
