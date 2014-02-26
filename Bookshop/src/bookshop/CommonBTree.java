/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookshop;

/**
 *
 * @author Samsung rasika
 */
public class CommonBTree {
public static BooksTree bookTree = new BooksTree();
   
   public static void refreshCommonBTree()
   {
       DBConnection con=new DBConnection();
       //con.stm = DBConnection.connection.Pre
       Book b = new Book();
       //bookTree.addNode(isbn, null, null, null);
   }
}
