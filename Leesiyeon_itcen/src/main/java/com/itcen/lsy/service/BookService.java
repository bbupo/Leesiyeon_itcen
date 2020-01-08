package com.itcen.lsy.service;


//비즈니스 로직 업무에서 필요한 작업들을 수행


import java.util.List;

import com.itcen.lsy.util.Pager;
import com.itcen.lsy.vo.Book;

public interface BookService {

	List<Book> list(Pager pager);

	void insert(Book book);

	void update(Book book);

	Book item(int bookid);

	void delete(int bookid);

	void dummy();

	void init();
	
}
