package sample.practicaltesting.unit

import sample.practicaltesting.unit.beverage.Beverage
import sample.practicaltesting.unit.order.Order
import java.time.LocalDateTime
import java.time.LocalTime

class CafeKiosk {

    companion object {
        private val SHOP_OPEN_TIME: LocalTime = LocalTime.of(10, 0)
        private val SHOP_CLOSE_TIME: LocalTime = LocalTime.of(22, 0)
    }

    private val beverages = mutableListOf<Beverage>()
    fun add(beverage: Beverage) {
        beverages.add(beverage)
    }

    fun add(beverage: Beverage, count: Int) {
        if (count <= 0) {
            throw IllegalArgumentException("음료는 1잔 이상 주문하실 수 있습니다.")
        }
        repeat(count) {
            beverages.add(beverage)
        }
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

    fun crateOrder(currentDateTime: LocalDateTime): Order {
        val currentTime = currentDateTime.toLocalTime()
        if(currentTime.isBefore(SHOP_OPEN_TIME) || currentTime.isAfter(SHOP_CLOSE_TIME)) {
            throw IllegalArgumentException("주문 시간이 아닙니다.")
        }

        return Order(currentDateTime, beverages)
    }

    fun getBeverages(): List<Beverage> = beverages.toList()

}
