package no.fritjof.adventofcode.tasks

import no.fritjof.adventofcode.util.FileUtil.getTaskFile

object Task3 {

    fun getAnswerForTask3() {
        part(1)
        part(2)
    }

    private fun part(part: Int) {
        val file = getTaskFile("3-1")
        val lines: List<String> = file.readLines()

        println("Answer to 3.$part is ${lines.size}")
    }

}