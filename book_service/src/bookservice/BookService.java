package bookservice;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/books")
public class BookService {
	List<Book> books;
	public BookService() {
		books = Books.getBooks();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getBooks() {
		return books;
	}
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Book getBook(@PathParam("id") int id) {
		  for(Book b : books) {
			  if ( b.getId() == id)
				   return b;
		  }
		  // book with the given id is not found, so throw 404 error
		  throw new NotFoundException(); 
	}
	
	//Adding new books using POST method
		@POST
		@Produces(MediaType.APPLICATION_JSON)
		public Book addBook(Book newBook) {
			books.add(newBook);
			for (Book book : books) {
				if (book.getId() == newBook.getId())
					return book;
			}
			// book with the given id is not found, so throw 404 error
			  throw new NotFoundException(); 
			
		}
		
		//deleting a particular book using DELETE method
		@Path("{id}")
		@DELETE
		@Produces(MediaType.APPLICATION_JSON)
		public Book deleteBook(@PathParam("id") int id) {
			for (Book book : books) {
				if (book.getId() == id) {
					books.remove(book);
					return book;
				}
			}
			// book with the given id is not found, so throw 404 error
			  throw new NotFoundException(); 
		}
	
}
