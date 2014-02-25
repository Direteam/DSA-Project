/*
 * @author himal
 */
package bookshop;

class BooksTree
{    
    Book  rootBook = null;
    
    public void addNode(int isbn, String bookTitle,String authorName,String authorSurname)
    {
       Book newBook = new Book(bookTitle,authorName,authorSurname,isbn);
       if(rootBook == null)
          rootBook = new Book(newBook);
       else
       {   
	   Book fBookNode = rootBook;  
	   Book parentBook;
           while (true)
           {
               parentBook = fBookNode;
               if (isbn < fBookNode.isbn)
               {
                    fBookNode = fBookNode.leftChild;    
                    if (fBookNode == null)
                    {
                         parentBook.leftChild = newBook;
                         return;
                    }
               }
               else
               {
                    fBookNode = fBookNode.rightChild;
                    if (fBookNode == null)
                    {
                        parentBook.rightChild = newBook;
                        return;
                    }
               }
           }
        }        
    }
      
    public void inOrderTraverseTree(Book book)
    {
        if (book != null)
        {
	    preorderTraverseTree(book.leftChild);
            System.out.println(book);
            preorderTraverseTree(book.rightChild);
        }
    }

    public void preorderTraverseTree(Book book)
    {
        if (book != null)
        {
            System.out.println(book);
            preorderTraverseTree(book.leftChild);
            preorderTraverseTree(book.rightChild);
        }
    }
    
    public void postOrderTraverseTree(Book book)
    {	 
        if (book != null)
        { 
            preorderTraverseTree(book.leftChild);
            preorderTraverseTree(book.rightChild);
            System.out.println(book);
	}
    }

    public Book findBook(int iSBN)
    {
	        // Start at the top of the tree
        Book fBookNode = rootBook;
	 
	        // While we haven't found the Node        // keep looking	 
	        while (fBookNode.isbn != iSBN) {
	 
	            // If we should search to the left
	 
	            if (iSBN < fBookNode.isbn) {
	 
	                // Shift the focus Node to the left child
	 
	                fBookNode = fBookNode.leftChild;
	 
	            } else {
	 
	                // Shift the focus Node to the right child
	 
	                fBookNode = fBookNode.rightChild;
	 
	            }
	 
	            // The node wasn't found
 
	            if (fBookNode == null)
	                return null;
	 
	        }	 
	        return  fBookNode;
            }
 
    public boolean Bookremove(int iSBN) {
                Book fBookNode = rootBook;
	        Book  parent = rootBook;
                  boolean isItALeftChild = true;
	
	        while (fBookNode.isbn != iSBN) {
	 
	            parent = fBookNode;
	 
	            // If we should search to the left
	 
	            if (iSBN < fBookNode.isbn) {
	 
	                isItALeftChild = true;
	 
	                // Shift the focus Node to the left child
	 
                fBookNode = fBookNode.leftChild;
	 
	            } else {
	 
	                // Greater than focus node so go to the right
	 
	                isItALeftChild = false;
	 
                // Shift the focus Node to the right child
	 
	                fBookNode = fBookNode.rightChild;
	 
	            }
 
	            // The node wasn't found
	 
	            if (fBookNode == null)
	                return false;
	 
	        }
	 
	        // If Node doesn't have children delete it
	 	        if (fBookNode.leftChild == null && fBookNode.rightChild == null)
                        {
	            // If root delete it
	            if (fBookNode == rootBook)
	                rootBook = null;
	            // If it was marked as a left child
	            // of the parent delete it in its parent
	            else if (isItALeftChild)
	                parent.leftChild = null;
	            // Vice versa for the right child
	            else
	                parent.rightChild = null;
	        }
	        // If no right child
	        else if (fBookNode.rightChild == null)
                { 
	            if (fBookNode == rootBook)
	                rootBook = fBookNode.leftChild;
	            else if (isItALeftChild)
	                parent.leftChild = fBookNode.leftChild;
	 	            
	            else
	                parent.rightChild = fBookNode.leftChild;
	        }
	        // If no left child
	        else if (fBookNode.leftChild == null)
                {
	            if (fBookNode == rootBook)
	                rootBook = fBookNode.rightChild;
	 	    else if (isItALeftChild)
	                parent.leftChild = fBookNode.rightChild;
                    else
	                parent.rightChild = fBookNode.rightChild;
	        }
	        else
                {
	            Book replacement = getReplacementBook(fBookNode);
	            if (fBookNode == rootBook)
	                rootBook = (Book) replacement;
	            else if (isItALeftChild)
	                parent.leftChild = (Book) replacement;
	            else
	                parent.rightChild = (Book) replacement;
	            replacement.leftChild = fBookNode.leftChild;
                }
        return false;
    }
             
    private Book getReplacementBook(Book replacedNode)
    {
         Book replacementParent = replacedNode;
	        Book replacement = replacedNode;
	        Book focusNode = replacedNode.rightChild;
	        while (focusNode != null)
                {
	 	    replacementParent = replacement;
	            replacement = focusNode;
	            focusNode = focusNode.leftChild;
	        } 
	        if (replacement != replacedNode.rightChild) {
	            replacementParent.leftChild = replacement.rightChild;
	            replacement.rightChild = replacedNode.rightChild;
                }
        return replacement;   
    }
}
    


