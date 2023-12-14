import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day3Test {

    @Test
    fun `test read line`() {
        val line = "467..114.."
        val result = Line(line)
        assertEquals(
            Line(
                numbers = listOf(
                    Number(value = 467, coordinates = IntRange(0, 2)),
                    Number(value = 114, coordinates = IntRange(5, 7))
                ),
                contents = listOf('4', '6', '7', '.', '.', '1', '1', '4', '.', '.')
            ), result
        )
    }

    @Test
    fun `extract non adjacent numbers in engine`() {
        val engine = Engine(
            """
            467..114..
            ...*......
            ..35..633.
            ......#...
            617*......
            .....+.58.
            ..592.....
            ......755.
            ...$.*....
            .664.598..
        """.trimIndent()
        )

        val result = engine.extractAdjacentNumbers()

        assertEquals(listOf(467, 35, 633, 617, 592, 755, 664, 598), result)
    }

}