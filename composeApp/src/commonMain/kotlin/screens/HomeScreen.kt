package screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import model.Todo
import widgets.TodoItem

@Composable
fun HomeScreen() {
    var todos by remember { mutableStateOf(Todo.todoList().toMutableList()) }
    var newTodoText by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        // Search bar
        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Search") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("All ToDos", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(8.dp))

        // List of todos
        LazyColumn {
            items(todos) { todo ->
                TodoItem(
                    todo = todo,
                    onToggle = {
                        todos = todos.map {
                            if (it.id == todo.id) it.copy(isDone = !it.isDone) else it
                        }.toMutableList()
                    },
                    onDelete = {
                        todos = todos.filter { it.id != todo.id }.toMutableList()
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Add new todo
        Row {
            OutlinedTextField(
                value = newTodoText,
                onValueChange = { newTodoText = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text("Add a new todo") }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                if (newTodoText.isNotBlank()) {
                    todos = (todos + Todo(
                        id = (todos.size + 1).toString(),
                        todoText = newTodoText
                    )) as MutableList<Todo>
                    newTodoText = ""
                }
            }) {
                Text("+")
            }
        }
    }
}