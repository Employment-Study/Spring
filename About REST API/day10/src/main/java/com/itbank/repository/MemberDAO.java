package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.itbank.model.MemberDTO;

@Repository
public interface MemberDAO {

	@Select("select * from member6 where userid = #{userid}")
	public MemberDTO selectOneByUserId(String userid) ;

	@Insert("insert into member6(userid,userpw,username,gender) values(#{userid},#{userpw},#{username},#{gender})")
	public int insert(MemberDTO dto);
	
	@Select("select * from member6")
	public List<MemberDTO> selectList();
	

}
