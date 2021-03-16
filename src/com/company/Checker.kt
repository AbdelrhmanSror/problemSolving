package com.company

import java.util.*
import kotlin.Comparator

fun main(){
    val checker=Checker()
    val array=Array<Player>(2){
        when(it){
            0->Player("abdelhman",100)
            else-> Player("sara",100)

        }
    }

    Arrays.sort(array,checker)
    array.forEach {
        println(it)
    }

}
data class Player(val name:String, val score:Int)
class Checker:Comparator<Player> {
    override fun compare(o1: Player, o2: Player): Int {
        return when {
            o1.score<o2.score -> 1
            o1.score>o2.score -> -1
            else -> o1.name.compareTo(o2.name)

        }
    }

}