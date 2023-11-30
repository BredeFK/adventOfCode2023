package no.fritjof.adventofcode

import no.fritjof.adventofcode.tasks.Task0.getAnswerForTask0
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AdventOfCodeApplication

fun main(args: Array<String>) {
    runApplication<AdventOfCodeApplication>(*args)
    getAnswerForTask0()
}
