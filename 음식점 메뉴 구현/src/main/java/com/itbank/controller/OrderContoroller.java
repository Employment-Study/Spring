package com.itbank.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.menuDTO;
import com.itbank.repository.orderDAO;

@Controller
public class OrderContoroller {
	
		@Autowired orderDAO dao;
	
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		
		ArrayList<menuDTO> list = dao.selectList();
		mav.addObject("list",list);
		
		
		return mav;
	}
	
	@GetMapping("/add")
	public String add() {
		
		return "add";
	}
	@PostMapping("/add")
	public String add(menuDTO dto) {
		
		int row = dao.insert(dto);
		System.out.println(row + "행 추가");
		
		
		return "redirect:/list";
	}
	
	@GetMapping("/view/{idx}")
	public ModelAndView view(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("view") ;
		
		System.out.println("idx : "+idx);
		menuDTO dto = dao.selectOne(idx);
		mav.addObject("dto",dto);
		
		
		return mav;
	}
}
