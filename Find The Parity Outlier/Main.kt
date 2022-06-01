fun find(integers: Array<Int>): Int {
    for (i in 0 until integers.size - 1) {
        if (i != integers.size - 2) {
            if (integers[i] % 2 == 0 && integers[i + 1] % 2 != 0) {
                return if (integers[i + 2] % 2 != 0) {
                    integers[i]
                }
                else {
                    integers[i + 1]
                }
            }
            if (integers[i] % 2 != 0 && integers[i + 1] % 2 == 0) {
                return if (integers[i + 2] % 2 == 0) {
                    integers[i]
                }
                else {
                    integers[i + 1]
                }
            }
        }
        else {
            if (integers[i] % 2 == 0 && integers[i + 1] % 2 != 0) {
                return if (integers[i - 1] % 2 != 0) {
                    integers[i]
                }
                else {
                    integers[i + 1]
                }
            }
            if (integers[i] % 2 != 0 && integers[i + 1] % 2 == 0) {
                return if (integers[i - 1] % 2 == 0) {
                    integers[i]
                }
                else {
                    integers[i + 1]
                }
            }
        }
    }
    return 0
}

fun main() {
    val exampleTest1 = arrayOf(2, 6, 8, -10, 3)
    val exampleTest2 = arrayOf(206847684, 1056521, 7, 17, 1901, 21104421, 7, 1, 35521, 1, 7781)
    val exampleTest3 = arrayOf(Integer.MAX_VALUE, 0, 1)

    println(find(exampleTest1))
    println(find(exampleTest2))
    println(find(exampleTest3))
}