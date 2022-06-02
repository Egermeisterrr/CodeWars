import EqualSidesOfAnArray.findEvenIndex

object EqualSidesOfAnArray {
    fun findEvenIndex(arr: IntArray): Int {
        if (arr.sum() - arr[0] == 0){
            return 0
        }

        for (i in 1 until arr.size) {
                var sum1 = 0
                var sum2 = 0

                for (j in 0 until i){
                    sum1 += arr[j]
                }

                for (j in i until arr.size - 1){
                    sum2 += arr[j + 1]
                }

                if (sum1 == sum2) {
                    return i
                }
        }
        return -1
    }
}

fun main() {
    println(findEvenIndex(intArrayOf(20,10,-80,10,10,15,35)))
    println(findEvenIndex(intArrayOf(1, 100, 50, -51, 1, 1)))
    println(findEvenIndex(intArrayOf(1, 2, 3, 4, 5, 6)))
    println(findEvenIndex(intArrayOf(20, 10, 30, 10, 10, 15, 35)))
    println(findEvenIndex(intArrayOf(-8505, -5130, 1926, -9026)))
    println((intArrayOf(2824, 1774, -1490, -9084, -9696, 23094)))
    println(findEvenIndex(intArrayOf(4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4)))
}