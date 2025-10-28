package com.ssg.membertest.members.service;

import com.ssg.membertest.members.domain.MemberVO;
import com.ssg.membertest.members.dto.MemberDTO;
import com.ssg.membertest.members.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ToString
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public void joinMember(MemberDTO memberDTO) {
        MemberVO memberVO = modelMapper.map(memberDTO, MemberVO.class);
        memberMapper.insert(memberVO);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MemberDTO> memberList() {
        List<MemberVO> memberVOList = memberMapper.findAll();
        return memberVOList.stream()
                .map(memberVO -> modelMapper.map(memberVO, MemberDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public MemberDTO get(String mid) {
        Optional<MemberVO> selected = memberMapper.findById(mid);
        return selected
                .map(memberVO -> modelMapper.map(memberVO, MemberDTO.class))
                .orElseThrow(() -> new IllegalArgumentException("검색 실패"));
    }

    @Override
    @Transactional
    public void edit(MemberDTO member) {
        Optional<MemberVO> foundMember = memberMapper.findById(member.getMid());
        if (!foundMember.isPresent()) {
            throw new IllegalArgumentException();
        }
        MemberVO updated = foundMember.get();
        modelMapper.map(member, updated);
        memberMapper.update(updated);
    }

    @Override
    @Transactional
    public void remove(String mid) {
        memberMapper.delete(mid);
    }
}
