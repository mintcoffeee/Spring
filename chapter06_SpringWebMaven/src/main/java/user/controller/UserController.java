package user.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import user.bean.UserDTO;
import user.service.UserService;

@Controller
@RequestMapping(value="user")
public class UserController {
	@Autowired
	private UserService userService; 
	
	@GetMapping(value="writeForm")
	public String writeForm() {
		return "user/writeForm";
	}
	
	@PostMapping(value="write")
	@ResponseBody //dispatcher 로 가지 마라 
	//인자 : @RequestParam 3개 or @ModelAttribute
	public void write(@ModelAttribute UserDTO userDTO) {
		userService.write(userDTO);
	}
	
	@GetMapping(value="list")
	public String list(@RequestParam(required = false, defaultValue="1")  String pg, Model model) {
		//pg 값을 생략하면 default 값으로 1 을 잡겠다.
		//DB를 가지않고 바로 화면에 틀만 띄운다. 
		model.addAttribute("pg", pg);
		return "user/list";
	}

	
	@PostMapping(value="getUserList")
	@ResponseBody //dispatcher 로 가지 마라, 갖고 있는 객체를 자연스럽게 json으로 변환 해준다.  
	public Map<Object, Object> getUserList(@RequestParam String pg) {
		return userService.getUserList(pg);
	}
	
	
	@PostMapping(value="isExistId")
	@ResponseBody // return 값을 파일명이 아닌 문자열로 인식하기 위해 사용
	public String isExistId(@RequestParam String id) {
		return userService.isExistId(id);
	}
	
	@GetMapping(value="updateForm")
	public String updateForm() {
		return "user/updateForm";
	}
	@PostMapping(value="getUser")
	@ResponseBody // return 값을 파일명이 아닌 문자열로 인식하기 위해 사용
	public UserDTO getUser(@RequestParam String id) {
		return userService.getUser(id);
	}
	
	@PostMapping(value="update")
	@ResponseBody  
	public void update(@ModelAttribute UserDTO userDTO) {
		userService.update(userDTO);
	}
	
	@GetMapping(value="deleteForm")
	public String deleteForm() {
		return "user/deleteForm";
	}
	
	@PostMapping(value="delete")
	@ResponseBody  
	public void delete(@RequestParam String id) {
		userService.delete(id);
	}
	
}


// return type 이 String 일 때 단순 문자열이 아니라 파일명이다. 
// return "angel"; => /WEB-INF/angel.jsp
