fun fib(n: Int) : Array<Int?>{
    val array = arrayOfNulls<Int>(n)
    array[0] = 1
    array[1] = 1

    for(i in 2 until n) {
        val a = array[i - array[i-1]!!]
        val b = array[i - array[i-2]!!]
        array[i] = a!! + b!!
    }

    return array
}

fun lengthSupUK(n:Int, k:Int):Long {
    var count = 0L
    val array = fib(n)

    for(i in array.indices) {
        if(array[i]!! >= k){
            count++
        }
    }

    return count
}

fun comp(n:Int):Long {
    var count = 0L
    val array = fib(n)

    for(i in 1 until array.size) {
        if(array[i]!! < array[i-1]!!){
            count++
        }
    }
    return count
}


fun main() {
    val n = 23
    val k = 12

    println(lengthSupUK(n, k))
    println(comp(n))
}