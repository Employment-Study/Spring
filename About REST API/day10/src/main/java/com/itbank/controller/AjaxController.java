package com.itbank.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;

@RestController //내부의 모든 함수는 @ResponseBody를 자동으로 적용받는다.
				//jsp 포워딩 할 수 없다.

//@CrossOrigin // localhost의 jsp에서 localhost의 서버로 ajax요청을 보내는 것은 항상 허용된다.
//			 // localost의 jsp에서 다른 서버로 ajax요청을 받는 것은 허용되지 않는다.
//			 // same=origin(동일 출처 자원 공유 원칙)에 의해, 서버에 허용해야 다른 도메인에서 자원을 요청할 수 있다.)
//			//CORS(Cross Origin Resource Sharing)를 제어하기 위해 다른 서버에 요청을 해서 자원을 받아올 수 있다.
//// 로컬호스트가 타 서버에 요청을 보내는 것이 아니라, 로컬호스트의 서버가 타 서버에 요청을 보내야 값을 가져올 수 있는 경우가 있다.
public class AjaxController {
	
	// servlet-context.xml 에서 annotation-driven 내부에 message-converter를 작성하면
	// produces와 consumes에 대한 미디어 타입을 생략할 수 있다
	
//	@PostMapping("/ajax4")
//	public Ex01DTO ajax4(
//			@RequestBody Ex01DTO dto) {
//		System.out.println("name " + dto.getName());
//		System.out.println("age : "+ dto.getAge());
//		
//		return dto;
//	}
	
	
	//JS에서 파라미터를 묶어서 전달했으면 받을때도, hashMap 혹은 dto형태로 묶어서 받는다.
	@PostMapping("/ajax4")
	public String ajax4(
			@RequestBody HashMap<String, Object> param) {
		System.out.println("name " + param.get("name"));
		System.out.println("age : "+ param.get("age"));
		
		Object name  = param.get("name");
		Object age = param.get("age");
		Object result = Integer.parseInt(age.toString())>= 20 ? "성인" : "미성년자";
		
		String returnValue = String.format("%s님의 나이는 %s살이고,%s", name,age,result);
		return returnValue;
	}
	
	@Autowired private MemberDAO memberDAO;
	
	private ObjectMapper mapper = new ObjectMapper(); //jackson 의존성을 추가하여 사용할 수 있는 mapper
	
	@GetMapping("/ajax5")
	public HashMap<String, String> ajax5(String userid) throws JsonProcessingException {
		MemberDTO dto = memberDAO.selectOneByUserId(userid);
		String msg = dto == null? "사용가능한 ID입니다." : " 이미 사용중인 ID입니다.";
		String color = dto == null? "blue" : "red";
		
		//1)직접 JSON 형식의 문자열 구성하기
//		String result= "{\"msg\" : \"%s\", \"color\" : \"%s\"}";
//		result = String.format(result, msg, color);
		
		//2) dto 혹은 hashmap에 값을 넣은 후 objectMapper를 활용하여 문자열로 변환하기
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("msg",msg);
//		map.put("color",color);
		
//		String result= mapper.writeValueAsString(map); 
//		//예외는 throws,  DTO,HashMap,List(자바스크립트의 배열타입으로 바뀜)도 가능
//		System.out.println(result);
//		return result;
	
		
		//3) 자바 객체를 그냥 반환하기
		//하지만 직접 사용하지 않아도 선언만 해주면 알아서 변환해준다.
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("msg",msg);
		map.put("color",color);
		
		return map;
	}
	
	@PostMapping("/join")		//@RequestBody : JSON 데이터를 받기 위해 선언
	public HashMap<String, String> join(@RequestBody MemberDTO dto) { 
		int row = memberDAO.insert(dto);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("status",row != 0 ? "가입성공" : "가입 실패");
		map.put("color", row!= 0? "blue " : "red");
		
		return map;
	}
	
	@GetMapping("/memberList")
	public List<MemberDTO> memberList(){
		return memberDAO.selectList();
	}

}
