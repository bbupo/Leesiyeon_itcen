package com.itcen.lsy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itcen.lsy.service.BookService;
import com.itcen.lsy.util.Pager;
import com.itcen.lsy.vo.Book;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired // 스프링한테 서비스라는 변수를 북서비스 타입에 빈객체를 인젝션(넣어달라)
	BookService service;
	
	@RequestMapping("/dummy")
	String dummy() {
		service.dummy();
		return "redirect:list";
	}

	@RequestMapping("/init")
	String init() {
		service.init();  //서비스에서 init 메소드 실행
		return "redirect:list";
	}

	@RequestMapping("/list")
	String list(Model model, Pager pager) {
		List<Book> list = service.list(pager);

		model.addAttribute("list", list);

		return "list";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET) //get 메소드만 처리하겠다
	String insert() {
		return "insert";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	String insert(Book book) {  //매개변수 파라미터
		service.insert(book);
		return "redirect:list";	
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET) //get 메소드만 처리하겠다
	String update(int bookid, Model model) {
		Book item = service.item(bookid); //키값으로 아이템 얻고 
		model.addAttribute("item", item);  //jsp 주기위해  model 담기
		return "update";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	String update(Book book) {  //매개변수 파라미터
		service.update(book); //이책 수정해줭 ~
		return "redirect:list";	
	}
	@RequestMapping("/delete")
	String delete(int bookid) {
		service.delete(bookid);
		return "redirect:list";
	}
	
}
