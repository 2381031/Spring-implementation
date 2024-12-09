package todoapp.repositories;

import todoapp.entities.TodoList;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TodoListRepositoryImpl implements TodoListRepository {
    private List<TodoList> todoListDb = new ArrayList<>();

    @Override
    public List<TodoList> getAll() {
        return todoListDb;
    }

    @Override
    public void add(TodoList todoList) {
        todoListDb.add(todoList);
    }

    @Override
    public boolean remove(Integer id) {
        return todoListDb.removeIf(todo -> todo.getId().equals(id));
    }

    @Override
    public boolean edit(TodoList todoList) {
        for (TodoList existingTodo : todoListDb) {
            if (existingTodo.getId().equals(todoList.getId())) {
                existingTodo.setTodo(todoList.getTodo());
                return true;
            }
        }
        return false;
    }
}