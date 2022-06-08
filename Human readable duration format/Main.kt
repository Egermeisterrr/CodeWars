import TimeFormatter.formatDuration
import kotlin.math.floor

object TimeFormatter {
    private fun buildString(v: Int, unit: String): String {
        if (v > 0) {
            return if (v > 1) {
                "$v $unit" +  "s, "
            }
            else {
                "$v $unit, "
            }
        }
        return ""
    }

    private const val NUM_SEC_PER_MIN = 60
    private const val NUM_SEC_PER_HR = NUM_SEC_PER_MIN * 60
    private const val NUM_SEC_PER_DAY = NUM_SEC_PER_HR * 24
    private const val NUM_SEC_PER_YEAR = NUM_SEC_PER_DAY * 365

    fun formatDuration(seconds: Int): String {
        if (seconds == 0) {
            return "now"
        }

        var tmpSeconds = seconds.toDouble()

        val numYears = floor((tmpSeconds / NUM_SEC_PER_YEAR))
        tmpSeconds -= numYears * NUM_SEC_PER_YEAR

        val numDays = floor((tmpSeconds / NUM_SEC_PER_DAY))
        tmpSeconds -= numDays * NUM_SEC_PER_DAY

        val numHrs = floor((tmpSeconds / NUM_SEC_PER_HR))
        tmpSeconds -= numHrs * NUM_SEC_PER_HR

        val numMins = floor((tmpSeconds / NUM_SEC_PER_MIN))
        val numSecs = tmpSeconds - numMins * NUM_SEC_PER_MIN

        var formattedStr = buildString(numYears.toInt(), "year")
        formattedStr += buildString(numDays.toInt(), "day")
        formattedStr += buildString(numHrs.toInt(), "hour")
        formattedStr += buildString(numMins.toInt(), "minute")
        formattedStr += buildString(numSecs.toInt(), "second")

        var idx = formattedStr.lastIndexOf(", ")
        formattedStr = formattedStr.substring(0, idx)

        idx = formattedStr.lastIndexOf(", ")
        if (idx > 0) {
            formattedStr = formattedStr.substring(0, idx) + " and " + formattedStr.substring(idx + 2);
        }
        return formattedStr;
    }
}

fun main() {
    println(formatDuration(1))
    println(formatDuration(62))
    println(formatDuration(120))
    println(formatDuration(3600))
    println(formatDuration(3662))
}