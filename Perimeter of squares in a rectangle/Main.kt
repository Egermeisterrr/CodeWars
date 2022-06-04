package solution

import solution.SumFct.perimeter
import java.math.BigInteger

object SumFct {
    fun perimeter(n: Int): BigInteger {
        var sum : BigInteger = 1.toBigInteger()
        val array = arrayOfNulls<BigInteger>(n + 2)

        array[0] = 0.toBigInteger()
        array[1] = 1.toBigInteger()

        for (i in 2 until n + 2) {
            array[i] = array[i - 1]!! + array[i - 2]!!
            sum += array[i]!!
        }

        return (4.toBigInteger() * sum)
    }
}


fun main() {
    println(perimeter(5))
    println(perimeter(7))
    println(perimeter(30))
}