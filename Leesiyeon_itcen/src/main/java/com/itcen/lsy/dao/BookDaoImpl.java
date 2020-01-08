package com.itcen.lsy.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.itcen.lsy.util.Pager;
import com.itcen.lsy.vo.Book;

@Repository(value = "memoryDao")
public class BookDaoImpl implements BookDao {

	List<Book> list;

	public BookDaoImpl() {
		list = new ArrayList<Book>(); // 생성자

		Book book = new Book();
		book.setBookid(1);
		book.setBookname("자바 프로젝트");
		book.setPublisher("한빛미디어");
		book.setPrice(10000);
		list.add(book);

		book = new Book();
		book.setBookid(2);
		book.setBookname("어서와 자바는 처음이지");
		book.setPublisher("mcsmiper");
		book.setPrice(20000);
		list.add(book);

		book = new Book();
		book.setBookid(3);
		book.setBookname("html5+css");
		book.setPublisher("길벗");
		book.setPrice(30000);
		list.add(book);

	}

	@Override
	public List<Book> list() {
		return list;
	}

	@Override
	public void insert(Book book) {
		list.add(book);
	}

	@Override
	public Book item(int bookid) {
		for (Book item : list) {
			if (item.getBookid() == bookid)
				return item;
		}

		return null;
	}

	@Override
	public void update(Book book) {
		for (Book item : list) {
			if (item.getBookid() == book.getBookid()) {
				item.setBookname(book.getBookname());
				item.setPublisher(book.getPublisher());
				item.setPrice(book.getPrice());

			}
		}
	}

	@Override
	public void delete(int bookid) {
		for (Book item : list) {
			if (item.getBookid() == bookid) {
				list.remove(item);
				break;
			}
		}

	}

	@Override
	public List<Book> list(Pager pager) {
	List<Book> books = new ArrayList<Book>();
	
	int start=((pager.getPage()- 1 * pager.getPage()+1));
	int end=pager.getPage()*pager.getPerPage();
	
	for(int i=start; i<list.size() && i<=end; i++){
		books.add(list.get(i - 1));
		
		
	}return books;
	
	}

	@Override
	public float total(Pager pager) {
	
		return list.size();
	}

}
