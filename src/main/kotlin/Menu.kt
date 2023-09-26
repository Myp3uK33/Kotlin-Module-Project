import java.util.Scanner

class MenuHelper(private val items: List<String>) {
    private val scanner = Scanner(System.`in`)
    fun showMenu() {
        for (i in items.indices) {
            println("${i + 1}. ${items[i]}")
        }
    }

    fun readInput(): Int {
        while (true) {
            try {
                val input = scanner.nextLine().toInt()
                if (input in 1..items.size) {
                    return input
                } else {
                    println("Введите число от 1 до ${items.size}")
                }
            } catch (e: NumberFormatException) {
                println("Введите число")
            }
        }
    }
}