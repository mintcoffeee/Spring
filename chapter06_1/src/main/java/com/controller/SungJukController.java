package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bean.SungJukDTO;


@Controller
@RequestMapping(value="sungJuk")
public class SungJukController {
	
	@GetMapping(value="input.do")
	public String input() {
		return "sungJuk/input";
	}
	
//	@GetMapping(value="/sungJuk/result.do")
//	public String result(@ModelAttribute SungJukDTO sungJukDTO, Model model) {
//		model.addAttribute("name", sungJukDTO.getName()); 
//		model.addAttribute("tot", sungJukDTO.getKor()+sungJukDTO.getEng()+sungJukDTO.getMath());
//		model.addAttribute("avg", String.format("%.3f", 
//							(double)(sungJukDTO.getKor()+sungJukDTO.getEng()+sungJukDTO.getMath())/3));
//		
//		return "sungJuk/result";
//	}
	
	@PostMapping(value="result.do")
	public String result(@ModelAttribute SungJukDTO sungJukDTO, Model model) {
		int tot = sungJukDTO.getKor()+sungJukDTO.getEng()+sungJukDTO.getMath();
		double avg = tot/3.;
//		model.addAttribute("name", sungJukDTO.getName()); 
//		model.addAttribute("tot", tot);
//		model.addAttribute("avg", String.format("%.3f", tot/3.));
		sungJukDTO.setTot(tot);
		sungJukDTO.setAvg(avg);
		
		model.addAttribute("sungJukDTO",sungJukDTO);
		return "sungJuk/result";
	}

}
