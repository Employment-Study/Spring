package com.itbank.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Ajax2Controller {
	
	private Random ran = new Random();
	
	@GetMapping("/ajax2")
	@ResponseBody	// 이 함수가 반환하는 값 그 자체가 응답이다(포워딩 하지마라)
	public String ajax2() {
		int num =  ran.nextInt(1000);
		String value = String.format("%04d", num);
		return value;
	}
	
	//produces : 서버의 함수가 생산하는 값(반환값)
	//consumes : 서버의 함수가 소비하는 값(매개변수)
	
//	@GetMapping(value="/ajax3" ,produces="plain/text;charset=utf-8")
	@RequestMapping(value="/ajax3", method = RequestMethod.GET, produces = "plain/text;charset=utf-8")
	@ResponseBody
	public String ajax3(String name, int age) {
		System.out.println("name :" + name);
		System.out.println("age : "+ age);
		boolean isAdult = age>=20;
		
		String value = String.format("%s님은 %d살이고 %s입니다.", name,age,isAdult?"성인":"미성년자");
	
		return value;
	}

}
