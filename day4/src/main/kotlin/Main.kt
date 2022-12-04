import java.io.File
import java.util.Scanner

typealias Range = Pair<Int, Int>
fun Range.contains(other: Range): Boolean = first <= other.first && second >= other.second
fun Range.overlapsCompletely(other: Range): Boolean = contains(other) || other.contains(this)
fun Range.overlaps(other: Range): Boolean =
    (other.first in first..second)
    || (first in other.first .. other.second)

fun toRange(list: List<String>): Range = Pair(list[0].toInt(), list[1].toInt())

fun part1() {
    val input = Scanner(File("input.txt"))
    var count = 0
    while (input.hasNextLine()) {
        val line = input.nextLine()
        val parsed = line.split(",").map { toRange(it.split("-")) }
        if (parsed[0].overlapsCompletely(parsed[1])) {
            count++
        }
    }
    println("Complete overlaps: $count")
}

fun part2() {
    val input = Scanner(File("input.txt"))
    var count = 0
    while (input.hasNextLine()) {
        val line = input.nextLine()
        val parsed = line.split(",").map { toRange(it.split("-")) }
        if (parsed[0].overlaps(parsed[1])) {
            count++
        }
    }
    println("Partial overlaps: $count")
}

fun main() {
    part1()
    part2()
}