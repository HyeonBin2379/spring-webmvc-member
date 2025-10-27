package com.ssg.membertest.members.service;

import com.ssg.membertest.members.dao.MemberDAO;
import com.ssg.membertest.members.domain.MemberVO;
import com.ssg.membertest.members.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@ToString
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;
    private final ModelMapper modelMapper;

    @Override
    public void register(MemberDTO memberDTO) throws Exception {
        MemberVO memberVO = modelMapper.map(memberDTO, MemberVO.class);
        memberDAO.insert(memberVO);
    }

    @Override
    public List<MemberDTO> listAll() throws Exception {
        List<MemberVO> memberVOList = memberDAO.selectAll();
        return memberVOList.stream()
                .map(memberVO -> modelMapper.map(memberVO, MemberDTO.class))
                .collect(Collectors.toList());
    }
}
