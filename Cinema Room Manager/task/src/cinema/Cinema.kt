package cinema

private var rows = 0
private var seats = 0
private var rowNumber = 0
private var seatNumber = 0
private var countB = 0
private val ticketPriceM = mutableListOf<Int>()
fun main() {
    //print seating arrangement
    println("Enter the number of rows:")
    rows = readLine()!!.toInt()
    println("Enter the number of seats in each row:")
    seats = readLine()!!.toInt()
    val cinemaArray = Array(rows) { CharArray(seats) } // declare the 2d array

    for (i in cinemaArray.indices) { //populate the 2d array with 'S' characters
        for (j in cinemaArray[i].indices) {
            cinemaArray[i][j] = 'S'
        }
    }
    do {
        val again = displayMenu(cinemaArray)
    } while (again)
}

fun displayMenu(cinemaArray: Array<CharArray>): Boolean {
    println()
    println("1. Show the seats")
    println("2. Buy a ticket")
    println("3. Statistics")
    println("0. Exit")

    return when (readLine()!!.toInt()) {
        1 -> {
            showTheSeats(cinemaArray)
            true
        }
        2 -> {
            ticketPrice(cinemaArray)
            true
        }
        3 -> {
            statistics(cinemaArray)
            return true
        }
        0 -> false
        else -> false
    }
}

fun statistics(cinemaArray: Array<CharArray>) {
    val income: Int
    var numOfPlace = 0
//    var soldSeats = 0
    for (i in cinemaArray.indices) {
        for (j in cinemaArray[i].indices) {
            numOfPlace = cinemaArray[i].count() * cinemaArray[j].count()
//            soldSeats = cinemaArray.count { it.contains('B')  }
        }
    }

    if (numOfPlace < 60) {
        income = numOfPlace * 10
    } else {
        if (numOfPlace % 2 == 0) {
            income = numOfPlace / 2 * 10 + numOfPlace / 2 * 8
        } else {
            income = numOfPlace / 2 * 10 + (numOfPlace / 2 /*+ 1*/) * 8
        }
    }
    val percentageIncome = (countB.toFloat() / numOfPlace) * 100
    val currentIncome = ticketPriceM.sum()
    println("Number of purchased tickets: $countB")
    println("Percentage: %.2f".format(percentageIncome)+"%")
    println("Current income: $$currentIncome")
    println("Total income: $$income ")

}

fun showTheSeats(cinemaArray: Array<CharArray>) {
    println("Cinema:")
    print("  ") //print two spaces
    for (i in 1..cinemaArray[0].lastIndex + 1) { //print seat numbers
        print("$i ")
    }
    println()
    for (i in cinemaArray.indices) { //print the rows
        print("${i + 1} ") //print row number
        for (j in cinemaArray[i].indices) {
            print("${cinemaArray[i][j]} ")
        }
        println()
    }
}

fun ticketPrice(cinemaArray: Array<CharArray>) {

        println("Enter a row number:")
        rowNumber = readLine()!!.toInt()
        println("Enter a seat number in that row:")
        seatNumber = readLine()!!.toInt()
    if (rowNumber > rows || seatNumber > seats) {
        println("Wrong input!")
        ticketPrice(cinemaArray)
    }

    if (cinemaArray[rowNumber - 1][seatNumber - 1] == 'B') {
        println("That ticket has already been purchased!")
        ticketPrice(cinemaArray)
    }

    val totalSeats = (cinemaArray.lastIndex + 1) * (cinemaArray[0].lastIndex + 1)

    val ticketPrice = if (totalSeats < 60) {
        10
    } else {
        if (rowNumber <= (cinemaArray.lastIndex + 1) / 2) {
            10
        } else {
            8
        }
    }
    countB++
    ticketPriceM.add(ticketPrice)
    println()
    println("Ticket price: $$ticketPrice")

    cinemaArray[rowNumber - 1][seatNumber - 1] = 'B'
}