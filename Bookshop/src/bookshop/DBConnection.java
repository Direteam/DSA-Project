/*
 * @author Kapthura
 */
package bookshop;

import java.sql.*;
import java.sql.Connection;

class DBConnection
{
    public static Connection connection;
    public Statement stm;

    public DBConnection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop", "root", "");
        }
        catch(ClassNotFoundException ex)
        {}
        catch (Exception ex)
        {
            System.out.println("Error: DB Initiae failed!");
        }
    }
    
    public void ConnectDB(String query)
    {
        try
        {
            stm = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        }
        catch (Exception ex)
        {
            System.out.println("Error: DB Connection failed!");
        }
    }
    
    public void closedDB()
    {
        try 
        {
            connection.close();
        }
        catch (Exception ex)
        {
            System.out.println("Error: DB Close failed!");
        }
    }
}
