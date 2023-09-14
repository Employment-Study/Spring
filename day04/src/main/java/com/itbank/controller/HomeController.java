package com.itbank.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.repository.TestDAO;

@Controller
public class HomeController {
	
	@Autowired private TestDAO testDAO;
	
	@RequestMapping("/")
	public ModelAndView home() {
		// 포워딩으로 이동할 목적지(jsp) 설정
		ModelAndView mav = new ModelAndView("home");
		
		// 목적지에 보낼 화물(data) 가져오기
		String version = testDAO.getVersion();
		Date sysdate = testDAO.getSysdate();
		List<String> tableList = testDAO.getTableInfo();
		
		// 목적지로 이동하는 트럭(mav)에 데이터 적재하기  
		mav.addObject("version", version);
		mav.addObject("sysdate", sysdate);
		mav.addObject("tableList", tableList);
		
		// 출발
		return mav;
	}
}










