package com.library.pojo;

public class BookCategory {

	private int categoryId;
	private String bookCategory;
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getBookCategory() {
		return bookCategory;
	}
	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}
	@Override
	public String toString() {
		return "BookCategory [categoryId=" + categoryId + ", bookCategory=" + bookCategory + "]";
	}
	
	
	
	
}