/*
 * @author Kapthura
 */
package bookshop;

 import java.sql.*;
import java.sql.Connection;

class DBConnection
{
    public static Connection connection;
    Statement stm;

    public void InitiateDB()
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
        InitiateDB();
        try
        {
            stm = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stm.executeQuery(query);
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
