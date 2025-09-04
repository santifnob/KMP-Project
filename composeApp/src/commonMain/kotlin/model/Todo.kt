package model

data class Todo(
    val id: String,
    val todoText: String,
    val isDone: Boolean = false
) {
    companion object {
        fun todoList(): List<Todo> {
            return listOf(
                Todo(id = "01", todoText = "Buy groceries"),
                Todo(id = "02", todoText = "Walk the dog", isDone = true),
                Todo(id = "03", todoText = "Complete Flutter project"),
                Todo(id = "04", todoText = "Read a book", isDone = true),
                Todo(id = "05", todoText = "Exercise for 30 minutes"),
            )
        }
    }
}