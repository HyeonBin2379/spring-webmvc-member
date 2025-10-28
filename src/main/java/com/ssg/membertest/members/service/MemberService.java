package com.ssg.membertest.members.service;

import com.ssg.membertest.members.dto.MemberDTO;

import java.util.List;

public interface MemberService {

    void register(MemberDTO memberDTO);
    List<MemberDTO> listAll();
    MemberDTO get(String mid);
    void write(MemberDTO member);
    void edit(MemberDTO member);
    void remove(String mid);
}
