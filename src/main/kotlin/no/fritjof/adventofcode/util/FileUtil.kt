package no.fritjof.adventofcode.util

import java.io.File

object FileUtil {

    fun getTaskFileName(taskNumber: String): String {
        return "${System.getProperty("user.dir")}\\src\\main\\resources\\task$taskNumber.txt"
    }

    fun getTaskFile(taskNumber: String): File {
        val fileName = getTaskFileName(taskNumber)
        if (File(fileName).exists()) {
            return File(fileName)
        } else {
            error("Could not find file at path '$fileName'")
        }
    }
}