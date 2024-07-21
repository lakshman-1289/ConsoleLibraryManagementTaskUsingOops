package LibraryManagementSystem;

import java.util.Scanner;
//main class to run the program
public class LibraryApp extends Library implements PerformTasks{
	//maintain static index values to add book and borrowedMember into respective arrays
	static int bidx=-1;
	static int midx=-1;
	
	//To add by Default some books exists in Library
	static {
		   	Book book1 = new Book(); 
		   	book1.setTitle("The Great Gatsby");
			book1.setAuthor("F. Scott Fitzgerald");
			book1.setISBN("978-0743273565");
			book1.setStatus(true);
	        Book book2 = new Book();
	        book2.setTitle("To Kill a Mockingbird");
	        book2.setAuthor("Harper Lee");
	        book2.setISBN("978-0061120084");
	        book2.setStatus(true);
	        Book book3 = new Book();
	        book3.setTitle("1984");
	        book3.setAuthor("George Orwell");
	        book3.setISBN("978-0451524935");
	        book3.setStatus(true);
	        Book book4 = new Book();
	        book4.setTitle("Pride and Prejudice");
	        book4.setAuthor("Jane Austen");
	        book4.setISBN("978-0141439518");
	        book4.setStatus(true);
	        Book book5 = new Book();
	        book5.setTitle("The Catcher in the Rye");
	        book5.setAuthor("J.D. Salinger");
	        book5.setISBN("978-0316769488");
	        book5.setStatus(true);
	        Book book6 = new Book();
	        book6.setTitle("Brave New World");
	        book6.setAuthor("Aldous Huxley");
	        book6.setISBN("978-0060850524");
	        book6.setStatus(true);
	        Book book7 = new Book();
	        book7.setTitle("The Hobbit");
	        book7.setAuthor("J.R.R. Tolkien");
	        book7.setISBN("978-0547928227");
	        book7.setStatus(true);
	        Book book8 = new Book();
	        book8.setTitle("The Fellowship of the Ring");
	        book8.setAuthor("J.R.R. Tolkien");
	        book8.setISBN("978-0618346257");
	        book8.setStatus(true);
	        Book book9 = new Book();
	        book9.setTitle("The Alchemist");
	        book9.setAuthor("Paulo Coelho");
	        book9.setISBN("978-0061122415");
	        book9.setStatus(true);
	        Book book10 = new Book();
	        book10.setTitle("Harry Potter and the Sorcerer's Stone");
	        book10.setAuthor("J.K. Rowling");
	        book10.setISBN("978-0590353427");
	        book10.setStatus(true);
	        Library lobj = new LibraryApp();
			lobj.setBooks(book1, ++bidx);
			lobj.setBooks(book2, ++bidx);
			lobj.setBooks(book3, ++bidx);
			lobj.setBooks(book4, ++bidx);
			lobj.setBooks(book5, ++bidx);
			lobj.setBooks(book6, ++bidx);
			lobj.setBooks(book7, ++bidx);
			lobj.setBooks(book8, ++bidx);
			lobj.setBooks(book9, ++bidx);
			lobj.setBooks(book10, ++bidx);
	}
	
	
	//1)Method for Add a book to library
	@Override
	public void addBook(String title,String author,String ISBN) {
		Book newbook = new Book();
		newbook.setTitle(title);
		newbook.setAuthor(author);
		newbook.setISBN(ISBN);
		newbook.setStatus(true);
		Library lobj = new LibraryApp();
		lobj.setBooks(newbook, ++bidx);  //add book into books array
		System.out.println("New Book Added Successfully.....\n");
	}
	
	//2)Method for Display all available books 
	@Override
	public void availableBooks() {
		System.out.println("		All Available Books in Library.................");
		Library lobj = new LibraryApp();
		Book[] arr = lobj.getBooks();
		for(int i=0; i<=bidx; i++) {
			if(arr[i].isStatus() == true)
				System.out.printf("Title:%-30s Author:%-25s ISBN:%-25s\n",arr[i].getTitle("overloaded method"),arr[i].getAuthor(),arr[i].getISBN());
		}
		System.out.println();
	}
	
	//3)Method for Display all borrowed books
	@Override
	public void borrowedBooks() {
		System.out.println("		All Borrowed Books From Library.........");
		Library lobj = new LibraryApp();
		Book[] arr = lobj.getBooks();
		for(int i=0; i<=bidx; i++) {
			if(arr[i].isStatus() == false) {
				System.out.printf("Title:%-30s Author:%-25s ISBN:%-25s\n",arr[i].getTitle(),arr[i].getAuthor(),arr[i].getISBN());
			}
		}
		if(midx==-1) 
			System.out.println("No one borrow any books yet!!!!\n");
		else
			System.out.println();
	}
	
	//4)Method for Allow a member to borrow a book (if available).
	@Override
	public void borrow(String name,String id,String title) {
		Library lobj = new LibraryApp();
		Book[] arr = lobj.getBooks();
		boolean flag1 = false;
		boolean flag2 = false;
		for(int i=0; i<=bidx; i++) {
			if(arr[i].getTitle().equals(title.trim())) {
				flag1=true;
				if(arr[i].isStatus() == true) {
					System.out.println(name+" borrowed the book "+title+"\n");
					flag2= true;
					Member mobj = new Member();
					mobj.setName(name);
					mobj.setId(id);
					mobj.setBorrowbook(title.trim());
					lobj.setMembers(mobj,++midx);
					arr[i].setStatus(false);
				}
			}
		}
		if(flag1 == false) {
			System.out.println("Entered book is not available in Library..");
			System.out.println("First,Please check available books in Library..(PRESS-2)\n");
		}
		else if(flag1==true && flag2 == false) {
			System.out.println("Someone already borrowed this book..");
			System.out.println("First,Please check available books in Library..(PRESS-2)\n");
		}
	}
	
	//5)Method for Allow a member to return a book
	@Override
	public void returnBook(String id, String title) {
		if(midx==-1) 
			System.out.println("Without borrow Book.. What you want to return.... please check\n");
		
		Library lobj = new LibraryApp();
		Member[] marr = lobj.getMembers();
		//deleting borrowed data of person
		boolean flag = false;
		for(int i=0; i<=midx; i++) {
			if(marr[i].getId().equals(id) && marr[i].getBorrowbook().equals(title.trim())) {
				flag = true;
				for(int j=i; j<midx; j++) {
					marr[j]= marr[j+1];
				}
				midx--;
				//make book available in Library
				Book[] arr = lobj.getBooks();
				for(int k=0; k<=bidx; k++) {
					if(arr[k].getTitle().equals(title.trim())) {
						arr[k].setStatus(true);
						break;
					}
				}
			break;
			}
		}
		if(flag == false)
			System.out.println("Data Not Found....(Incorrect Details)\n");
		else {
			System.out.println(title+" book returned by "+id);
			System.out.println(" .....data updated....\n");
		}
	}
	
	//6)Method for Display all members and the books they've borrowed
	@Override
	public void allMembers() {
		System.out.println("		People who Borrowed Books from Library......");
		Library lobj = new LibraryApp();
		Member[] arr = lobj.getMembers();
		for(int i=0; i<=midx; i++) {
			System.out.println(arr[i]);
		}
		if(midx == -1)
			System.out.println("No one holds borrowed books from library!!!\n");
		else
			System.out.println();
	}
	
	public static void main(String[] args) {
		LibraryApp runobj=new LibraryApp();
		while(true) {
		System.out.println("Enter Below specified number to perform that operation......");
		System.out.println("PRESS 1: Add a book to library"
						    +"\nPRESS 2: Display all available books "
						    +"\nPRESS 3: Display all borrowed books"
						    +"\nPRESS 4: Borrow a book"
						    +"\nPRESS 5: Return a book"
						    +"\nPRESS 6: Display all members and the books they've borrowed"
						    +"\nPRESS 7: EXIT"
							);
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
			switch(choice) {
				case 1: System.out.println("Enter book Title: ");
						sc.nextLine();						
						String t = sc.nextLine();
						System.out.println("Enter book Author: ");
						String a = sc.nextLine();
						System.out.println("Enter ISBN of book: ");
						String n = sc.next();
						runobj.addBook(t, a, n);
						break;
				case 2:runobj.availableBooks();
						break;
				case 3:runobj.borrowedBooks();
						break;
				case 4: System.out.println("Enter Your Name : ");
						sc.nextLine();
						String name = sc.nextLine();
						System.out.println("Enter your ID no: ");
						String id = sc.next();
						System.out.println("Enter Book Title: ");
						sc.nextLine();
						String book = sc.nextLine();
						runobj.borrow(name,id,book);
						break;
				case 5:System.out.println("Enter your ID no: ");
						String id_no = sc.next();
						System.out.println("Enter book Title: ");
						sc.nextLine();
						String tit = sc.nextLine();
						runobj.returnBook(id_no, tit);
						break;
				case 6:runobj.allMembers();
						break;
				case 7: System.exit(0);
				default:System.out.println("Invalid input!!!");	   
			}
		}
		
	}
	
}
