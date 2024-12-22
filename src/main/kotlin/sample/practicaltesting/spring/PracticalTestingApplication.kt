package sample.practicaltesting.spring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PracticalTestingApplication

fun main(args: Array<String>) {
    runApplication<PracticalTestingApplication>(*args)
}