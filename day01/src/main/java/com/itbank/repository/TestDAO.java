package com.itbank.repository;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

// java interface 의 특징
// 생성자를 이용한 객체 생성이 불가능하다
// 모든 필드에 public static final 속성이 자동으로 지정된다
// 모든 메서드에 public abstract 속성이 자동으로 지정된다

@Repository
public interface TestDAO {

	@Select("select banner from v$version")
	String getVersion();
}
