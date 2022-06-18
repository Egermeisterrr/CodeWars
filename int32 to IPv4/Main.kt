fun longToIP(ip: UInt): String {
    var binary = Integer.toBinaryString(ip.toInt())

    if (binary.length < 32) {
        binary = "0".repeat(32 - binary.length) + binary
    }

    var res = ""

    res += Integer.parseInt(binary.substring(0, 8), 2)
    res += "."

    res += Integer.parseInt(binary.substring(8, 16), 2)
    res += "."

    res += Integer.parseInt(binary.substring(16, 24), 2)
    res += "."

    res += Integer.parseInt(binary.substring(24, 32), 2)

    return res
}

fun main() {
    println(longToIP(2154959208u))
}
