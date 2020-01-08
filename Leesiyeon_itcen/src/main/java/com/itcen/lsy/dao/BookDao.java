package com.itcen.lsy.dao;

import java.util.List;

import com.itcen.lsy.util.Pager;
import com.itcen.lsy.vo.Book;

public interface BookDao {

	List<Book> list(Pager pager);

	void insert(Book book);
	
	Book item(int bookid);

	void update(Book book);

	void delete(int bookid);

	List<Book> list();

	float total(Pager pager);

	

}
