package com.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bean.SumDTO;

@Controller
public class SumController {
	
	//@RequestMapping(value="/input.do", method=RequestMethod.GET, produces = "text/html; charset=UTF-8")
	@GetMapping(value="/input.do")
	public String input() { // => /WEB-INF///beoard//코드
		return "sum/input"; // /WEB-INF/sum/input.jsp
		
	}
	
	//@RequestMapping(value="/result.do", method=RequestMethod.POST, produces = "text/html; charset=UTF-8")
//	@PostMapping(value="/result.do")
//	public String result() {
//		return "sum/result";
//	}
	
//	@PostMapping(value="/result.do")
//	public ModelAndView result(@RequestParam int x, 
//							   @RequestParam int y) {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("x",x);
//		mav.addObject("y",y);
//		mav.setViewName("sum/result");
//		
//		return mav;
//	}
	
	
	//error 400 : 콜백 메소드에서 데이터가 안들어오고 있을 때 발생
	//int 보다 String 일 때 데이터 에러가 더 적게 발생한다. 
	//error 400 방지를 위해 required 사용 
	//required = false : 값이 안들어 올 수도 있다. 그 때 defaultValue="0" default 값을 0으로 한다. 
//	@PostMapping(value="/result.do")
//	public ModelAndView result(@RequestParam(required = false, defaultValue="0") String x, 
//							   @RequestParam(required = false, defaultValue="0") String y) {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("x",x);
//		mav.addObject("y",y);
//		mav.setViewName("sum/result");
//		
//		return mav;
//	}
	
	
//	@PostMapping(value="/result.do")
//	public String result(@RequestParam Map<String, String> map, ModelMap modelMap) {
//		modelMap.put("x", map.get("x")); 
//		//<input type="text" name="x">, map.get은 input 태그의 name 값을 그대로 가져 온다.
//		modelMap.put("y", map.get("y")); 
//		return "sum/result";
//	}
	
	@PostMapping(value="/result.do")
	public String result(@ModelAttribute SumDTO sumDTO, Model model) {
		model.addAttribute("x", sumDTO.getX()); 
		model.addAttribute("y", sumDTO.getY()); 
		return "sum/result";
	}
	
	
	 
}
