package sample.practicaltesting.unit.order

import sample.practicaltesting.unit.beverage.Beverage
import java.time.LocalDateTime

data class Order (
    val orderDateTime: LocalDateTime,
    val beverages: List<Beverage>
)
