typealias Groups = List<Pair<List<Char>, Int>>

fun Groups.indexesInBounds(): Boolean = this.all { (items, index) -> index < items.size }
fun Groups.allMatch(): Boolean = this.map { (items, index) -> items[index]}.distinct().size == 1
fun Groups.currentChars(): List<Char> = this.map { it.first[it.second] }
fun Groups.getFirst(): Char = this.currentChars()[0]
fun Groups.maxChar(): Char = this.currentChars().max()
fun Groups.incrementSmallerThan(c: Char) = this.map {
    when {
        (it.first[it.second] < c) -> Pair(it.first, it.second + 1)
        else -> it
    }
}

fun findCommonItem(a: String, b: String): Char? = findCommonItem(listOf(a, b))
fun findCommonItem(a: String, b: String, c: String): Char? = findCommonItem(listOf(a, b, c))
fun findCommonItem(groupsIn: List<String>): Char? {
    var groups = groupsIn.map { it.toList().distinct().sorted() } zip groupsIn.map { 0 }

    while (groups.indexesInBounds()) {
        if (groups.allMatch()) {
            return groups.getFirst()
        }
        groups = groups.incrementSmallerThan(groups.maxChar())
    }
    return null
}

