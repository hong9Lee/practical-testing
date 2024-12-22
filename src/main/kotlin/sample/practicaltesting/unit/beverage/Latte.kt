package sample.practicaltesting.unit.beverage

import sample.practicaltesting.unit.beverage.Beverage

class Latte: Beverage {
    override fun getPrice(): Int {
        return 4500
    }

    override fun getName(): String {
        return "라떼"
    }
}
