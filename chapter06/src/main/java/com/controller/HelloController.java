package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping(value="/hello.do", method=RequestMethod.GET)
	public ModelAndView hello() { //사용자가 만든 콜백 메소드, 호출할 필요가 없다. 스프링 컨테이너에 의해서 자동 실행  
		ModelAndView mav = new ModelAndView();

		mav.addObject("result", "Hello Spring!!");
		// = request.setAttribute("result", "Hello Spring!!");
		mav.setViewName("hello"); //파일명 지정 
		return mav;
	}
}

/*
콜백 메소드
-어떤 때가 되면 운영체제, 스프링에 의해서 호출되는 메소드
ex) main
  
  

http://localhost:8080/Context명(Project명)/hello.do 요청, 요청할때 명시 안하면 get 방식

DispatcherServlet
	| HandlerMapping 
HelloController.java



 */
