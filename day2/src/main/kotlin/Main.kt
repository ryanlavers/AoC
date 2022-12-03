import java.io.File
import java.util.Scanner
import TheirMove.*
import MyMove.*

enum class TheirMove {
    A, B, C
}

enum class MyMove {
    X, Y, Z
}

class Round(raw: String) {
    private val split = raw.split(" ")
    val theirs = TheirMove.valueOf(split[0])
    val mine = MyMove.valueOf(split[1])

    fun withNewMine(new : MyMove): Round {
        return Round("${this.theirs} $new")
    }
}

fun shapeScore(round: Round): Int =
    "XYZ".indexOf(round.mine.toString()) + 1


fun outcomeScore(round : Round): Int = when(round.theirs) {
    A -> when(round.mine) {
        X -> 3
        Y -> 6
        Z -> 0
    }
    B -> when(round.mine) {
        X -> 0
        Y -> 3
        Z -> 6
    }
    C -> when(round.mine) {
        X -> 6
        Y -> 0
        Z -> 3
    }
}

fun scoreRound1(round :Round):Int {
    return shapeScore(round) + outcomeScore(round)
}

fun scoreRound2(round :Round):Int {
    val newRound = round.withNewMine(getMyMove(round))
    return shapeScore(newRound) + outcomeScore(newRound)
}

fun getMyMove(round: Round): MyMove = when(round.theirs) {
    A -> when(round.mine) {
        X -> Z
        Y -> X
        Z -> Y
    }
    B -> when(round.mine) {
        X -> X
        Y -> Y
        Z -> Z
    }
    C -> when(round.mine) {
        X -> Y
        Y -> Z
        Z -> X
    }
}

fun main() {
    val input = Scanner(File("input.txt"))
    var total = 0
    while (input.hasNextLine()) {
        val round = Round(input.nextLine())
//        val score = scoreRound1(round)
        val score = scoreRound2(round)
        total += score
    }
    print("GRAND TOTAL: $total")
}