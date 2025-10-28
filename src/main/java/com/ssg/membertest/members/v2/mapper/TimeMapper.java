package com.ssg.membertest.members.v2.mapper;

import org.apache.ibatis.annotations.Select;

// 현재 시각 정보를 제공하는 Mapper 인터페이스
public interface TimeMapper {

    // DB에서 제공하는 현재 시각을 문자열로 처리하는 메서드
    @Select("select now()")
    String getTimeNow();
}
