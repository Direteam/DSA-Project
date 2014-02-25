/*
 * @author Kapthura
 */
package bookshop;

 import java.sql.*;

class DBConnection {
     java.sql.Connection connection;
    Statement stm;

    public void Connectdrivermanager() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: unable to load driver class!");

        }
    }

    public void InitiateDB() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop", "root", "");
        } catch (Exception ex) {
            System.out.println("Error: DB Initiae failed!");
        }

    }

    public void ConnectDB(String query) {
        Connectdrivermanager();
        InitiateDB();
        try {
            stm = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stm.executeQuery(query);
        } catch (Exception ex) {
            System.out.println("Error: DB Connection failed!");
        }
    }

    public void closedDB() {
        try {
            connection.close();
        } catch (Exception e) {
            System.out.println("Error: DB Close failed!");
        }

    }
}
