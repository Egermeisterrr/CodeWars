fun rangeExtraction(arr: Array<Int>): String {
    val ls: MutableList<String> = ArrayList()
    var consecutiveCounter = 0
    var i = 0

    while (i < arr.size) {
        consecutiveCounter = 0
        var start = arr[i].toString()

        while (i != arr.size - 1 && arr[i + 1] - arr[i] == 1) {
            consecutiveCounter++
            i++
        }

        if (consecutiveCounter > 0) {
            if (consecutiveCounter > 1) {
                start += "-" + (start.toInt() + consecutiveCounter)
            }
            else {
                i--
            }
        }

        ls.add(start)
        i++
    }

    return java.lang.String.join(",", ls)
}

fun main() {
    val arr1 = arrayOf(-10, -9, -8, -6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20)
    val arr2 = arrayOf(-3, -2, -1, 2, 10, 15, 16, 18, 19, 20)

    println(rangeExtraction(arr1))
    println(rangeExtraction(arr2))
}