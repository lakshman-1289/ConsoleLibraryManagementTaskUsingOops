package LibraryManagementSystem;
public class Book {
	//Attributes - title,author,ISBN and availability status
	private String title;
	private String author;
	private String ISBN;
	private boolean status;
	
   //ALL SETTERS AND GETTERS
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	//I am using this method for just wanna include overloading concept in task
	//And i am using this method also to perform some task
	public String getTitle(String nothing)  
	{ 
		return title;
	}

}
