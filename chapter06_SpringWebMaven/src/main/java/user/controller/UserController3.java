package user.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import user.bean.UserImageDTO;
import user.service.UserService;

@Controller
@RequestMapping(value="user")
public class UserController3 {
	@Autowired
	private UserService userService;
	
	//------------ 한번에 여러개의 파일을 선택 ----------- 
	//<input type="file" name="img[]" multiple="multiple">
	
	@PostMapping(value="upload", produces = "text/html; charset=UTF-8")	 
	@ResponseBody
	public String upload(@RequestParam("img[]") List<MultipartFile> list , 
							 @ModelAttribute UserImageDTO userImageDTO,
			HttpSession session) {//session 생성
		String filePath = session.getServletContext().getRealPath("/WEB-INF/storage");
		System.out.println("실제 폴더  = " + filePath);
		String fileName;
		File file;
		
		List<String> fileNameList = new ArrayList<>(); 
		
		for(MultipartFile img : list) {
			fileName = img.getOriginalFilename();
			file = new File(filePath, fileName);
			
			try {
				img.transferTo(file);  
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			fileNameList.add(fileName);			
		}//for
		
		userService.upload(userImageDTO, fileNameList);
		
		return "이미지 등록 완료";
	}
	
	@PostMapping(value="getImageList")	 
	@ResponseBody
	public List<UserImageDTO> getImageList() {
		return userService.getImageList();
	}

}


