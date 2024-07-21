package LibraryManagementSystem;
/*
Purpose to make it as abstract class ==> NO ONE CAN DIRECTLY ACCESS DATA IN LIBRARY
											BY USING LIBRARY OBJECT
*/
public abstract class Library {
	//Array of Books and BorrowedMembers (data is secured)
	private static Book[] books = new Book[100];
	private static Member[] members = new Member[100];
	
	//getter to access library books
	public Book[] getBooks() {
		return books;
	}
	//getter to access borrowed members
		public Member[] getMembers() {
			return members;
	}
		
	//setter to add each book element into array
	public void setBooks(Book bobj,int i) {
		books[i] = bobj;
	}
	//setter to add each borrowed member into array
	public void setMembers(Member mobj,int i ) {
		members[i] = mobj;
	}
	
}
