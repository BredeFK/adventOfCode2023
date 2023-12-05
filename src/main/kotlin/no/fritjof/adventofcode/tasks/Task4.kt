package no.fritjof.adventofcode.tasks

import no.fritjof.adventofcode.util.FileUtil.getTaskFile
import kotlin.math.pow

object Task4 {

    fun getAnswerForTask4() {
        part(1)
    }

    private fun part(part: Int) {
        val file = getTaskFile("4-$part")
        val totalPoints = mutableListOf<Int>()
        for (line: String in file.readLines()) {
            val winningNumbers = mutableListOf<Int>()
            val elfsNumbers = mutableListOf<Int>()
            val split = line.split(":")
            val second = split[1].split("|")
            winningNumbers.addAll(parseNumebrs(second[0]))
            elfsNumbers.addAll(parseNumebrs(second[1]))
            var numberOfCorrectNumbers = 0
            for (winningNumber: Int in winningNumbers) {
                if (elfsNumbers.contains(winningNumber)) {
                    numberOfCorrectNumbers++
                }
            }
            var points = 0
            if (numberOfCorrectNumbers > 0) {
                points = 2.0.pow(numberOfCorrectNumbers.toDouble() - 1).toInt()
            }
            totalPoints.add(points)
        }
        println("Answer to 4.$part is ${totalPoints.sum()}")
    }

    private fun parseNumebrs(numbers: String): List<Int> {
        val list = mutableListOf<Int>()
        for (number: String in numbers.split(" "))
            if (number.isNotBlank()) list.add(number.toInt())
        return list
    }
}