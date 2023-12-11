fun calibrate(input: String): Int {
    val result = input.filter { it.isDigit() }

    val firstDigit = result.first()
    val lastDigit = result.last()

    return ("${firstDigit}${lastDigit}").toInt()
}


fun main() {
    val lines = object {}::class.java.getResourceAsStream("day1/input.txt").bufferedReader().readLines()
    var result = 0

    for (line in lines) {
        result += calibrate(line)
    }
    println(result)
}
