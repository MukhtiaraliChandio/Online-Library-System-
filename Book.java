package com.library.pojo;

public class Book {

	private int authorId;
	private int bookId;
	private int categoryId;
	private String bookCategory;
    private String bookName;
    private String language;
    private String authorEditor;
    private String editorVolume;
    private String yearOfpublishing;
    private String isbn;
    private String numberOfpages;
    private String remarks;
    
    
    
    
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	
	
	public String getBookCategory() {
		return bookCategory;
	}
	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getAuthorEditor() {
		return authorEditor;
	}
	public void setAuthorEditor(String authorEditor) {
		this.authorEditor = authorEditor;
	}
	public String getEditorVolume() {
		return editorVolume;
	}
	public void setEditorVolume(String editorVolume) {
		this.editorVolume = editorVolume;
	}
	public String getYearOfpublishing() {
		return yearOfpublishing;
	}
	public void setYearOfpublishing(String yearOfpublishing) {
		this.yearOfpublishing = yearOfpublishing;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getNumberOfpages() {
		return numberOfpages;
	}
	public void setNumberOfpages(String numberOfpages) {
		this.numberOfpages = numberOfpages;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "Book [authorId=" + authorId + ", bookId=" + bookId + ", bookName=" + bookName + ", language=" + language
				+ ", authorEditor=" + authorEditor + ", editorVolume=" + editorVolume + ", yearOfpublishing="
				+ yearOfpublishing + ", isbn=" + isbn + ", numberOfpages=" + numberOfpages + ", remarks=" + remarks
				+ "]";
	}

    
	
	
	
	
	
	
	
	
	
	
	
}