package tasklist
import kotlinx.datetime.*


val reminder = mutableListOf<String>()
const val SINGLE_DIGITS = 9
enum class Priority{
    C, H, N, L
}
fun main() {
    // write your code here
    while(true){
        println("Input an action (add, print, end):")
        when(readln().lowercase()){
            "add" -> addTask()
            "print" -> printTasks()
            "end" -> break
            else -> println("The input action is invalid")
        }
    }
    println("Tasklist exiting!")


}

fun printTasks() {
    if (reminder.isEmpty()) {
        println("No tasks have been input")
    } else {
        for (index in reminder.indices) {
            var suffix = "${index + 1} "
            if (index + 1 <= SINGLE_DIGITS) suffix += " "
            val reminderLines = reminder[index].split("\n") // split reminder into lines
            println(suffix + reminderLines[0]) // print the first line with the index and suffix
            for (lineIndex in 1 until reminderLines.size) {
                val indent = " ".repeat(suffix.length) // calculate the indentation based on the length of suffix
                println(indent + reminderLines[lineIndex]) // print the rest of the lines with indentation
            }
        }
    }
}

fun addTask() {
    var priority: Priority? = null
    while(priority == null){
        println("Input the task priority (C, H, N, L):")
        try {
            priority = Priority.valueOf(readln())
        }catch(e: IllegalArgumentException){}
    }
    println("Input the date (yyyy-mm-dd):")
    val date = readln()

    println("Input a new task (enter a blank line to end):")
    val task = mutableListOf<String>()
    while(true){
        val userInput = readln().trimIndent()
        if(userInput.isEmpty())break
        task.add(userInput)

    }
    if(task.isEmpty()) {
        println("The task is blank")
        return
    }
    reminder.add(task.joinToString(separator = "\n") {it})

}


