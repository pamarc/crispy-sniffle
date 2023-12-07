import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals


class Day1Part2Test {

    companion object Factory {
        @JvmStatic
        fun calibrations(): List<Arguments> {
            return listOf(
                Arguments.of("two1nine", 29),
                Arguments.of("eightwothree", 83),
                Arguments.of("abcone2threexyz", 13),
                Arguments.of("xtwone3four", 24),
                Arguments.of("4nineeightseven2", 42),
                Arguments.of("zoneight234", 14),
                Arguments.of("7pqrstsixteen", 76),
                Arguments.of("eighthree", 83),
                Arguments.of("sevenine", 79),
                Arguments.of("oneight", 18),
                Arguments.of("2jbbf", 22),
                Arguments.of("6twofive3two", 62),
                Arguments.of("oneoneone", 11)
                )
        }
    }

    @ParameterizedTest
    @MethodSource("calibrations")
    fun readValue(input: String, expected: Int) {
        val result = calibrateV2(input)

        assertEquals(expected, result)
    }
}