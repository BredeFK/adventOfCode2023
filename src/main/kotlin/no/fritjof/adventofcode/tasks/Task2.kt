package no.fritjof.adventofcode.tasks

import no.fritjof.adventofcode.util.FileUtil.getTaskFile

object Task2 {
    private const val MAX_RED_CUBES = 12
    private const val MAX_GREEN_CUBES = 13
    private const val MAX_BLUE_CUBES = 14

    fun getAnswerForTask2() {
        part(1)
        part(2)
    }

    private fun part(part: Int) {
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
            if (part == 1
                    && reds.max() <= MAX_RED_CUBES && greens.max() <= MAX_GREEN_CUBES && blues.max() <= MAX_BLUE_CUBES) {
                possibleGames.add(splitLines[0].replace("Game ", "").toInt())
            } else if (part == 2) {
                possibleGames.add(reds.max() * greens.max() * blues.max())
            }
        }

        println("Answer to 2.$part is ${possibleGames.sum()}")
    }

    private fun maxValueOrZero(list: List<Int>): Int {
        if (list.maxOrNull() == null) return 0
        return list.max()
    }
}