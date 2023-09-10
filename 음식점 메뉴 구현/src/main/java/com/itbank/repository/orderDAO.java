package com.itbank.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.itbank.model.menuDTO;

@Repository
public interface orderDAO {

	@Select("select * from menu order by idx")
	ArrayList<menuDTO> selectList();

	@Insert("insert into menu(menu_name, menu_intro, menu_price) "
			+ "values(#{menu_name}, #{menu_intro}, #{menu_price})")
	int insert(menuDTO dto);

	
	@Select("select * from menu where idx=${idx}")
	menuDTO selectOne(int idx);

	
	
}
