package LibraryManagementSystem;
/*INTERFACE ==> To make main class should perform all functionalities present in interface */
public interface PerformTasks {
	void addBook(String title,String author,String ISBN);
	void availableBooks();
	void borrowedBooks();
	void borrow(String name,String id,String title);
	void returnBook(String id, String title);
	void allMembers();
}
