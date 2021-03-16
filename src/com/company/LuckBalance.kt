package com.company


fun main(){
    print(luckBalance(3,
            arrayOf(arrayOf(5,1)
                    , arrayOf(2,1)
                    , arrayOf(1,1), arrayOf(8,1), arrayOf(10,0), arrayOf(5,0))))
}
object LuckBalanceComparator:Comparator<Array<Int>>{
    override fun compare(o1: Array<Int>, o2: Array<Int>): Int {
        return o1[0].compareTo(o2[0])
    }
}


// Complete the luckBalance function below.
fun luckBalance(k: Int, contests: Array<Array<Int>>): Int {
    contests.sortWith(LuckBalanceComparator)
    var counterOfValuableContests=0
    var luckBalance=0
    for (i in contests){
        if(i[1]==1){
            counterOfValuableContests++
        }
    }
    var reminder=counterOfValuableContests-k
    for (i in contests){
       if(reminder>0){
           if(i[1]==1){
               luckBalance-=i[0]
               reminder--
           }else{
               luckBalance+=i[0]
           }
       }else{
           luckBalance+=i[0]
       }
    }
    return luckBalance


}
