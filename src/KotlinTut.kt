package KotlinTut

import java.util.*

fun main(args: Array<String>){
    println("Hello Belema!")

    val myList = listOf("a", "b", "c")
    var name  = "Belema"
    val myAge = 22

    val bigInt = Int.MAX_VALUE
    val smallInt = Int.MIN_VALUE

    println("Biggest int: $bigInt")
    println("Smallest int: $smallInt")

    if (name is String && myAge is Int){
        println("$name is a String and $myAge is an Int")
    }

    name += " means Love"
    println(name)

    val letterGrade = 'A'
    println("letterGrade is a char: ${letterGrade is Char}")

    //casting
    println("3.14 to Int: ${3.14.toInt()}")

    println("x to Int is: ${xToInt(myList[2])}")
    println("A to Int: ${'A'.toInt()}")
    println("C to Int: ${'C'.toInt()}")
    println("67 to Char: ${67.toChar()}")

    //strings
    val myFullName = """Tamunobelema Miebaka-Ogan"""

    println("my name length: ${myFullName.length}")
    println(myFullName.equals(name))
    println(myFullName.compareTo(name))
    println(myFullName.subSequence(0,12)) //goes up to index 12 but doesn't include it in result
    println(myFullName.contains("Ogan"))

    //arrays
    val myArray = arrayOf(1, 2.34, "kotlin is awesome")
    println(myArray[2])
    myArray[2] = 3.14
    println("Array size is ${myArray.size}")
    println("contains kotlin: ${myArray.contains("kotlin")}")
    println("contains kotlin is awesome: ${myArray.contains("kotlin is awesome")}")
    var partArray = myArray.copyOfRange(1,2)
    println(partArray.first())
    println("index: ${myArray.indexOf("kotlin is awesome")}")

    var sqrArray = Array(5, {i -> i * i })
    for (x in sqrArray){
        println(x)
    }
    val intArray = intArrayOf(1,2,3)

    val anotherArray = intArray.clone() //makes a copy of the array
    val arrayCopy = intArray.copyOf() //a library function that makes a copy of the array
    println(anotherArray[1])
    println(arrayCopy[1])
    println(intArray.reversedArray()[0]) //prints out reversed array


    //ranges
    val oneToTen = 1..10
    val aToZ = "A".."Z"
    println("is S in aToZ: ${"S" in aToZ}")
    println("is 5 in $oneToTen: ${5 in oneToTen}")

    val tenToOne = 10.downTo(1)
    val twoTo20 = 2.rangeTo(20)
    val rng3 = oneToTen.step(3) //stepping through the range adding 3
    for(x in rng3) println(x)
    for(x in tenToOne.reversed()) println("Reversed: $x")

    //conditionals
    val age = 7
    when(age){
        0,1,2 -> println("Go to creche")
        in 3..6 -> println("Go to nursery school")
        in 7..11 -> println("Go to primary school")
        in 12..30 -> println("Higher education")
        else -> println("Keep learning")
    }

    //looping
    val rand = Random()
    val magicNumber = rand.nextInt(50) + 1 //to get random numbers from 1 t0 30
    var guess = 0
    while (magicNumber != guess){
        guess +=1
    }

    println("Magic number was $guess")

    for(x in 1..20){
        if (x % 2 == 0){
            continue
        }
        println("Odd number: $x")
        if (x == 15) break
    }

    val arr3 : Array<Int> = arrayOf(3,6,9)
    for (i in arr3.indices) println("Multiples of 3: ${arr3[i]}")

    for ((index, value) in arr3.withIndex()) {
        println("Index: $index Value: $value") //printing out index and value
    }

    //functions
    fun add(num1: Int, num2: Int) = num1 + num2 //no return type needed in single line functions
    println("sum of 10 and 5 is ${add(10,5)}")

    fun subtract(num1: Int = 5, num2: Int = 2) = num1 - num2 //here the function parameters have default values
    println("difference between 10 and 2 is ${subtract(10)}")

    println("20 - 6 = ${subtract(num2 = 6, num1 = 20)}") //using named parameter

    val (two, three) = nextTwo(1)
    println("1, $two and $three") //testing our function that returns two values

    //using our vararg parameter method
    println("Sum of 1 to 5: ${getSum(1,2,3,4,5)}")

    //function literals
    val multiply = {num1: Int, num2: Int -> num1 * num2}
    println("10 * 2 = ${multiply(10,2)}")

    //factorial
    println("factorial of 5: ${fact(5)}")


    //high order functions are functions that accept or return another function
//if a function has only one parameter you don't have to declare it, just use it instead

    //here is the long route of doing this, we can create high order function to handle this
    val numList = 1..20
    val evenList = numList.filter { it % 2 == 0 }
    evenList.forEach { n -> println(n) }

    //using our high order function
    val multiplyBy3 = makeMathFun(3)
    println("5 * 3 = ${multiplyBy3(5)}")

    //using my second high order function
    val multiply2 = {num1: Int -> num1 * 2}
    val numList2 = arrayOf(1,2,3,4,5)
    mathOnList(numList2, multiply2)

    //operations on collections
    val numList3 = 1..20
    val listSum = numList3.reduce{x, y -> x + y}
    println("Reduce sum: $listSum")
    val listSum2 = numList3.fold(5){ x, y -> x + y} //fold requires an initial value
    println("Fold sum: $listSum2") //to get same result as reduce we can pass 0 as initial value

    //checking if values meet a condition
    println("Evens: ${numList3.any { it % 2 == 0 }}")
    println("Evens: ${numList3.all { it % 2 == 0 }}") //all of them have to be even to come back as true

    //getting list of values that meet a condition
    val big10 = numList3.filter { it > 10 }
    big10.forEach { println(it) }

    val times7 = numList3.map { it * 7 }
    times7.forEach { println("numList3 items * 7: $it") }

    //using exceptions
    val divisor = 2

    try {
        if (divisor == 0){
            throw IllegalArgumentException("Can't divide by zero")
        } else {
            println("5 / divisor = ${5/divisor}")
        }
    } catch (e: IllegalThreadStateException){
        println("${e.message}")
    }

    //immutable and mutable list
    var list1: MutableList<Int> = mutableListOf(1,2,3,4,5)
    val list2: List<Int> = listOf(1,2,3)

    //to add to list
    list1.add(6)
    //to get first item in list
    println("first item: ${list2.first()}")
    //to get last item in list
    println("last item: ${list1.last()}")
    println("2nd index: ${list1[1]}")
    //creating sublist of a list
    val subListOfList1 = list1.subList(3,5)
    subListOfList1.clear()
    list1.removeAt(2) //using index
    list1.remove(6) //using element
    list1[0] = 15 //adding at particular index
    list1.forEach { println(it) }

    //creating maps
    val map = mutableMapOf<Int, Any?>()

    val map2 = mutableMapOf(1 to "Belema", 2 to "Tonye", 3 to "Ibi", 4 to "Tokoni")

    //adding to map
    map[1] = "Belema"
    map[2] = "Tonye"
    map[3] = "Ibi"
    map[4] = "Tokoni"

    println("Map size: ${map2.size}")

    map.put(5, "Sweet Mama")

    //removing
    map2.remove(3)

    for ((x, y) in map) println("Key is $x and Value is $y")


    //dealing with classes
    val dog = Animal("Lollipop", 20.0, 13.5)
    dog.getInfo()

    //child class of Animal
    val lola = Dog("Lollipop", 20.5, 14.2, "Belema")
    lola.getInfo()

    //testing our interface
    val tweety = Bird("Tweety", true)
    tweety.fly(12.5)

    val parrot = Bird("Tibby", false)
    parrot.fly(15.0)

    //null safety
    //by default you can't assign null value
    //to allow a null value to be assigned
    var nullValue: String? = null

    //for a function that returns null
    fun returnNullValue(): String?{
        return null
    }

    val nullVal2 = returnNullValue()

    //since the if statement is there we can perform this function
    if (nullVal2 != null){
        println(nullVal2.length)
    }

    //you can also use force operator to work  with null values
   //do val nullVal3 = nullVal2!!.length

    //you can also use the elvis operator to provide a default value is a variable is null
    var nullVal4 = returnNullValue() ?: "No value"
    println("nullVal4 is $nullVal4")
}


fun xToInt(x: String) : Int? {

    return when (x) {
            "a" ->  1
            "b" ->  2
            "c" ->  3
            else ->  throw IllegalArgumentException("Invalid argument")
    }

}

//function that returns two values
fun nextTwo(num: Int): Pair<Int, Int>{
    return Pair(num + 1, num + 2)
}

//vararg
fun getSum(vararg numbers: Int): Int{
    var sum = 0
    numbers.forEach { n -> sum += n}
    return sum
}

//factorial
fun fact(x: Int): Int{
    tailrec fun factTail(y: Int, z: Int): Int{
        if (y == 0) return z
        else return factTail(y - 1, y * z)
    }
    return factTail(x, 1)
}

//high order functions are functions that accept or return another function
//creating high order function
//(Int) represents the input parameter of the second function that will be returned
//(Int) "-> Int" means Int is the return type of the function
fun makeMathFun(num1: Int): (Int) -> Int = {num2 -> num1 * num2}

//another high order function
fun mathOnList(numList: Array<Int>, myFunc: (num: Int) -> Int){
    for (num in numList){
        println("mathOnList = ${myFunc(num)}")
    }
}

open class Animal(val name: String,
                  var height: Double,
                  var weight: Double){
    init {
        val regex = Regex(".*\\d+.*") //regular expression to check input for animal name

        require(!name.matches(regex)){"Animal name can't contain numbers"} //throws illegal argument expression

        require(height > 0){"Height must be greater than zero"}

        require(weight > 0){"Weight must be greater than zero"}

    }

    //if you want your method to be overidable you have to make it open
    open fun getInfo(){
        println("Animal name is $name, height is $height and weight is $weight")
    }
}

//learning inheritance
class Dog(name: String,
        height: Double,
        weight: Double,
        var owner: String): Animal(name,height, weight){

    override fun getInfo() {
        println("Dog name is $name, height is $height, weight is $weight and is owned by $owner")
    }

}

//interface
interface Flyable{
    var flies: Boolean
    fun fly(distanceFlown: Double)
}

//class that implements our interface and has a primary constructor
class Bird constructor(val name: String,
                       override var flies: Boolean = true) : Flyable{
    override fun fly(distanceFlown: Double) {
        if (flies){
            println("$name flies $distanceFlown miles")
        } else{
            println("$name can't fly")
        }
    }
}