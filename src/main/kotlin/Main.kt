fun main(args: Array<String>) {
    var unitLambda : () -> Unit = {
        println("Kotlin apprentice is awesome!")
    }
    unitLambda()

    //TODO: Custom sorting with lambdas
    val names = arrayOf("zzzzz", "bb", "a", "eeeeee")
    val namesByLength = names.sortedWith(compareBy {
        -it.length // - for descending order
    })
    println(namesByLength)

    //TODO: Iterating over collections with lambdas
    val values = listOf(1,2,3,4,5,6)
    values.forEach {
        println("$it: ${it * it}")
    }
    val prices = listOf(1.5,10.0,4.99,2.30,8.19)
    val largerPrices = prices.filter {
        it > 5.0
    }
    println(largerPrices) //filter does not alter the original list but instead create a new one
    //using map function
    val salePrices = prices.map {
        it * 0.9
    }
    println(salePrices)

    //TODO: using map to change the type
    val userInput = listOf("0", "11", "haha", "43")
    val numbers = userInput.map {
        it.toIntOrNull()
    }
    println(numbers)
    //to filter out invalid,null,values.use mapNotNull() like so:
    val numbers2 = userInput.mapNotNull {
        it.toIntOrNull()
    }
    println(numbers2)
    //TODO: fold function
    //fold function which takes a starting value and a lambda.The lambda takes two
    //values: the current values and an element from the list.The lambda returns the next
    //value that should be passed into the lambda as the current value parameter
    var sum = prices.fold(0.0) {a, b ->
        a + b
    }
    println(sum)
    //TODO: mapOf function
    val stock = mapOf(
        1.5 to 5,
        10.0 to 2,
        4.99 to 20,
        2.30 to 5,
        8.19 to 30
    )
    var stockSum = 0.0
    stock.forEach{
        stockSum += it.key * it.value
    }
    println(stockSum)


    val counter1 = countingLambda()
}

//TODO: Capturing from the enclosing scope
fun countingLambda() : () -> Int {
    var counter = 0
    val incrementCounter: () -> Int = {
        counter += 1
        counter
    }
    return incrementCounter


}