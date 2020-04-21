package bookservice;

import java.util.ArrayList;
import java.util.List;

public class Books {
	private static ArrayList<Book> books = new ArrayList<>();
	static {
		books.add(new Book(1, "The Outliers", 500));
		books.add(new Book(2, "World Is Flat", 550));
	}
	public static List<Book> getBooks() {
		return books;
	}
	
	//Adding a book
	public static void addBook(Book book) {
		books.add(book);
	}
	
	//Delete a book
	public static boolean deleteBook(int id) {
		for (Book book: books) {
			if (book.getId() == id) {
				books.remove(id);
				return true;
			}
		}
		return false;
	}
}
