package todoapp.services;

import todoapp.entities.TodoList;

import java.util.List;

public interface TodoListService {
    List<TodoList> getTodoList();
    void addTodoList(String todo);
    Boolean removeTodoList(Integer id);
    Boolean editTodoList(Integer id, String newTodo);
}