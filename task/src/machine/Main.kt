package machine

var machineWaterMl = 400
var machineMilkMl = 540
var machineBeanG = 120
var machineDisposableCups = 9
var machineMoney = 550

var exitCondition: Boolean? = false

fun main() {
    userAction()

}

fun printMachineState() {
    println(" ")
    println("The coffee machine has:")
    println("$machineWaterMl of water")
    println("$machineMilkMl of milk")
    println("$machineBeanG of coffee beans")
    println("$machineDisposableCups of disposable cups")
    println("\$$machineMoney of money")
    println(" ")

}

fun userAction() {
    while (exitCondition == false) {
        print("Write action(buy, fill, take, remaining, exit): > ")
        when (readLine()!!) {
            "buy" -> {
                println(" ")
                print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: > ")
                var coffeeOption = readLine()!!
                if (resourceCheck(coffeeOption)) {
                    buyOption(coffeeOption)
                } else {
                    println(" ")
                    userAction()
                }
                userAction()
            }
            "fill" -> {
                fillOption()
                userAction()
            }
            "take" -> {
                takeOption()
                userAction()
            }
            "remaining" -> {
                printMachineState()
            }
            "exit" -> {
                exitCondition = true
            }
        }
    }

}

fun resourceCheck(choiceInput: String): Boolean {
    if (machineWaterMl < 200) {
        println("Sorry, not enough water!")
        return false
    } else if (choiceInput == "2" || choiceInput == "3") {
        if (machineMilkMl < 75) {
            println("Sorry, not enough milk!")
            return false
        } else {
            println("I have enough resources, making you a coffee!")
            return true
        }
    } else if (machineBeanG < 12) {
        println("Sorry, not enough coffee beans!")
        return false
    } else if (machineDisposableCups < 1) {
        println("Sorry, not enough disposable cups!")
        return false
    } else {
        println("I have enough resources, making you a coffee!")
        return true
    }
    return false
}

fun buyOption(userChoice: String) {
    when (userChoice) {
        "1" -> {
            machineWaterMl -= 250
            machineBeanG -= 16
            machineMoney += 4
            machineDisposableCups -= 1
        }
        "2" -> {
            machineWaterMl -= 350
            machineMilkMl -= 75
            machineBeanG -= 20
            machineMoney += 7
            machineDisposableCups -= 1
        }
        "3" -> {
            machineWaterMl -= 200
            machineMilkMl -= 100
            machineBeanG -= 12
            machineMoney += 6
            machineDisposableCups -= 1
        }
        "back" -> {
            userAction()
        }
    }
}

fun fillOption() {
    println(" ")
    print("Write how many ml of water do you want to add: > ")
    val fillWater = readLine()!!.toInt()
    machineWaterMl += fillWater
    print("Write how many ml of milk do you want to add: > ")
    val fillMilk = readLine()!!.toInt()
    machineMilkMl += fillMilk
    print("Write how many grams of coffee beans do you want to add: > ")
    val fillBeans = readLine()!!.toInt()
    machineBeanG += fillBeans
    print("Write how many disposable cups of coffee do you want to add: > ")
    val fillCups = readLine()!!.toInt()
    machineDisposableCups += fillCups
    println(" ")
}

fun takeOption() {
    println(" ")
    println("I gave you \$$machineMoney")
    println(" ")
    machineMoney = 0
}


