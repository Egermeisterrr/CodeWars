import java.lang.Integer.max

fun lcs(a: String, b: String): String {
    val m = a.length
    val n = b.length

    return lcs(a, b, m, n)
}

fun lcs(x: String, y: String, m: Int, n: Int): String {
    val l = Array(m + 1) { IntArray(n + 1) }

    for (i in 0..m) {
        for (j in 0..n) {
            if (i == 0 || j == 0){
                l[i][j] = 0
            }
            else if (x[i - 1] == y[j - 1]) {
                l[i][j] = l[i - 1][j - 1] + 1
            }
            else {
                l[i][j] = max(l[i - 1][j], l[i][j - 1])
            }
        }
    }

    var index = l[m][n]
    val temp = index
    val lcs = CharArray(index + 1)
    lcs[index] = '\u0000'

    var i = m
    var j = n

    while (i > 0 && j > 0) {
        if (x[i - 1] == y[j - 1]) {
            lcs[index - 1] = x[i - 1]
            i--
            j--
            index--
        }
        else if (l[i - 1][j] > l[i][j - 1]) {
            i--
        }
        else {
            j--
        }
    }

    return getString(temp, lcs)
}

private fun getString(temp: Int, lcs: CharArray): String {
    val sb = StringBuilder()

    for (k in 0..temp) {
        sb.append(lcs[k])
    }

    return sb.deleteCharAt(temp).toString()
}

fun main() {
    println(lcs("a", "b"))
    println(lcs("a", "a"))
    println(lcs("abc", "ac"))
    println(lcs("abcdef", "abc"))
    println(lcs("abcdef", "acf"))
    println(lcs("anothertest", "notatest"))
    println(lcs("132535365", "123456789"))
    println(lcs("nothardlythefinaltest", "zzzfinallyzzz"))
    println(lcs("abcdefghijklmnopq", "apcdefghijklmnobq"))
}