import java.io.File
import java.util.Scanner

fun readElf(input : Scanner): Int {
    var calories = 0;
    while (input.hasNextLine()) {
        val s = input.nextLine()
        if (s.isEmpty()) {
            break
        }
        calories += s.toInt()
    }
    return calories
}

fun main() {
    val input = Scanner(File("input.txt"))
    val elves = mutableListOf<Int>()
    while (input.hasNext()) {
        elves.add(readElf(input))
    }
    println("Top elf: " + elves.max())
    println("Top three sum: " + elves.sorted().reversed().subList(0, 3).sum())
}