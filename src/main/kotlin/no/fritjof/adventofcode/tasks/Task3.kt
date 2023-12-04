package no.fritjof.adventofcode.tasks

import no.fritjof.adventofcode.util.FileUtil.getTaskFile

object Task3 {

    private var validNumbersPartTwo: MutableList<PartTwoAnswer> = mutableListOf()

    fun getAnswerForTask3() {
        part(1)
        part(2)
    }

    private fun part(part: Int) {
        val file = getTaskFile("3-1")
        val matrix = mutableListOf<MutableList<Char>>()
        for (line: String in file.readLines()) matrix.add(line.toCharArray().toMutableList())

        var validNumbers = mutableListOf<Int>()
        for (row in 0..<matrix[0].size) {
            for (column in 0..<matrix[row].size) {
                val currentChar = matrix[row][column]
                if (currentChar.isDigit()) {
                    if (part == 1) {
                        if (checkNeighbours(matrix, row, column, part) as Boolean) {
                            validNumbers.add(getNumber(matrix, row, column))
                        }
                    } else {
                        val starPosition = checkNeighbours(matrix, row, column, part) as String
                        if (starPosition != "") {
                            validNumbersPartTwo.add(
                                    PartTwoAnswer(
                                            validNumber = getNumber(matrix, row, column),
                                            starPosition = starPosition)
                            )
                        }
                    }
                }
            }
        }

        if (part == 1)
            println("Answer to 3.1 is ${validNumbers.sum()}")
        else {
            validNumbers = mutableListOf()
            val sortedList = validNumbersPartTwo.sortedWith(compareBy { it.starPosition })
            for (index in 0..<sortedList.size - 1) {
                if (index + 1 < sortedList.size
                        && sortedList[index].starPosition == sortedList[index + 1].starPosition) {
                    if (index + 2 < sortedList.size) {
                        if (sortedList[index].starPosition != sortedList[index + 2].starPosition) {
                            validNumbers.add((sortedList[index].validNumber * sortedList[index + 1].validNumber))
                        }
                    } else {
                        validNumbers.add((sortedList[index].validNumber * sortedList[index + 1].validNumber))
                    }
                }
            }
            println("Answer to 3.2 is ${validNumbers.sum()}") // 3586917 too low
        }
    }

    private fun checkNeighbours(matrix: MutableList<MutableList<Char>>, row: Int, column: Int, part: Int): Any {
        // Check north
        if (row > 0) {
            val northernNeighbor = matrix[row - 1][column]
            if (northernNeighbor != '.' && !northernNeighbor.isDigit()) {
                return if (part == 1) true
                else if (northernNeighbor == '*') "${row - 1};${column}" else ""
            }

            // Check diagonally north right
            if ((column + 1) < matrix[column].size && !matrix[row][column + 1].isDigit()) {
                val diagonalNeighbor = matrix[row - 1][column + 1]
                if (diagonalNeighbor != '.' && !diagonalNeighbor.isDigit()) {
                    return if (part == 1) true
                    else if (diagonalNeighbor == '*') "${row - 1};${column + 1}" else ""
                }
            }

            // Check diagonally north left
            if ((column - 1) >= 0 && !matrix[row][column - 1].isDigit()) {
                val diagonalNeighbor = matrix[row - 1][column - 1]
                if (diagonalNeighbor != '.' && !diagonalNeighbor.isDigit()) {
                    return if (part == 1) true
                    else if (diagonalNeighbor == '*') "${row - 1};${column - 1}" else ""
                }
            }
        }

        // Check south
        if (row + 1 < matrix[row].size) {
            val southernNeighbor = matrix[row + 1][column]
            if (southernNeighbor != '.' && !southernNeighbor.isDigit()) {
                return if (part == 1) true
                else if (southernNeighbor == '*') "${row + 1};${column}" else ""
            }

            // Check diagonally south right
            if ((column + 1) < matrix[column].size && !matrix[row][column + 1].isDigit()) {
                val diagonalNeighbor = matrix[row + 1][column + 1]
                if (diagonalNeighbor != '.' && !diagonalNeighbor.isDigit()) {
                    return if (part == 1) true
                    else if (diagonalNeighbor == '*') "${row + 1};${column + 1}" else ""
                }
            }
            // Check diagonally south left
            if ((column - 1) >= 0 && !matrix[row][column - 1].isDigit()) {
                val diagonalNeighbor = matrix[row + 1][column - 1]
                if (diagonalNeighbor != '.' && !diagonalNeighbor.isDigit()) {
                    return if (part == 1) true
                    else if (diagonalNeighbor == '*') "${row + 1};${column - 1}" else ""
                }
            }

        }

        // Check west
        if (column > 0) {
            val westernNeighbor = matrix[row][column - 1]
            if (westernNeighbor != '.' && !westernNeighbor.isDigit()) {
                return if (part == 1) true
                else if (westernNeighbor == '*') "${row};${column - 1}" else ""
            }
        }

        // Check east
        if (column + 1 < matrix[column].size) {
            val easternNeighbor = matrix[row][column + 1]
            if (easternNeighbor != '.' && !easternNeighbor.isDigit()) {
                return if (part == 1) true
                else if (easternNeighbor == '*') "${row};${column + 1}" else ""
            }
        }

        return if (part == 1) false else ""
    }

    private fun getNumber(matrix: MutableList<MutableList<Char>>, row: Int, column: Int): Int {
        var left = 0
        var right = 0
        var startIndex = 0
        var endIndex = 0
        while (column - left >= 0) {
            if (matrix[row][column - left].isDigit()) {
                startIndex = column - left
                left++
            } else {
                break
            }
        }
        while (column + right <= matrix[column].size) {
            if (matrix[row][column + right].isDigit()) {
                endIndex = column + right
                right++
            } else {
                break
            }
        }
        var validNumber = ""
        for (numbers in startIndex..endIndex) {
            validNumber += matrix[row][numbers]
        }
        return validNumber.toInt()
    }
}

class PartTwoAnswer(
        var validNumber: Int,
        var starPosition: String
)
