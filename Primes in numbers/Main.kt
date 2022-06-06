package solution

import solution.PrimeDecomp.factors

object PrimeDecomp {
    fun factors(l: Int): String {
        var buf = l
        var del = 2
        var answer = ""
        var count = 0
        var map: Map<Int, Int> = mutableMapOf()

        while (buf != 1) {
            if (buf % del != 0) {
                del++
                count = 0
            }
            else {
                buf /= del
                count++
                map += del to count
            }
        }

        for ((key, value) in map) {
            answer += if (value != 1) {
                "($key**$value)"
            }
            else {
                "($key)"
            }
        }

        return answer
    }
}

fun main() {
    println(factors(1024))
    println(factors(7775460))
}