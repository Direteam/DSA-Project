/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bookshop;

/**
 *
 * @author A.M.D.Wijerathna
 * @date 02-23-2014
 */
class Book implements IBinaryNode {

    //Book class Fields
	private String bookTitle, authorName, authorSurname;
	private int isbn;
	
        //Left Child and Right Child
        Book leftChild, rightChild;
        
	//Book class Properties
	public String getBookTitle() {
		return bookTitle;
	}
	
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorSurname() {
		return authorSurname;
	}

	public void setAuthorSurname(String authorSurname) {
		this.authorSurname = authorSurname;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	//Constructor for the Book Class
	public Book()
	{
		bookTitle = authorName = authorSurname = null;
		isbn = 0;
                leftChild = null;
                rightChild = null;
	}
        
    @Override
    public Book element() {
        return this;
    }

    @Override
    public void setElement(Book newBook) {
      this.authorName = newBook.authorName;
      this.authorSurname = newBook.authorSurname;
      this.bookTitle = newBook.bookTitle;
      this.isbn = newBook.isbn;
    }

    @Override
    public Book left() {
        return leftChild;
    }

    @Override
    public boolean hsaLeft() {
        if(leftChild!=null)
            return true;
        else
            return false;
    }

    @Override
    public Book right() {
        return rightChild;
    }

    @Override
    public boolean hasRight() {
        if(rightChild!=null)
            return true;
        else
            return false;
    }

    @Override
    public boolean isLeaf() {
        return (leftChild==null && rightChild==null);
    }

    @Override
    public boolean isRoot() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
