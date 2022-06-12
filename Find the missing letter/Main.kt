fun findMissingLetter(array: CharArray): Char {
    var abc = "abcdefghijklmnopqrstuvwxyz"

    abc += abc.toUpperCase()

    val i0 = abc.indexOf(array[0])

    for (i in array.indices) {
        if (abc[i0 + i] != array[i]) {
            return (array[i] - 1)
        }
    }

    return ' '
}

fun main() {
   println(findMissingLetter(charArrayOf('a', 'b', 'c', 'd', 'f')))
   println(findMissingLetter(charArrayOf('O', 'Q', 'R', 'S')))
}