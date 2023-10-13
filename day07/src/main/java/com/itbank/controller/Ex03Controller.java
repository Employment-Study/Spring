package com.itbank.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.component.HashComponent;
import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;

@Controller
public class Ex03Controller {
	
	@Autowired private HashComponent hashComponent;
	@Autowired private MemberDAO memberDAO;

	@GetMapping("/ex03")
	public void ex03() {}
	
	@PostMapping("/ex03")
	public ModelAndView ex03(MemberDTO dto) {
		ModelAndView mav = new ModelAndView("ex03-action");
		
		// 랜덤 문자열(신규 패스워드)을 생성한 다음, 랜덤 솔트를 받아와서 새로운 해시값을 생성하고
		String pass = UUID.randomUUID().toString().split("-")[0];
		
		// DB에 update한다
		String salt = hashComponent.getRandomSalt();
		String hash = hashComponent.getHash(pass, salt);
		dto.setSalt(salt);
		dto.setUserpw(hash);
		
		int row = memberDAO.updatePassword(dto);
		
		if(row != 0) {
			// 신규 패스워드를 알려줄 수 있도록 한다
			mav.addObject("msg", String.format("신규 비밀번호는 [%s] 입니다", pass));
		}
		return mav;
	}
	
	
}





