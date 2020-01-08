package com.itcen.lsy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//view 와 model를 연결해주는 역할

@Controller
public class RootController {

	@RequestMapping("/")
	String index() {
		return "index";
	}

	@RequestMapping("/lsy")
		String lsy() {
			return "lsy";
		}

	
}
