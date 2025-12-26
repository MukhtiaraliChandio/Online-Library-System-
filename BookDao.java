package com.library.dao;

import java.util.List;

import com.library.pojo.Author;
import com.library.pojo.Book;
import com.library.pojo.BookCategory;
import com.library.pojo.User;

public interface BookDao {


	
	public List<Book> getbookNamelist();
	
	List<Author> getAllAuthors();	
	
	public int addBookcategory(String bookCategory); 	

    public List<Book> searchBooks(String keyword); 
	
	public  Book getBookbyId(int id);

	
	public void insertBookdata(int authorId, int bookCategoryId,   String bookName, String language,
			String authorEditor, String editorVolume, String yearOfpublishing, String isbn, String noOfpages,
			String remarks);

	public List<Book> geAllbookData();

	public void updateookdata(int authorId, int bookId, String bookName, String language, String authorEditor,
			String editorVolume, String yearOfpublishing, String isbn, String noOfpages, String remarks);


	public void deleteBookdataByid(int id);

	public List<BookCategory> getBookcategoryData();

	public BookCategory getBookcategoryByid(int categoryId);



	

  
	
	
	
}
	
	
	
	


