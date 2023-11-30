package no.fritjof.adventofcode.tasks

import no.fritjof.adventofcode.util.FileUtil
import java.io.File

object Task0 {

    fun getAnswerForTask0() {
        val fileName = FileUtil.getTaskFile(0)

        val lines: List<String> = File(fileName).readLines()
        var sum = 0
        for (line: String in lines) {
            sum += line.toInt()
        }
        println("Sum is $sum")
    }
}