import java.io.File
import java.util.Scanner

fun cleave(line:String): Pair<String, String> = Pair(
    line.substring(0, line.length/2),
    line.substring(line.length/2)
)

fun priorityOf(item: Char): Int =
    if (item < 'a') {
        item - 'A' + 27
    }
    else {
        item - 'a' + 1
    }

fun part1() {
    val input = Scanner(File("input.txt"))
    var total = 0
    while (input.hasNextLine()) {
        val (a, b) = cleave(input.nextLine())
        val common = findCommonItem(a, b)
        val priority = priorityOf(common!!)
        total += priority
    }
    println("Part 1 total priority: $total")
}

fun part2() {
    val input = Scanner(File("input.txt"))
    var total = 0
    while (input.hasNextLine()) {
        val (a, b, c) = listOf(input.nextLine(), input.nextLine(), input.nextLine())
        val common = findCommonItem(a, b, c)
        val priority = priorityOf(common!!)
        total += priority
    }
    println("Part 2 total priority: $total")
}

fun main() {
    part1()
    part2()
}