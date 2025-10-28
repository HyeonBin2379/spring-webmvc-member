package com.ssg.membertest.members.mapper;

import com.ssg.membertest.members.domain.MemberVO;

import java.util.List;
import java.util.Optional;

public interface MemberMapper {

    void insert(MemberVO vo);
    List<MemberVO> findAll();
    Optional<MemberVO> findById(String mid);
    boolean updateOne(MemberVO vo);
    boolean deleteOne(String mid);
}
