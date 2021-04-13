package com.company

fun main(){
    val array= arrayOf(1,2,3,4,5,6,7,8,9)
    array.shiftLeft(8).forEach {
        print("$it ")
    }
}
 inline fun <reified T> Array<T>.shiftLeft(d: Int) :Array<T>{
    val arrayList = arrayListOf<T>()
    for (i in d until this.size) {
        arrayList.add(this[i])
    }
    for (i in 0 until d ){
        arrayList.add(this[i])
    }
    /*for(i in this.indices) {
        this[i]=arrayList[i]
    }*/
     return arrayList.toTypedArray()
}