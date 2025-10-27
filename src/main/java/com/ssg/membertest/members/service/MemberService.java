package com.ssg.membertest.members.service;

import com.ssg.membertest.members.dto.MemberDTO;

import java.util.List;

public interface MemberService {

    void register(MemberDTO memberDTO) throws Exception;
    List<MemberDTO> listAll() throws Exception;
}
