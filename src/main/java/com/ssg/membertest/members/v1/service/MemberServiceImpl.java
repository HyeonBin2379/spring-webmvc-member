package com.ssg.membertest.members.v1.service;

import com.ssg.membertest.members.v1.dao.MemberDAO;
import com.ssg.membertest.members.v1.domain.MemberVO;
import com.ssg.membertest.members.v1.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ToString
//@Service
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

    @Override
    public MemberDTO get(String mid) throws Exception {
        Optional<MemberVO> selected = memberDAO.selectOne(mid);
        return selected
                .map(memberVO -> modelMapper.map(memberVO, MemberDTO.class))
                .orElseThrow(() -> new IllegalArgumentException("검색 실패"));
    }

    @Override
    public void write(MemberDTO member) throws Exception {
        MemberVO memberVO = modelMapper.map(member, MemberVO.class);
        memberDAO.insert(memberVO);
    }

    @Override
    public void edit(MemberDTO member) throws Exception {
        Optional<MemberVO> foundMember = memberDAO.selectOne(member.getMid());
        if (!foundMember.isPresent()) {
            throw new IllegalArgumentException();
        }
        MemberVO updated = foundMember.get();
        modelMapper.map(member, updated);
        memberDAO.updateOne(updated);
    }

    @Override
    public void remove(String mid) throws Exception {
        memberDAO.deleteOne(mid);
    }
}
