package com.company

data class BadHorse (val listOfPair: List<String>)
 fun BadHorse.printPairs(){
     for(pair in listOfPair){
         println(pair)
     }
 }

     fun BadHorse.case(): String {
        val sizeOfPairs = listOfPair.size
        if (sizeOfPairs == 1) {
            return "yes"
        }
        val group1= HashSet<String>()
        val group2= HashSet<String>()

        for (pair in listOfPair) {
            val troubleSomeOne=pair.split(" ")[0]
            val troubleSomeTwo=pair.split(" ")[1]
            if((group1.contains(troubleSomeOne)||group1.contains(troubleSomeTwo))||(group2.contains(troubleSomeOne)||group2.contains(troubleSomeTwo)))
                return "No"
            group1.add(troubleSomeOne)
            group2.add(troubleSomeTwo)
        }
        return "yes"

    }
