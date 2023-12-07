import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals


class Day1Part1Test {

    companion object Factory {
        @JvmStatic
        fun calibrations(): List<Arguments> {
            return listOf(
                Arguments.of("1abc2", 12),
                Arguments.of("pqr3stu8vwx", 38),
                Arguments.of("a1b2c3d4e5f", 15),
                Arguments.of("treb7uchet", 77),
                )
        }
    }

    @ParameterizedTest
    @MethodSource("calibrations")
    fun readValue(input: String, expected: Int) {
        val result = calibrate(input)

        assertEquals(expected, result)
    }
}