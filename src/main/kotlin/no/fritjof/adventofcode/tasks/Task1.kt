package no.fritjof.adventofcode.tasks

import no.fritjof.adventofcode.util.FileUtil
import java.io.File

object Task1 {

    fun getAnswerForTask1() {
        val fileName = FileUtil.getTaskFile(1)
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

        println("Answer is $sum")
    }
}