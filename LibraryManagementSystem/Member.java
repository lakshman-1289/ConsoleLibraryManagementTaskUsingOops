package LibraryManagementSystem;

public class Member {
	//Attributes - name,id,borrowed books
	private String name;
	private String id;
	private String borrowbook; 
	/*
	It is very difficult to maintain each member borrowed books as array,
	because, everytime add a book to his borrowbooks array index have to maintain 
	for that index of each person's array  another array is needed (complex)
	Up to now, it is easy to store data of person as new object for each borrowed book
	example: sravan borrow 2 books jse and jee we store as 2 objects of sravan like below
			object 1: name:sravan id:2027 borrowbook:jse
			object 2: name:sravan id:2027 borrowbook:jee
	 */
	//it may simplify after collection frameworks
	
	//all setters and getters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBorrowbook() {
		return borrowbook;
	}

	public void setBorrowbook(String borrowbook) {
		this.borrowbook = borrowbook;
	}



	@Override
	public String toString() {
		return "Id_number: "+id+"\tName: "+name +"\t\tborrowed book:"+borrowbook;
	}
}
