/*
 * @author A.M.D.Wijerathna
 * @date 02-23-2014
 */
package bookshop;

class Book implements IBinaryNode {

    //Book class Fields
    private String bookTitle, authorName, authorSurname;
    int isbn;
    //Left Child and Right Child
    Book leftChild, rightChild;
    
    //Default Constructor for the Book Class
    public Book()
    {
	bookTitle = authorName = authorSurname = null;
	isbn = 0;
        leftChild = null;
        rightChild = null;
    }
    
    //Parameterized Constructors for the Book Class
    public Book(String bookTitle,String authorName,String authorSurname,int isbn)
    {
	this.bookTitle = bookTitle;
        this.authorName =authorName;
        this.authorSurname = authorSurname;
	this.isbn = isbn;
        this.leftChild = null;
        this.rightChild = null;
    }
    
    public Book(Book newBook)
    {
	this.bookTitle = newBook.bookTitle;
        this.authorName = newBook.authorName;
        this.authorSurname = newBook.authorSurname;
	this.isbn = newBook.isbn;
        this.leftChild = newBook.leftChild;
        this.rightChild = newBook.rightChild;
    }
    
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
}