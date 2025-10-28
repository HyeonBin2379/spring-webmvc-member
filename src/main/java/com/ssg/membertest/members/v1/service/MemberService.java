package com.ssg.membertest.members.v1.service;

import com.ssg.membertest.members.v1.dto.MemberDTO;

import java.util.List;

public interface MemberService {

    void register(MemberDTO memberDTO) throws Exception;
    List<MemberDTO> listAll() throws Exception;
    MemberDTO get(String mid) throws Exception;
    void write(MemberDTO member) throws Exception;
    void edit(MemberDTO member) throws Exception;
    void remove(String mid) throws Exception;
}
