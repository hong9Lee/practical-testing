package sample.practicaltesting.unit

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import sample.practicaltesting.unit.beverage.Americano
import sample.practicaltesting.unit.beverage.Latte

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
}
