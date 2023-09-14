package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.itbank.model.ArtistDTO;

@Repository
public interface ArtistDAO {

	// 목록		select 
	@Select("select * from artist order by id")
	List<ArtistDTO> selectAll();
	
	// 단일조회	select ... where [PK]
	@Select("select * from artist where id = #{id}")
	ArtistDTO selectOne(int id);
	
	// 검색		select ... where [param]
	// 추가		insert
	// 삭제		delete ... [PK]
	// 수정		update ... [PK]
}
