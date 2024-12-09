package todoapp;

import todoapp.config.Database;
import todoapp.repositories.TodoListRepository;
import todoapp.repositories.TodoListRepositoryDbImpl;
import todoapp.services.TodoListService;
import todoapp.services.TodoListServiceImpl;
import todoapp.views.TodoListTerminalViewImpl;
import todoapp.views.TodoListView;

public class Main {
    public static void main(String[] args) {
        // Konfigurasi database
        Database database = new Database("marketplace_db", "root", "password", "localhost", "3306");
        database.setup(); // Membuka koneksi ke database

        // Repository: Menghubungkan ke implementasi database
        TodoListRepository todoListRepository = new TodoListRepositoryDbImpl(database);

        // Service: Menyediakan logika untuk fitur aplikasi
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        // View: Menampilkan antarmuka terminal kepada pengguna
        TodoListView todoListView = new TodoListTerminalViewImpl(todoListService);

        // Menjalankan aplikasi
        todoListView.run();
    }
}