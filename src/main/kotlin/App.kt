const val fixedTax = 3500
const val variableTaxPercent = 0.0075

fun main() {

    val transactionSum = 4000_00 // сумма в 5000_00 посчитает комиссию в процентах

    val transactionTax =
        if (transactionSum * variableTaxPercent > fixedTax) (variableTaxPercent * transactionSum).toInt()
        else fixedTax

    println("Сумма перевода: ${"%.2f".format(transactionSum * 0.01)}\n" +
            "Комиссия: ${"%.2f".format(transactionTax * 0.01)}")
}


