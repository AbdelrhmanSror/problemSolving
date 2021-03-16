package com.company

fun main(){
   // print(superDigit(x,100000))
}

// Complete the superDigit function below.
fun superDigit(n: String, k: Int): Int {
     val result=superDigit3(n.toCharArray())*k
    print(result)
    return if(result<10){
        result
    } else{
        superDigit2(result.toString())
    }

}

// Complete the superDigit function below.
fun superDigit2(n: String): Int {
    if(n.length==1){
        return n[0].toRealInt()
    }
    val result=superDigit3(n.toCharArray())
    return superDigit2(result.toString())
}


fun superDigit3(n: CharArray, start: Int=0, end: Int=n.size-1): Int {
    val middle = (start + end) / 2
    if (end <= start) {
        return n[start].toRealInt()
    }
    return superDigit3(n, start, middle) + superDigit3(n, middle + 1, end)

}
/*
fun Char.toRealInt(): Int {
    return this.toInt() - 48
}*/


