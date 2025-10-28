package com.ssg.membertest.members.service;

import com.ssg.membertest.members.dto.MemberDTO;

import java.util.List;

public interface MemberService {

    void joinMember(MemberDTO memberDTO);
    List<MemberDTO> memberList();
    MemberDTO get(String mid);
    void edit(MemberDTO member);
    void remove(String mid);
}
