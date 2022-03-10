const val fixedTax = 3500
const val variableTaxPercent = 0.0075

fun main() {

    val transactionSum = 4000_00 // сумма в 5000_00 посчитает комиссию в процентах

    val transactionTax =
        if (transactionSum * variableTaxPercent > fixedTax) (variableTaxPercent * transactionSum).toInt()
        else fixedTax

    println("Сумма перевода: ${formattedSum(transactionSum)}\nКомиссия: ${formattedSum(transactionTax)}")
}

fun formattedSum (sum: Int) :String {
    val wholePart = sum / 100
    val cents = sum % 100
    return "$wholePart.${if (cents != 0) cents else "00"}"
}

