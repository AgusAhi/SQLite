import java.sql.*;
// Instalar: Aules>sqlite-jbc-3.7.2.jar
// 4 rallas > project structure libraries > + > añadir | aparecerá en External Libraries
// bd_lina.db: aules > arrastrar al raiz
// Class.forName("org.sqlite.JDBC"); buscar en internet lo que hay dentro para la versión del driver
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        String url = "jdbc:sqlite:bd_lina.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery("SELECT * FROM equipos INNER JOIN zona ON equipos.id_zona = zona.id_zona");
            while (result.next()) {
                System.out.println(result.getInt("id_equipo") + "\t" +
                        result.getString("nombre_equipo") + "\t" +
                        result.getString("nombre_zona"));
            }
            createDatabase("test");

        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

    public static void createDatabase(String name) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        String url = "jdbc:sqlite:" + name + ".db";
        Connection conn = DriverManager.getConnection(url);
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }
}
