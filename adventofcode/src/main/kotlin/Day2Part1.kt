data class CubeSet(var blue: Int = 0, var red: Int = 0, var green: Int = 0) {
    constructor(line: String) : this() {
        var results = line.split(",")

        for (result in results) {
            val el = result.trim().split(" ")
            when (el.last()) {
                "blue" -> this.blue = el.first().toInt()
                "green" -> this.green = el.first().toInt()
                "red" -> this.red = el.first().toInt()
            }
        }
    }

    fun power(): Int {
        return blue * red * green
    }
}

data class Game(var id: Int = 0, var cubeSets: List<CubeSet>) {

    constructor(line: String) : this(cubeSets = listOf()) {
        val contents = line.split(": ").last()

        this.id = line.split(": ").first().split(" ").last().toInt()

        for (content in contents.split("; ")) {
            this.cubeSets += CubeSet(content)
        }
    }

    fun isPossibleWithBag(bag: Bag): Boolean {
        for (cubeSet in cubeSets) {
            if (cubeSet.blue > bag.blue) {
                return false
            }
            if (cubeSet.red > bag.red) {
                return false
            }
            if (cubeSet.green > bag.green) {
                return false
            }
        }
        return true
    }

    fun minimumSetOfCube(): CubeSet {
        val minimumRed = (cubeSets.map { it.red }).max()
        val minimumBlue = (cubeSets.map { it.blue }).max()
        val minimumGreen = (cubeSets.map { it.green }).max()
        return CubeSet(blue = minimumBlue, red = minimumRed, green = minimumGreen)
    }
}

data class Bag(val blue: Int, val red: Int, val green: Int)


fun mainPart1() {
    val lines = object {}::class.java.getResourceAsStream("day2/input.txt").bufferedReader().readLines()

    val bag = Bag(red = 12, green = 13, blue = 14)
    var result = 0
    for (line in lines) {
        val game = Game(line)
        if (game.isPossibleWithBag(bag)) {
            result += game.id
        }
    }
    println(result)
}

fun main(){
    val lines = object {}::class.java.getResourceAsStream("day2/input.txt").bufferedReader().readLines()

    var result = 0
    for (line in lines) {
        val game = Game(line)
        val minimum = game.minimumSetOfCube()
        result += minimum.power()
    }
    println(result)
}