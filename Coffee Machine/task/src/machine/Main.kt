package machine


enum class Items(val onoma: String, val milk: Int, val coffee: Int, val water: Int, val price: Int) {
    espresso("espresso", 0, 16, 250, 4),
    latte("latte", 75, 20, 350, 7),
    cappuccino("cappuccino", 100, 12, 200, 6)
}

fun main() {

    var MILK = 540
    var COFFEE = 120
    var WATER = 400
    var CUPS = 9
    var MONEY = 550

    fun info() {
        println()
        println("The coffee machine has:")
        println("$WATER ml of water")
        println("$MILK ml of milk")
        println("$COFFEE g of coffee beans")
        println("$CUPS disposable cups")
        println("$$MONEY of money")
        println()
    }

    fun use(item: Items) {

        var msg = "I have enough resources, making you a coffee!"
        if (MILK - item.milk < 0) {
            msg = "Sorry, not enough milk!"
        }
        if (COFFEE - item.coffee < 0) {
            msg = "Sorry, not enough coffee beans!"
        }
        if (WATER - item.water < 0) {
            msg = "Sorry, not enough water!"
        }
        if (CUPS - 1 < 0) {
            msg = "Sorry, not enough disposable cups!"
        }

        if (msg.equals("I have enough resources, making you a coffee!")) {
            MILK -= item.milk
            COFFEE -= item.coffee
            WATER -= item.water
            CUPS--
            MONEY += item.price
        }

        println(msg)
        println()
    }

    fun buy() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
        val what = readln()

        if (what.equals("back")) {
            return
        }

        when (what.toInt()) {
            1 -> use(Items.espresso)
            2 -> use(Items.latte)
            3 -> use(Items.cappuccino)
        }
    }

    fun fill() {
        println("Write how many ml of water you want to add:")
        WATER += readln().toInt()
        println("Write how many ml of milk you want to add:")
        MILK += readln().toInt()
        println("Write how many grams of coffee beans you want to add:")
        COFFEE += readln().toInt()
        println("Write how many disposable cups you want to add:")
        CUPS += readln().toInt()
        println()
    }

    fun take() {
        println("I gave you $MONEY")
        MONEY = 0
        println()
    }

    fun getInput(): String {
        println("Write action (buy, fill, take,remaining, exit):")
        return readln()
    }

    //info()
    while (true) {
        when (getInput()) {
            "buy" -> buy()
            "fill" -> fill()
            "take" -> take()
            "remaining" -> info()
            "exit" -> break;
        }
    }

}
