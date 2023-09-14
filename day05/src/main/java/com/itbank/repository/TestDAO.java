package com.itbank.repository;

import org.apache.ibatis.annotations.Select;

public interface TestDAO {

	@Select("select banner from v$version")
	String getVersion();

}
