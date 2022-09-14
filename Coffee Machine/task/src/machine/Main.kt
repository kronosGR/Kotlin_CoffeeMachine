package machine


enum class Items(val onoma: String, val milk: Int, val coffee: Int, val water: Int, val price: Int) {
    espresso("espresso", 0, 16, 250, 4),
    latte("latte", 75, 20, 350, 7),
    cappuccino("cappuccino", 100, 12, 200, 6)
}

class CoffeeMachine() {
    private var milk = 540
    private var coffee = 120
    private var water = 400
    private var cups = 9
    private var money = 550

    fun info() {
        println()
        println("The coffee machine has:")
        println("${this.water} ml of water")
        println("${this.milk} ml of milk")
        println("${this.coffee} g of coffee beans")
        println("${this.cups} disposable cups")
        println("$${this.money} of money")
        println()
    }

    fun use(item: Items) {
        var msg = "I have enough resources, making you a coffee!"
        if (this.milk - item.milk < 0) {
            msg = "Sorry, not enough milk!"
        }
        if (this.coffee - item.coffee < 0) {
            msg = "Sorry, not enough coffee beans!"
        }
        if (this.water - item.water < 0) {
            msg = "Sorry, not enough water!"
        }
        if (this.cups - 1 < 0) {
            msg = "Sorry, not enough disposable cups!"
        }

        if (msg.equals("I have enough resources, making you a coffee!")) {
            this.milk -= item.milk
            this.coffee -= item.coffee
            this.water -= item.water
            this.cups--
            this.money += item.price
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
        this.water += readln().toInt()
        println("Write how many ml of milk you want to add:")
        this.milk += readln().toInt()
        println("Write how many grams of coffee beans you want to add:")
        this.coffee += readln().toInt()
        println("Write how many disposable cups you want to add:")
        this.cups += readln().toInt()
        println()
    }

    fun take() {
        println("I gave you ${this.money}")
        this.money = 0
        println()
    }
}

fun main() {
    val coffeeMachine = CoffeeMachine()

    fun getInput(): String {
        println("Write action (buy, fill, take,remaining, exit):")
        return readln()
    }

    while (true) {
        when (getInput()) {
            "buy" -> coffeeMachine.buy()
            "fill" -> coffeeMachine.fill()
            "take" -> coffeeMachine.take()
            "remaining" -> coffeeMachine.info()
            "exit" -> break;
        }
    }

}
