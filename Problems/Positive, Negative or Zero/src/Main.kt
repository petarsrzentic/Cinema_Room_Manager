import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val num = scanner.nextInt()

    if (num > 0) {
        println("positive")
    } else if (num < 0) {
        println("negative")
    } else {
        println("zero")
    }
}