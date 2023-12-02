package no.fritjof.adventofcode.tasks

import no.fritjof.adventofcode.util.FileUtil.getTaskFile

object Task2 {
    private const val MAX_RED_CUBES = 12
    private const val MAX_GREEN_CUBES = 13
    private const val MAX_BLUE_CUBES = 14

    fun getAnswerForTask2() {
        partOne()
    }

    private fun partOne() {
        val file = getTaskFile("2-1")
        val lines: List<String> = file.readLines()

        val possibleGames: MutableList<Int> = mutableListOf()

        var reds: MutableList<Int>
        var greens: MutableList<Int>
        var blues: MutableList<Int>

        lines.forEach { line ->
            reds = mutableListOf()
            greens = mutableListOf()
            blues = mutableListOf()

            val splitLines = line.split(":")
            splitLines[1].split(";").forEach { round ->
                val colors = round.split(",")
                colors.forEach { color ->
                    if (color.contains("red"))
                        reds.add(color.replace("red", "").trim().toInt())
                    if (color.contains("green"))
                        greens.add(color.replace("green", "").trim().toInt())
                    if (color.contains("blue"))
                        blues.add(color.replace("blue", "").trim().toInt())
                }
            }
            if (maxValueOrZero(reds) <= MAX_RED_CUBES &&
                    maxValueOrZero(greens) <= MAX_GREEN_CUBES &&
                    maxValueOrZero(blues) <= MAX_BLUE_CUBES) {
                possibleGames.add(splitLines[0].replace("Game ", "").toInt())
            }
        }

        //possibleGames.forEach { println(it) }
        println("Answer to 2.1 is ${possibleGames.sum()}")
    }

    private fun maxValueOrZero(list: List<Int>): Int {
        if (list.maxOrNull() == null) return 0
        return list.max()
    }
}