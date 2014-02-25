/*
 * @author himal
 */
package bookshop;
public class BooksTree
{    
    Book  root = null;
    
    public void addNode(int isbn, String bookTitle,String authorName,String authorSurname)
    {
       Book bk=new Book( isbn,  bookTitle , authorName ,  authorSurname);
       if(root==null)
          root = bk;
       else
       {   
	   Book fBookNode = root;  
	   Book parent;
                  
           while (true)
           {
                parent = fBookNode;
                parent = fBookNode;
               if (isbn < fBookNode.isbn)
               {
                    fBookNode = fBookNode.leftChild;    
                    if (fBookNode == null)
                    {
                         parent.leftChild = bk;
                         return;
                    }
               }
               else
               {
                       fBookNode = fBookNode.rightChild;
                       if (fBookNode == null) {
                           parent.rightChild = bk;
                            return;
                       }
                   }
             }
                  }
	          
          }
      
       public void inOrderTraverseTree(Book fBookNode) {
	 
	        if (fBookNode != null) {
	 
	           
	 
            preorderTraverseTree(fBookNode.leftChild);
 
         
 
            System.out.println(fBookNode);
	 
	          
 
	            preorderTraverseTree(fBookNode.rightChild);
	 
	        }

      }
       
       
       

    public void preorderTraverseTree(Book fBookNode) {
        
	 
	        if (fBookNode != null) {
	 
	            System.out.println(fBookNode);
	 
	            preorderTraverseTree(fBookNode.leftChild);
	            preorderTraverseTree(fBookNode.rightChild);
	 	        }
 	    }
    
    
      public void postOrderTraverseTree(Book focusNode) {
	 
	        if (focusNode != null) {
	 
	            preorderTraverseTree(focusNode.leftChild);
	            preorderTraverseTree(focusNode.rightChild);
	 
                      System.out.println(focusNode);
	 
	        }
	 
	    }


  	    public Book findBook(int key) {
	 
	        // Start at the top of the tree
	 
	        Book fBookNode = root;
	 
	        // While we haven't found the Node        // keep looking	 
	        while (fBookNode.isbn != key) {
	 
	            // If we should search to the left
	 
	            if (key < fBookNode.isbn) {
	 
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

            
             public boolean Bookremove(int key) {
                Book fBookNode = root;
	        Book  parent = root;
                  boolean isItALeftChild = true;
	
	        while (fBookNode.isbn != key) {
	 
	            parent = fBookNode;
	 
	            // If we should search to the left
	 
	            if (key < fBookNode.isbn) {
	 
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
	 	        if (fBookNode.leftChild == null && fBookNode.rightChild == null) {
	 
	            // If root delete it
	 
	            if (fBookNode == root)
	                root = null;
	 
	            // If it was marked as a left child
	            // of the parent delete it in its parent
	 
	            else if (isItALeftChild)
	                parent.leftChild = null;
	 
	            // Vice versa for the right child
	 
	            else
	                parent.rightChild = null;
	 
	        }
	 
	        // If no right child
	 
	        else if (fBookNode.rightChild == null) {
	 
	            if (fBookNode == root)
	                root = fBookNode.leftChild;
	 
	            
	 
	            else if (isItALeftChild)
	                parent.leftChild = fBookNode.leftChild;
	 	            
	            else
	                parent.rightChild = fBookNode.leftChild;
	 
	        }
	 
	        // If no left child
	 
	        else if (fBookNode.leftChild == null) {
	 
	            if (fBookNode == root)
	                root = fBookNode.rightChild;
	 
	 	            else if (isItALeftChild)
	                parent.leftChild = fBookNode.rightChild;
	 
	           
                 else
	                parent.rightChild = fBookNode.rightChild;
	 
	        }
	 
	        
	        else {
	 
	            Book replacement = getReplacementBook(fBookNode);
	 
	          
	 
	            if (fBookNode == root)
	                root = (Book) replacement;
	 
	          
	 
	            else if (isItALeftChild)
	                parent.leftChild = (Book) replacement;
	 
	            
	            else
	                parent.rightChild = (Book) replacement;
	 
	            replacement.leftChild = fBookNode.leftChild;
	 
	        }	 


             return false;
             
             }

    private Book getReplacementBook(Book replacedNode) {
        
         Book replacementParent = replacedNode;
	        Book replacement = replacedNode;
	 
	        Book focusNode = replacedNode.rightChild;
	 
	      
	        while (focusNode != null) {
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
    


