package solution

import solution.SumSquaredDivisors.listSquared

object SumSquaredDivisors {

    fun listSquared(m: Long, n: Long): String {
        val result = mutableListOf<String>()

        for (i in m..n) {
            val list = getDivisions(i)
            var sum = 0L

            for (j in 0 until list.size) {
                sum += (list[j] * list[j])
            }

            val a = kotlin.math.sqrt(sum.toDouble())

            if (a.toInt().toDouble() == a) {
                result.add("[$i, $sum]")
            }
        }

        return result.toString()
    }

    private fun getDivisions(number: Long): MutableList<Long> {
        val result = mutableListOf<Long>()
        result.add(1)

        for (i in 2..kotlin.math.sqrt(number.toDouble()).toLong()) {
            if (number % i == 0L) {
                result.add(i)
                if (number / i != i) {
                    result.add(number / i)
                }
            }
        }

        if (number != 1L) {
            result.add(number)
        }

        result.sort()
        return result
    }
}

fun main() {
    println(listSquared(2, 2))
    println(listSquared(1, 250))
}