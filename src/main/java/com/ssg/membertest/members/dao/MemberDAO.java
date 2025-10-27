package com.ssg.membertest.members.dao;

import com.ssg.membertest.members.domain.MemberVO;

import java.util.List;

public interface MemberDAO {

    void insert(MemberVO vo) throws Exception;
    List<MemberVO> selectAll() throws Exception;
}
