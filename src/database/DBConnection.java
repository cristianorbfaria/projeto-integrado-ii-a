package database;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        
        Path currentRelativePath = Paths.get("");
        String currentDirectory = currentRelativePath.toAbsolutePath().toString();

        try (FileInputStream f = new FileInputStream(currentDirectory + "/src/config/db.properties")) {


            Properties pros = new Properties();
            pros.load(f);

            String url = pros.getProperty("db_url");
            String user = pros.getProperty("db_user");
            String password = pros.getProperty("db_password");
            
            conn = DriverManager.getConnection(url, user, password);
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        return conn;
        
    }
    
    public static void destroyConnection(Connection conn) {
    	
        try {
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
    	
    }
	
}
