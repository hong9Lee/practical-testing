package sample.practicaltesting.unit.beverage

class Americano(): Beverage {
    override fun getPrice(): Int {
        return 4000
    }

    override fun getName(): String {
        return "아메리카노"
    }
}
