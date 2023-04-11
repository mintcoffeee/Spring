package com.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

//@Component
@Controller
public class HelloController {
	
	@RequestMapping(value="/hello.do", method=RequestMethod.GET)
	public ModelAndView hello() { //사용자가 만든 콜백 메소드, 호출할 필요가 없다. 스프링 컨테이너에 의해서 자동 실행  
		ModelAndView mav = new ModelAndView();

		mav.addObject("result", "Hello Spring!!");
		// = request.setAttribute("result", "Hello Spring!!");
		//mav.setViewName("hello"); //파일명 지정 
		mav.setViewName("/view/hello"); // 폴더/파일명 지정 
		
		return mav;
	}
	
	@RequestMapping(value="/hello2.do", method=RequestMethod.GET)
	public ModelAndView hello2() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("result2", "Have a nice day!!");
		mav.setViewName("/WEB-INF/view2/hello2"); // WEB-INF 로 들어가면 외부에서 들어올 수 없다.  
//		http://localhost:8080/chapter06/WEB-INF/view2/hello2.jsp 호출이 안된다. 
//		스프링은 기본으로 WEB-INF에서 호출한다. 
		return mav;
	}
	//produces = "text/html" 지금 쓰는 모든 문자는 html 로 인식,charset=UTF-8 한글 깨짐 방지 
	@RequestMapping(value="/hello3.do", method=RequestMethod.GET, produces = "text/html; charset=UTF-8")
	@ResponseBody 
	public String hello3() {
		//return "Welcome"; //@ResponseBody이 없으면, 파일명 Welcome.jsp 로 인식한다. 
		return "안녕하세요";
	}
	//스프링에서는 return 타입이 String 이면 단순 문자열이 아니라, 파일명으로 인식한다.
	//스프링은 Welcome.jsp 파일을 찾는다. 
	//만약 단순 문자열로 웹 브라우저에 나타내려면 @ResponseBody를 써야 한다. 
	
}

/*
콜백 메소드
-어떤 때가 되면 운영체제, 스프링에 의해서 호출되는 메소드
ex) main
  
http://localhost:8080/Context명(Project명)/hello.do 요청, 요청할때 명시 안하면 get 방식

DispatcherServlet
	| HandlerMapping 
HelloController.java


hello.do
바로 *.jsp 파일로 호출하는 것을 막는다
반드시 서블릿으로 호출하도록 한다. 

 */
