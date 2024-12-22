package sample.practicaltesting.unit

import sample.practicaltesting.unit.beverage.Beverage
import sample.practicaltesting.unit.order.Order
import java.time.LocalDateTime

class CafeKiosk {

    private val beverages = mutableListOf<Beverage>()
    fun add(beverage: Beverage) {
        beverages.add(beverage)
    }

    fun remove(beverage: Beverage) {
        beverages.remove(beverage)
    }

    fun clear() {
        beverages.clear()
    }

    fun calculateTotalPrice(): Int {
        var totalPrice: Int = 0
        for (beverage in beverages) {
            totalPrice += beverage.getPrice()
        }

        return totalPrice
    }

    fun crateOrder(): Order {
        return Order(LocalDateTime.now(), beverages)
    }

    fun getBeverages(): List<Beverage> = beverages.toList()

}
