/**
 *
 * @author A.M.D.Wijerathna
 * @date 02-23-2014
 */
package bookshop;

public interface IBinaryNode
{
    	//Get element
	public Book element();
	//Set element
	public void setElement(Book newBook);
	//return the left child
	public Book left();
	//check whether node has a left child
	public boolean hsaLeft();
	//return the right child
	public Book right();
	//check whether node has a right child
	public boolean hasRight();
	//check whether node is a leaf node 
	public boolean isLeaf();
}