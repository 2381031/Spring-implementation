package todoapp.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private final String dbName;
    private final String userName;
    private final String password;
    private final String host;
    private final String port;
    private Connection connection;

    // Konstruktor untuk menyimpan parameter koneksi database
    public Database(final String dbName, final String userName, final String password, final String host, final String port) {
        this.dbName = dbName;
        this.userName = userName;
        this.password = password;
        this.host = host;
        this.port = port;
    }

    // Method untuk mendapatkan koneksi
    public Connection getConnection() {
        return connection;
    }

    // Method untuk mengatur koneksi ke database
    public void setup() {
        // Template URL koneksi MySQL
        String mysqlConnUrlTemplate = "jdbc:mysql://%s:%s/%s";

        try {
            // Mendaftarkan driver MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Membuka koneksi ke database
            connection = DriverManager.getConnection(
                    String.format(mysqlConnUrlTemplate, host, port, dbName),
                    userName,
                    password
            );
            // Menampilkan pesan bahwa koneksi berhasil
            System.out.println("Database connected!");
        } catch (SQLException | ClassNotFoundException e) {
            // Menangani exception jika ada masalah dengan koneksi
            throw new RuntimeException("Database connection failed", e);
        }
    }
}