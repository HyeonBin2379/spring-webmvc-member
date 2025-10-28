package com.ssg.membertest.members.service;

import com.ssg.membertest.members.domain.MemberVO;
import com.ssg.membertest.members.dto.MemberDTO;
import com.ssg.membertest.members.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
    public void register(MemberDTO memberDTO) {
        MemberVO memberVO = modelMapper.map(memberDTO, MemberVO.class);
        memberMapper.insert(memberVO);
    }

    @Override
    public List<MemberDTO> listAll() {
        List<MemberVO> memberVOList = memberMapper.findAll();
        return memberVOList.stream()
                .map(memberVO -> modelMapper.map(memberVO, MemberDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public MemberDTO get(String mid) {
        Optional<MemberVO> selected = memberMapper.findById(mid);
        return selected
                .map(memberVO -> modelMapper.map(memberVO, MemberDTO.class))
                .orElseThrow(() -> new IllegalArgumentException("검색 실패"));
    }

    @Override
    public void write(MemberDTO member) {
        MemberVO memberVO = modelMapper.map(member, MemberVO.class);
        memberMapper.insert(memberVO);
    }

    @Override
    public void edit(MemberDTO member) {
        Optional<MemberVO> foundMember = memberMapper.findById(member.getMid());
        if (!foundMember.isPresent()) {
            throw new IllegalArgumentException();
        }
        MemberVO updated = foundMember.get();
        modelMapper.map(member, updated);
        memberMapper.updateOne(updated);
    }

    @Override
    public void remove(String mid) {
        memberMapper.deleteOne(mid);
    }
}
