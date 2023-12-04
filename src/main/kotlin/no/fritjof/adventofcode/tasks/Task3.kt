package no.fritjof.adventofcode.tasks

import no.fritjof.adventofcode.util.FileUtil.getTaskFile

object Task3 {

    fun getAnswerForTask3() {
        part(1)
    }

    private fun part(part: Int) {
        val file = getTaskFile("3-$part")
        val matrix = mutableListOf<MutableList<Char>>()
        for (line: String in file.readLines()) matrix.add(line.toCharArray().toMutableList())

        val validNumbers = mutableListOf<Int>()
        for (row in 0..<matrix[0].size) {
            for (column in 0..<matrix[row].size) {
                val currentChar = matrix[row][column]
                if (currentChar.isDigit()) {
                    if (checkNeighbours(matrix, row, column)) {
                        validNumbers.add(getNumber(matrix, row, column))
                    }
                }
            }
        }

        println("Answer to 3.$part is ${validNumbers.sum()}")
    }

    private fun checkNeighbours(matrix: MutableList<MutableList<Char>>, row: Int, column: Int): Boolean {
        // Check north
        if (row > 0) {
            val northernNeighbor = matrix[row - 1][column]
            if (northernNeighbor != '.' && !northernNeighbor.isDigit()) {
                return true
            }

            // Check diagonally north right
            if ((column + 1) < matrix[column].size && !matrix[row][column + 1].isDigit()) {
                val diagonalNeighbor = matrix[row - 1][column + 1]
                if (diagonalNeighbor != '.' && !diagonalNeighbor.isDigit()) {
                    return true
                }
            }

            // Check diagonally north left
            if ((column - 1) >= 0 && !matrix[row][column - 1].isDigit()) {
                val diagonalNeighbor = matrix[row - 1][column - 1]
                if (diagonalNeighbor != '.' && !diagonalNeighbor.isDigit()) {
                    return true
                }
            }
        }

        // Check south
        if (row + 1 < matrix[row].size) {
            val southernNeighbor = matrix[row + 1][column]
            if (southernNeighbor != '.' && !southernNeighbor.isDigit()) {
                return true
            }

            // Check diagonally south right
            if ((column + 1) < matrix[column].size && !matrix[row][column + 1].isDigit()) {
                val diagonalNeighbor = matrix[row + 1][column + 1]
                if (diagonalNeighbor != '.' && !diagonalNeighbor.isDigit()) {
                    return true
                }
            }
            // Check diagonally south left
            if ((column - 1) >= 0 && !matrix[row][column - 1].isDigit()) {
                val diagonalNeighbor = matrix[row + 1][column - 1]
                if (diagonalNeighbor != '.' && !diagonalNeighbor.isDigit()) {
                    return true
                }
            }

        }

        // Check west
        if (column > 0) {
            val westernNeighbor = matrix[row][column - 1]
            if (westernNeighbor != '.' && !westernNeighbor.isDigit()) {
                return true
            }
        }

        // Check east
        if (column + 1 < matrix[column].size) {
            val easternNeighbor = matrix[row][column + 1]
            if (easternNeighbor != '.' && !easternNeighbor.isDigit()) {
                return true
            }
        }


        return false
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