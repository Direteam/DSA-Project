/*
 * @author Kapthura
 */
package bookshop;

import java.sql.*;
import java.sql.Connection;
import javax.swing.JOptionPane;

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
            JOptionPane.showMessageDialog(null, "Database Connected");
        }
        catch(ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, "ClassNotFoundException \n"+ex.toString());
        }
        catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Eror in Connecting Database \n"+ex.toString());
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
            JOptionPane.showMessageDialog(null, "Eror in Closing Database \n"+ex.toString());
        }
    }
}
