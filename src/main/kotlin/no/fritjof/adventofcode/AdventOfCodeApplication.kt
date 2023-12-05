package no.fritjof.adventofcode

import no.fritjof.adventofcode.tasks.Task4.getAnswerForTask4
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AdventOfCodeApplication

fun main(args: Array<String>) {
    runApplication<AdventOfCodeApplication>(*args)
    // getAnswerForTask1() // ⭐⭐
    // getAnswerForTask2() // ⭐⭐
    // getAnswerForTask3() // ⭐⭐
    getAnswerForTask4() // ⭐
}
