package com.itcen.lsy.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itcen.lsy.util.Pager;
import com.itcen.lsy.vo.Book;

@Repository(value = "oracleDao") //dao 어노테이션
public class BookDaoOracle implements BookDao {

	@Autowired
	SqlSession sql;
	
	@Override
	public List<Book> list() {
		return sql.selectList("Book.all");   //book.xml namespace.id
	}

	@Override
	public void insert(Book book) {
		sql.insert("Book.insert", book);  //id가 인서트인 인서트 메소드를 써라 ~
	}

	@Override
	public Book item(int bookid) {
		return sql.selectOne("Book.item", bookid);
	}

	@Override
	public void update(Book book) {
		sql.update("Book.update", book);
		
	}

	@Override
	public void delete(int bookid) {
		sql.delete("Book.delete", bookid);
	}

	@Override
	public List<Book> list(Pager pager) {
		// TODO Auto-generated method stub
		return sql.selectList("Book.list", pager);
	}

	@Override
	public float total(Pager pager) {
		int total=sql.selectOne("Book.total", pager);
		return (float)total;
	}

}
