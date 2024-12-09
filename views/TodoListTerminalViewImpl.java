package todoapp.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import todoapp.entities.TodoList;
import todoapp.services.TodoListService;

import java.util.Scanner;
import java.util.List;

@Component
public class TodoListViewImpl implements TodoListView {

    private final TodoListService todoListService;
    private final Scanner scanner = new Scanner(System.in);

    @Autowired
    public TodoListViewImpl(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @Override
    public void displayMenu() {
        boolean running = true;

        while (running) {
            System.out.println("\n=== Marketplace Akun Game ===");
            System.out.println("1. Tampilkan Daftar Akun Game");
            System.out.println("2. Tambah Akun Game");
            System.out.println("3. Hapus Akun Game");
            System.out.println("4. Edit Akun Game");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1" -> showTodoList();
                case "2" -> addTodo();
                case "3" -> removeTodo();
                case "4" -> editTodo();
                case "5" -> {
                    System.out.println("Terima kasih telah menggunakan aplikasi!");
                    running = false;
                }
                default -> System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
    }

    @Override
    public void showTodoList() {
        List<TodoList> todos = todoListService.getTodoList();
        System.out.println("\n=== Daftar Akun Game ===");
        if (todos.isEmpty()) {
            System.out.println("Tidak ada akun game dalam daftar.");
        } else {
            for (TodoList todo : todos) {
                System.out.println(todo.getId() + ". " + todo.getTodo());
            }
        }
    }

    @Override
    public void addTodo() {
        System.out.println("\n=== Tambah Akun Game ===");
        System.out.print("Masukkan nama akun game: ");
        String todo = scanner.nextLine();
        todoListService.addTodoList(todo);
        System.out.println("Akun game berhasil ditambahkan!");
    }

    @Override
    public void removeTodo() {
        System.out.println("\n=== Hapus Akun Game ===");
        System.out.print("Masukkan ID akun game yang ingin dihapus: ");
        String input = scanner.nextLine();

        try {
            int id = Integer.parseInt(input);
            boolean isSuccess = todoListService.removeTodoList(id);
            if (isSuccess) {
                System.out.println("Akun game berhasil dihapus!");
            } else {
                System.out.println("ID tidak ditemukan.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input ID tidak valid.");
        }
    }

    @Override
    public void editTodo() {
        System.out.println("\n=== Edit Akun Game ===");
        System.out.print("Masukkan ID akun game yang ingin diedit: ");
        String inputId = scanner.nextLine();

        try {
            int id = Integer.parseInt(inputId);
            System.out.print("Masukkan nama baru untuk akun game: ");
            String newTodo = scanner.nextLine();
            boolean isSuccess = todoListService.editTodoList(id, newTodo);

            if (isSuccess) {
                System.out.println("Akun game berhasil diperbarui!");
            } else {
                System.out.println("ID tidak ditemukan.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input ID tidak valid.");
        }
    }
}