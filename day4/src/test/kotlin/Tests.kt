import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Tests {

    @Test
    fun testOverlaps() {
        assertTrue(Range(1, 10).overlaps(Range(1, 10)))
        assertTrue(Range(1, 10).overlaps(Range(5, 15)))
        assertTrue(Range(5, 10).overlaps(Range(9, 15)))
        assertFalse(Range(1, 10).overlaps(Range(11, 15)))
        assertFalse(Range(10, 20).overlaps(Range(3, 5)))
        assertTrue(Range(74, 79).overlaps(Range(66, 80)))
    }
}