package robson.jdbc.exemplos.java.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Db {
    
    private static Connection conn = null;

    public static Connection getConn() {
        if (conn == null) {
            try {
                Properties prop = loadProperties();
                String url = prop.getProperty("dburl");
                conn = DriverManager.getConnection(url, prop);
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        } 
        return conn;
    }

    public static void closeConn(){
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        } 
    }

    private static Properties loadProperties(){
        try (FileInputStream fs = new FileInputStream("src\\db.properties")){
            Properties prop = new Properties();
            prop.load(fs);
            return prop;
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
               st.close();
            } catch (SQLException e) {
               throw new DbException(e.getMessage());
            }
        }
		
	}

	public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
               throw new DbException(e.getMessage());
            }
        }
		 
		
	}


/* Teste para visualizar os dados do arquivo db.properties
    public static void main(String[] args) {
        String user = loadProperties().getProperty("user");
        String password = loadProperties().getProperty("password");
        String dburl = loadProperties().getProperty("dburl");

        System.out.println(user +"\n"
                            + password  +"\n"
                            + dburl  +"\n");
    }*/
}
