package todoapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todoapp.entities.TodoList;
import todoapp.repositories.TodoListRepository;

import java.util.List;

@Service
public class TodoListServiceImpl implements TodoListService {

    private final TodoListRepository todoListRepository;

    @Autowired
    public TodoListServiceImpl(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public List<TodoList> getTodoList() {
        return todoListRepository.getAll();
    }

    @Override
    public void addTodoList(String todo) {
        TodoList newTodo = new TodoList();
        newTodo.setTodo(todo);
        todoListRepository.add(newTodo);
    }

    @Override
    public Boolean removeTodoList(Integer id) {
        return todoListRepository.remove(id);
    }

    @Override
    public Boolean editTodoList(Integer id, String newTodo) {
        TodoList todoToEdit = new TodoList();
        todoToEdit.setId(id);
        todoToEdit.setTodo(newTodo);
        return todoListRepository.edit(todoToEdit);
    }
}