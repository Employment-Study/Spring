package com.itbank.repository;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDAO {

	@Select("select banner from v$version")
	String getVersion();
	
	@Select("select sysdate from dual")
	Date getSysdate();
	
	@Select("select tname from tab")
	List<String> getTableInfo();
}
