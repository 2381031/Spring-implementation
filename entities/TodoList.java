package todoapp.entities;

public class TodoList {
    private Integer id;
    private String todo;

    // Konstruktor kosong
    public TodoList() {
    }

    // Konstruktor dengan parameter
    public TodoList(Integer id, String todo) {
        this.id = id;
        this.todo = todo;
    }

    // Getter untuk id
    public Integer getId() {
        return id;
    }

    // Setter untuk id
    public void setId(Integer id) {
        this.id = id;
    }

    // Getter untuk todo
    public String getTodo() {
        return todo;
    }

    // Setter untuk todo
    public void setTodo(String todo) {
        this.todo = todo;
    }

    @Override
    public String toString() {
        return "TodoList{id=" + id + ", todo='" + todo + "'}";
    }
}