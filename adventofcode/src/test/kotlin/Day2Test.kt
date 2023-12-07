import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

class Day2Test {
    companion object Factory {
        @JvmStatic
        fun games(): List<Arguments> {
            return listOf(
                Arguments.of(
                    Game(
                        listOf(
                            CubeSet(3, 4),
                            CubeSet(red = 1, blue = 6, green = 2),
                            CubeSet(green = 2)
                        )
                    ), true
                ),
                Arguments.of(
                    Game(
                        listOf(
                            CubeSet(blue = 1, green = 2),
                            CubeSet(red = 1, blue = 4, green = 3),
                            CubeSet(green = 1, blue = 1)
                        )
                    ), true
                ),
                Arguments.of(
                    Game(
                        listOf(
                            CubeSet(blue = 6, green = 8, red = 20),
                            CubeSet(red = 4, blue = 5, green = 13),
                            CubeSet(green = 5, red = 1)
                        )
                    ), false
                )
            )
        }
    }

    @ParameterizedTest
    @MethodSource("games")
    fun `test if the game is possible with a given bag`(game: Game, isPossible: Boolean) {
        val bag = Bag(14, 12, 13)

        assertEquals(isPossible, game.isPossibleWithBag(bag))
    }
}