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
}

data class Game(var cubeSets: List<CubeSet>) {

    constructor(line: String) : this(listOf()) {
        val contents = line.split(": ").last()

        for (content in contents.split("; ")){
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
}

data class Bag(val blue: Int, val red: Int, val green: Int)


class Day2 {
}