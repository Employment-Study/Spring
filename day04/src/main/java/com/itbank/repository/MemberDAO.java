package com.itbank.repository;

import java.util.HashMap;

import org.apache.ibatis.annotations.Select;

import com.itbank.model.MemberDTO;

public interface MemberDAO {
	
	@Select("select * from member where userid=#{userid} and userpw=#{userpw}")
	MemberDTO login1(String userid, String userpw);
	
	@Select("select * from member where userid=#{userid} and userpw=#{userpw}")
	MemberDTO login2(HashMap<String, String> map);
	
	@Select("select * from member where userid=#{userid} and userpw=#{userpw}")
	MemberDTO login3(MemberDTO dto);

}
