package user.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="user")
public class UserController2 {
	
	//파일 업로드
	@GetMapping(value="uploadForm")
	public String uploadForm() {
		return "user/uploadForm";
	}
	
	@PostMapping(value="upload")						//session 생성 
	@ResponseBody
	public String upload(@RequestParam MultipartFile img, HttpSession session) {
		//가상폴더 
		///Users/moon/git/Spring/chapter06_SpringWebMaven/src/main/webapp/WEB-INF/storage
		//String filePath_lier = "/Users/moon/git/Spring/chapter06_SpringWebMaven/src/main/webapp/WEB-INF/storage"; //가상폴더 위치 
		
		
		//AWS 같은 곳에 올릴 때 필요한 filePath는 실제 폴더 위치이다. 
		String filePath = session.getServletContext().getRealPath("/WEB-INF/storage");
		System.out.println("실제 폴더  = " + filePath);
		String fileName = img.getOriginalFilename();
		
		File file = new File(filePath, fileName); //파일 생성 
		//File file_lier = new File(filePath_lier, fileName); // 가짜 파일 생성(내가 볼수 있는 파일) 
		
		try {
			//FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file_lier)); //파일 복사 
			img.transferTo(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "<img src='../storage/" + fileName + "' width='300' height='300' />";
	}
}


