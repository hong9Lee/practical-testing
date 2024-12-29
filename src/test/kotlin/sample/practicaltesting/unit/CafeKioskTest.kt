package sample.practicaltesting.unit

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import sample.practicaltesting.unit.beverage.Americano
import sample.practicaltesting.unit.beverage.Latte
import java.time.LocalDateTime

class CafeKioskTest {

    @Test
    fun add_manual_test() {
        val cafeKiosk = CafeKiosk()
        cafeKiosk.add(Americano())

        println(">> 담긴 음료 수: ${cafeKiosk.getBeverages().size}")
        println(">> 담긴 음료: ${cafeKiosk.getBeverages().get(0).getName()}")
    }

    @Test
    fun add() {
        val cafeKiosk = CafeKiosk()
        cafeKiosk.add(Americano())

        assertThat(cafeKiosk.getBeverages()).hasSize(1)
        assertThat(cafeKiosk.getBeverages().get(0).getName()).isEqualTo("아메리카노")
    }

    @Test
    fun addSeveralBeverages() {
        val cafeKiosk = CafeKiosk()
        val americano = Americano()
        cafeKiosk.add(americano, 2)

        assertThat(cafeKiosk.getBeverages().get(0)).isEqualTo(americano)
        assertThat(cafeKiosk.getBeverages().get(1)).isEqualTo(americano)
    }

    @Test
    fun addZeroBeverages() {
        val cafeKiosk = CafeKiosk()
        val americano = Americano()

        assertThatThrownBy { cafeKiosk.add(americano, 0) }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("음료는 1잔 이상 주문하실 수 있습니다.")
    }

    @Test
    fun remove() {
        val cafeKiosk = CafeKiosk()
        val americano = Americano()

        cafeKiosk.add(americano)
        assertThat(cafeKiosk.getBeverages()).hasSize(1)

        cafeKiosk.remove(americano)
        assertThat(cafeKiosk.getBeverages()).isEmpty()
    }

    @Test
    fun clear() {
        val cafeKiosk = CafeKiosk()
        val americano = Americano()
        val latte = Latte()

        cafeKiosk.add(americano)
        cafeKiosk.add(latte)
        assertThat(cafeKiosk.getBeverages()).hasSize(2)

        cafeKiosk.clear()
        assertThat(cafeKiosk.getBeverages()).isEmpty()
    }

    @Test
    fun calculateTotalPrice() {
        val cafeKiosk = CafeKiosk()
        val americano = Americano()
        val latte = Latte()
        cafeKiosk.add(americano)
        cafeKiosk.add(latte)

        val totalPrice = cafeKiosk.calculateTotalPrice()
        assertThat(totalPrice).isEqualTo(8500)
    }

    @Test
    fun createOrderWithCurrentTime() {
        val cafeKiosk = CafeKiosk()
        val americano = Americano()

        cafeKiosk.add(americano)
        val order = cafeKiosk.crateOrder(LocalDateTime.of(2023,12,12,12,14,0))

        assertThat(order.beverages).hasSize(1)
        assertThat(order.beverages.get(0).getName()).isEqualTo("아메리카노")
    }

    @Test
    fun createOrderOutsideOpenTime() {
        val cafeKiosk = CafeKiosk()
        val americano = Americano()

        cafeKiosk.add(americano)
        assertThatThrownBy { cafeKiosk.crateOrder(LocalDateTime.of(2023,12,12,23,14,0)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("주문 시간이 아닙니다.")
    }
}
