const val firstStepDiscountLevel = 1_001
const val secondStepDiscountLevel = 10_001

const val firstStepDiscountSum = 100
const val secondStepDiscountPercent = 5
const val premiumAccountDiscountPercent = 1

fun main() {
    val previousBuySum = 11000
    val currentCardSum = 100
    val premiumAccount = true
    val basicDiscountString: String
    val premiumDiscountString: String

    val basicDiscountCheck =
        if (previousBuySum < firstStepDiscountLevel) {
            basicDiscountString = "Суммы последней покупки недостоаточно для базовой скидки"
            currentCardSum.toFloat()
        } else if (previousBuySum < secondStepDiscountLevel) {
            basicDiscountString = "С учетом базовой скидки $firstStepDiscountSum рублей - "
            (currentCardSum - firstStepDiscountSum).toFloat()
        } else {
            basicDiscountString = "С учетом базовой скидки $secondStepDiscountPercent% - "
            currentCardSum * (100 - secondStepDiscountPercent) / 100F
        }

    val premiumDiscountCheck =
        if (premiumAccount) {
            premiumDiscountString = "С учетом скидки 'Меломан' $premiumAccountDiscountPercent% - "
            basicDiscountCheck * (100 - premiumAccountDiscountPercent) / 100
        } else {
            premiumDiscountString = "Суммы покупок в за прошлый месяц недостаточно для скидки 'Меломан'"
            basicDiscountCheck
        }

    println("""
        Ваша корзина на сумму $currentCardSum ${rublesFormat(currentCardSum)}
        $basicDiscountString${if (basicDiscountCheck != currentCardSum.toFloat()) currencyFormat(basicDiscountCheck) else ""}
        $premiumDiscountString${if (premiumAccount) currencyFormat(premiumDiscountCheck) else ""}
    """.trimIndent())
}

fun currencyFormat (amount: Float): String {
    val rubles = amount.toInt()
    val pennies = ((amount - rubles) * 100).toInt()
    return "$rubles ${rublesFormat(rubles)} ${"%02d".format(pennies)} ${pennyFormat(pennies)}"
}

fun rublesFormat (value: Int): String {
    return if (value % 10 == 1 && value % 100 != 11) {
        "рубль"
    } else if (value % 10 in 2..4 && value % 100 !in 12..14) {
        "рубля"
    } else {
        "рублей"
    }
}

fun pennyFormat (value: Int): String {
    return if (value % 10 == 1 && value % 100 != 11) {
        "копйка"
    } else if (value % 10 in 2..4 && value % 100 !in 12..14) {
        "копейки"
    } else {
        "копеек"
    }
}