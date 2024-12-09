package todoapp.repositories;

import todoapp.entities.TodoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class TodoListRepositoryDbImpl implements TodoListRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<TodoList> getAll() {
        String sql = "SELECT * FROM todo_list";  // Pastikan nama tabel sesuai dengan yang ada di database
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            TodoList todo = new TodoList();
            todo.setId(rs.getInt("id"));
            todo.setTodo(rs.getString("todo"));
            return todo;
        });
    }

    @Override
    public void add(TodoList todoList) {
        String sql = "INSERT INTO todo_list (todo) VALUES (?)";  // Sesuaikan dengan kolom tabel
        jdbcTemplate.update(sql, todoList.getTodo());
    }

    @Override
    public boolean remove(Integer id) {
        String sql = "DELETE FROM todo_list WHERE id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }

    @Override
    public boolean edit(TodoList todoList) {
        String sql = "UPDATE todo_list SET todo = ? WHERE id = ?";
        return jdbcTemplate.update(sql, todoList.getTodo(), todoList.getId()) > 0;
    }
}