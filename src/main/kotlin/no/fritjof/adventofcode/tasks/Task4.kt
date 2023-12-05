package no.fritjof.adventofcode.tasks

import no.fritjof.adventofcode.util.FileUtil.getTaskFile
import kotlin.math.pow

object Task4 {

    fun getAnswerForTask4() {
        partOne()
        partTwo()
    }

    private fun partOne() {
        val file = getTaskFile("4-1")
        val totalPoints = mutableListOf<Int>()
        for (line: String in file.readLines()) {
            val winningNumbers = mutableListOf<Int>()
            val elfsNumbers = mutableListOf<Int>()
            val split = line.split(":")
            val second = split[1].split("|")
            winningNumbers.addAll(parseNumbers(second[0]))
            elfsNumbers.addAll(parseNumbers(second[1]))
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
        println("Answer to 4.1 is ${totalPoints.sum()}")
    }

    private fun partTwo() {
        val file = getTaskFile("4-1")
        val totalCards = mutableListOf<Int>()
        val copyCards = mutableListOf<String>()
        val lines = file.readLines()
        for ((index, line) in lines.withIndex()) {
            var winningNumbers = mutableListOf<Int>()
            var elfsNumbers = mutableListOf<Int>()
            var split = line.split(":")
            var second = split[1].split("|")
            winningNumbers.addAll(parseNumbers(second[0]))
            elfsNumbers.addAll(parseNumbers(second[1]))
            var numberOfCorrectNumbers = 0
            for (winningNumber: Int in winningNumbers) {
                if (elfsNumbers.contains(winningNumber)) {
                    numberOfCorrectNumbers++
                }
            }
            if (copyCards.isNotEmpty()) {
                for (copyCard: String in copyCards) {
                    split = copyCard.split(":")
                    second = split[1].split("|")
                    winningNumbers = mutableListOf()
                    elfsNumbers = mutableListOf()
                    winningNumbers.addAll(parseNumbers(second[0]))
                    elfsNumbers.addAll(parseNumbers(second[1]))
                    for (winningNumber: Int in winningNumbers) {
                        if (elfsNumbers.contains(winningNumber)) {
                            numberOfCorrectNumbers++
                        }
                    }
                }
            }

            if (numberOfCorrectNumbers > 0) {
                for (i in 1..numberOfCorrectNumbers) {
                    println("Card ${index + 1} adds ${lines[index + i].split(":")[0]}")
                    copyCards.add(lines[index + i])
                }
                println()
            }
        }
        println("Answer to 4.2 is ${copyCards.size}")
    }

    private fun parseNumbers(numbers: String): List<Int> {
        val list = mutableListOf<Int>()
        for (number: String in numbers.split(" "))
            if (number.isNotBlank()) list.add(number.toInt())
        return list
    }
}