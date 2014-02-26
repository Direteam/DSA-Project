package bookshop;

import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

class Connection
{
    ResultSet rs;
    Statement stm;  
    Connection connection;
    
   public void connect(JTable myTable) throws ClassNotFoundException, SQLException
   {
        ResultSet resultSet = stm.executeQuery("SELECT * FROM book_details");
        java.sql.ResultSetMetaData rstmt=  resultSet.getMetaData();
        int Colums = rstmt.getColumnCount();
        System.out.println(Colums);
         DefaultTableModel dtb = new DefaultTableModel();
         Vector Colums_num = new Vector();
         Vector data_rows = new Vector();
         for(int i=1;i<(Colums+1);i++)
         {
             Colums_num.addElement(rstmt.getColumnName(i));
         }
         dtb.setColumnIdentifiers(Colums_num);
         while(resultSet.next())
         {
             data_rows = new Vector();
               for(int j=1;(j<Colums+1);j++)
               {
                   data_rows.addElement(resultSet.getString(j));
               }
                dtb.addRow(data_rows);         
         }
         myTable.setModel(dtb);   
    }
}
