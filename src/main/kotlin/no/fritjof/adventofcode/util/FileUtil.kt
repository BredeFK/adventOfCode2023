package no.fritjof.adventofcode.util

object FileUtil {

    fun getTaskFile(taskNumber: Int): String {
        return "${System.getProperty("user.dir")}/src/main/resources/task$taskNumber.txt"
    }
}