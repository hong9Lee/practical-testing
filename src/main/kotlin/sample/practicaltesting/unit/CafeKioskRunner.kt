package sample.practicaltesting.unit

import sample.practicaltesting.unit.beverage.Americano
import sample.practicaltesting.unit.beverage.Latte

class CafeKioskRunner {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val cafeKiosk = CafeKiosk()
            cafeKiosk.add(Americano())
            println(">> 아메리카노 추가")

            cafeKiosk.add(Latte())
            println(">> 라떼 추가")

            val totalPrice = cafeKiosk.calculateTotalPrice()
            println("총 주문 가격: $totalPrice")

        }
    }

}
