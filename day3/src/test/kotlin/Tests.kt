import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Tests {

    @Test
    fun testCleave() {
        val (a, b) = cleave("foobar")
        assertEquals("foo", a)
        assertEquals("bar", b)
    }

    @Test
    fun testCleaveEmpty() {
        val (a, b) = cleave("")
        assertEquals("", a)
        assertEquals("", b)
    }

    @Test
    fun testCommonItem() {
        assertNull(findCommonItem("abc", "def"))
        assertNull(findCommonItem("abc", ""))
        assertNull(findCommonItem("", "def"))
        assertNull(findCommonItem("", ""))
        assertEquals('a', findCommonItem("abc", "xyaz"))
        assertEquals('e', findCommonItem("orange", "red"))
        assertEquals('a', findCommonItem("foobar", "baz", "apple"))
    }

    @Test
    fun testPriorityOf() {
        assertEquals(1, priorityOf('a'))
        assertEquals(2, priorityOf('b'))
        assertEquals(25, priorityOf('y'))
        assertEquals(26, priorityOf('z'))

        assertEquals(27, priorityOf('A'))
        assertEquals(28, priorityOf('B'))
        assertEquals(51, priorityOf('Y'))
        assertEquals(52, priorityOf('Z'))
    }
}