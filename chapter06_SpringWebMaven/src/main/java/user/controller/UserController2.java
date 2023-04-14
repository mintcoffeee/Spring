package user.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import user.bean.UserImageDTO;

@Controller
@RequestMapping(value="user")
public class UserController2 {
	
	//파일 업로드
	@GetMapping(value="uploadForm")
	public String uploadForm() {
		return "user/uploadForm";
	}

	@GetMapping(value="uploadForm_AJax")
	public String uploadForm_AJax() {
		return "user/uploadForm_AJax";
	}
	
	//uploadForm_AJax_list
	@GetMapping(value="uploadForm_AJax_list")
	public String uploadForm_AJax_list() {
		//DB를 거치지 않고 화면에 틀만 띄운다. 
		return "user/uploadForm_AJax_list";
	}
	
	
	
	
	//------------ name="img" 1개 일때 -----------
//	@PostMapping(value="upload", produces = "text/html; charset=UTF-8")	 
//	@ResponseBody
//	public String upload(@RequestParam MultipartFile img, 
//						 @ModelAttribute UserImageDTO userImageDTO,
//			HttpSession session) {//session 생성
//		//가상폴더 
//		///Users/moon/git/Spring/chapter06_SpringWebMaven/src/main/webapp/WEB-INF/storage
//		//String filePath_lier = "/Users/moon/git/Spring/chapter06_SpringWebMaven/src/main/webapp/WEB-INF/storage"; //가상폴더 위치 
//		
//		
//		//AWS 같은 곳에 올릴 때 필요한 filePath는 실제 폴더 위치이다. 
//		String filePath = session.getServletContext().getRealPath("/WEB-INF/storage");
//		System.out.println("실제 폴더  = " + filePath);
//		String fileName = img.getOriginalFilename();
//		System.out.println("파일명  = " + fileName);
//		
//		File file = new File(filePath, fileName); //파일 생성 
//		//File file_lier = new File(filePath_lier, fileName); // 가짜 파일 생성(내가 볼수 있는 파일) 
//		
//		try {
//			//FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file_lier)); //파일 복사 
//			img.transferTo(file); //파일이 업로드 된 이미지를 file(실제파일)위치로 이동시키겠다. 
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		userImageDTO.setImage1(fileName);
//		// -> UserService -> UserDAO -> userMapper.xml
//		
//		return "<img src='../storage/" + fileName + "' width='300' height='300' />";
//	}
	
	//------------ name="img" 2개이상일 때 ----------- 
	/*
	@PostMapping(value="upload", produces = "text/html; charset=UTF-8")	 
	@ResponseBody
	public String upload(@RequestParam MultipartFile[] img, 
							 @ModelAttribute UserImageDTO userImageDTO,
			HttpSession session) {//session 생성
		String filePath = session.getServletContext().getRealPath("/WEB-INF/storage");
		System.out.println("실제 폴더  = " + filePath);
		String fileName;
		File file;
		
		if(img[0] != null) {
			fileName = img[0].getOriginalFilename();
			file = new File(filePath, fileName);
			
			try {
				
				img[0].transferTo(file);  
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(img[1] != null) {
			fileName = img[1].getOriginalFilename();
			file = new File(filePath, fileName);
			
			try {
				
				img[1].transferTo(file);  
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return "이미지 등록 완료";
	}
	*/
}


