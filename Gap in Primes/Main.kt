import java.math.BigInteger

fun Long.isPrime(): Boolean {
    val bigInt = BigInteger.valueOf(this)
    return bigInt.isProbablePrime(32)
}

fun gap(g: Int, m: Long, n: Long): LongArray {
    var isFind = false

    val x = (m..n).toList().fold(m) { acc, l ->
        if (isFind) acc else {
            return@fold if (!acc.isPrime()) l else if ((acc + g).isPrime()) {

                if ((l until acc + g).find { it.isPrime() } == null) {
                    isFind = true
                    return@fold acc
                }
                else
                    return@fold l

            }
            else l
        }
    }

    return if (x == n) longArrayOf() else longArrayOf(x, (x + g))
}

fun main() {
    println(gap(2, 100, 110))
    println(gap(4, 100, 110))
}