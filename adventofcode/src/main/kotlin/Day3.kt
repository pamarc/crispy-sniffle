import java.io.BufferedReader

data class Number(val value: Int, val coordinates: IntRange)

data class Line(var numbers: List<Number>, var contents: List<Char>) {
    constructor(line: String) : this(listOf(), listOf()) {
        var currentDigit = ""
        var startCoordinate = -1

        for (i in line.indices) {
            val el = line[i]
            this.contents += el
            if (el.isDigit()) {
                if (currentDigit.isEmpty()) {
                    startCoordinate = i
                }
                currentDigit += el
                if (i == line.length -1) {
                    val newNumber = Number(
                        currentDigit.toInt(),
                        IntRange(startCoordinate, i - 1)
                    )
                    this.numbers += newNumber
                    currentDigit = ""
                    startCoordinate = -1
                }
            } else {
                if (currentDigit.isNotEmpty()) {
                    val newNumber = Number(
                        currentDigit.toInt(),
                        IntRange(startCoordinate, i - 1)
                    )
                    this.numbers += newNumber
                    currentDigit = ""
                    startCoordinate = -1
                }
            }
        }
    }
}

fun checkIfSymbol(contents: List<Char>, position: Int): Boolean {
    if (position < 0) {
        return false
    }
    if (position >= contents.size) {
        return false
    }
    val content = contents[position]
    if (content.isDigit()) {
        return false
    }
    if (content.equals('.')) {
        return false
    }
    return true
}

data class Engine(var lines: List<Line>) {
    constructor(contents: String) : this(listOf()) {
        for (line in contents.lines()) {
            val newLine = Line(line)
            this.lines += newLine
        }
    }

    constructor(reader: BufferedReader): this(listOf()) {
        for (line in reader.readLines()) {
            val newLine = Line(line)
            this.lines += newLine
        }
    }

    fun extractAdjacentNumbers(): List<Int> {
        var result = listOf<Int>()
        for (lineNumber in lines.indices) {
            val currentLine = lines[lineNumber]
            for (number in currentLine.numbers) {
                var positionsToCheck = listOf(
                    currentLine.contents to listOf(
                        number.coordinates.first - 1,
                        number.coordinates.last + 1
                    )
                )
                val extendedCoordinates = IntRange(
                    number.coordinates.first - 1,
                    number.coordinates.last + 1
                ).toList()

                if (lineNumber > 0) {
                    positionsToCheck += lines[lineNumber - 1].contents to extendedCoordinates
                }
                if (lineNumber < lines.size - 1) {
                    positionsToCheck += lines[lineNumber + 1].contents to extendedCoordinates
                }
                for (positionToCheck in positionsToCheck) {
                    for (position in positionToCheck.second) {
                        if (checkIfSymbol(positionToCheck.first, position)) {
                            result += number.value
                            continue
                        }
                    }
                }
            }
        }
        return result
    }
}

fun main(){
    val contents = object {}::class.java.getResourceAsStream("day3/input.txt").bufferedReader()
    val engine = Engine(contents)

    var result = 0
    val numbers = engine.extractAdjacentNumbers()

    for (number in engine.extractAdjacentNumbers()){
        println(number)
        result += number
    }
    println(result)
}