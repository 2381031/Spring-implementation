package todoapp.repositories;

import todoapp.entities.TodoList;
import java.util.List;

public interface TodoListRepository {
    List<TodoList> getAll();
    void add(TodoList todoList);
    boolean remove(Integer id);
    boolean edit(TodoList todoList);
}