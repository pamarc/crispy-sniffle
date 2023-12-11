val DIGITS = mapOf<String, Int>(
    "one" to 1,
    "two" to 2,
    "three" to 3,
    "four" to 4,
    "five" to 5,
    "six" to 6,
    "seven" to 7,
    "eight" to 8,
    "nine" to 9,
)

fun ignoreCaseOpt(ignoreCase: Boolean) =
    if (ignoreCase) setOf(RegexOption.IGNORE_CASE) else emptySet()

fun String?.indexesOf(pat: String, ignoreCase: Boolean = true): List<Int> =
    pat.toRegex(ignoreCaseOpt(ignoreCase))
        .findAll(this?: "")
        .map { it.range.first }
        .toList()

fun calibrateV2(input: String): Int {
    var input = input

    var temp = listOf<Pair<Int, Int>>()

    for (i in input.indices){
        if (input[i].isDigit()) {
            temp += i to input[i].digitToInt()
        }
    }

    for (digit in DIGITS) {
        var wheres = input.indexesOf(digit.key, ignoreCase = true)
        for (where in wheres){
            temp += where to digit.value
        }
    }

    temp = temp.sortedWith(compareBy({it.first}, {it.second}))

    val firstDigit = temp.first().second
    val lastDigit = temp.last().second

    return ("${firstDigit}${lastDigit}").toInt()
}


fun main() {
    val lines = object {}::class.java.getResourceAsStream("day1/input.txt").bufferedReader().readLines()
    var result: Int = 0

    for (line in lines) {
        val calibration = calibrateV2(line)
        result += calibration
        println("line: $line -> $calibration")
    }
    println(result)
}
