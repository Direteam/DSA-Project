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
    public ResultSet rst;

    public DBConnection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop", "root", "");
            stm = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        }
        catch(ClassNotFoundException ex)
        {}
        catch (Exception ex)
        {}
    }
    
    public void closedDB()
    {
        try 
        {
            connection.close();
        }
        catch (Exception ex)
        {}
    }
}
