package no.fritjof.adventofcode.tasks

import no.fritjof.adventofcode.util.FileUtil.getTaskFile
import java.io.File

object Task1 {

    fun getAnswerForTask1() {
        partOne()
        partTwo()
    }

    private fun partOne() {
        val fileName = getTaskFile("1-1")
        val lines: List<String> = File(fileName).readLines()
        val numbers: MutableList<Int> = mutableListOf()
        for (line: String in lines) {
            val digits: MutableList<Char> = mutableListOf()
            for (char: Char in line.toCharArray()) {
                if (char.isDigit()) {
                    digits.add(char)
                }
            }
            if (digits.size == 1) {
                numbers.add("${digits[0]}${digits[0]}".toInt())
            } else {
                numbers.add("${digits.first()}${digits.last()}".toInt())
            }
        }

        var sum = 0
        numbers.forEach {
            sum += it
        }

        println("Answer to 1.1 is $sum")
    }

    private fun partTwo() {
        val stringNumbers = listOf(
            "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
        )
        val fileName = getTaskFile("1-2")
        val lines: List<String> = File(fileName).readLines()
        val numbers: MutableList<Int> = mutableListOf()
        for (line: String in lines) {
            val digits: MutableList<String> = mutableListOf()
            for ((index, char) in line.toCharArray().withIndex()) {
                if (char.isDigit()) {
                    digits.add(char.toString())
                } else {
                    for (stringNumber: String in stringNumbers) {
                        if (((stringNumber.length + index) <= line.length)) {
                            val number = line.substring(index, stringNumber.length + index)
                            if (stringNumbers.contains(number)) {
                                digits.add("${stringNumbers.indexOf(number) + 1}")
                                break
                            }
                        }
                    }
                }
            }

            if (digits.size == 1) {
                numbers.add("${digits[0]}${digits[0]}".toInt())
            } else {
                numbers.add("${digits.first()}${digits.last()}".toInt())
            }
        }

        var sum = 0
        numbers.forEach {
            sum += it
        }

        println("Answer to 1.2 is $sum")
    }
}