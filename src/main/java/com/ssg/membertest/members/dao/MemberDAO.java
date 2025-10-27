package com.ssg.membertest.members.dao;

import com.ssg.membertest.members.domain.MemberVO;

import java.util.List;
import java.util.Optional;

public interface MemberDAO {

    void insert(MemberVO vo) throws Exception;
    List<MemberVO> selectAll() throws Exception;
    Optional<MemberVO> selectOne(String mid) throws Exception;
    String insertOne(MemberVO vo) throws Exception;
    boolean updateOne(MemberVO vo) throws Exception;
    boolean deleteOne(String mid) throws Exception;
}
