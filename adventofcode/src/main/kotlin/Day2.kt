data class CubeSet (val blue: Int = 0, val red: Int = 0, val green: Int = 0) {
    constructor(line: String) : this() {

    }
}

data class Game(val cubeSets: List<CubeSet>) {
    fun isPossibleWithBag(bag: Bag): Boolean {
        for (cubeSet in cubeSets){
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