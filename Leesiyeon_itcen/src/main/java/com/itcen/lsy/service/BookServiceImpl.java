package com.itcen.lsy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.itcen.lsy.dao.BookDao;
import com.itcen.lsy.util.Pager;
import com.itcen.lsy.vo.Book;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	@Qualifier(value="oracleDao")
	BookDao dao;
	
	@Override
	public List<Book> list(Pager pager) {
		// TODO Auto-generated method stub
		float total =dao.total(pager);
		
		pager.setTotal(total);
		
		return dao.list(pager);
	}

	@Override
	public void insert(Book book) {
		// TODO Auto-generated method stub
		dao.insert(book);
		
	}
	
	@Override
	public Book item(int bookid) {
		// TODO Auto-generated method stub
		return dao.item(bookid);
	}


	@Override
	public void update(Book book) {
		// TODO Auto-generated method stub
		dao.update(book);
		
	}

	@Override
	public void delete(int bookid) {
		// TODO Auto-generated method stub
		dao.delete(bookid);
	}

	@Override
	public void dummy() {
		// TODO Auto-generated method stub
		
	 for(int i=0; i<100; i++) {
		 Book book= new Book();
		 book.setBookid(i);
		 book.setBookname("도서명"+i);
		 book.setPublisher("출판사"+i);
		 book.setPrice(1000*i);
		 dao.insert(book);
	    }
		
	}

	@Override
	public void init() {
List<Book> list = dao.list();  //리스트 다 불러온다
for(Book book : list) {
	dao.delete(book.getBookid());
}
	}


}
