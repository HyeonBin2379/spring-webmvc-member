package com.ssg.membertest.members.v2.service;

import com.ssg.membertest.members.v2.domain.MemberVO;
import com.ssg.membertest.members.v2.dto.MemberDTO;
import com.ssg.membertest.members.v2.repository.MemberDAO;
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

    private final MemberDAO memberDAO;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public void joinMember(MemberDTO MemberDTO) throws Exception {
        MemberVO memberVO = modelMapper.map(MemberDTO, MemberVO.class);
        memberDAO.insert(memberVO);
    }

    @Override
    @Transactional
    public List<MemberDTO> memberList() throws Exception {
        List<MemberVO> memberVOList = memberDAO.findAll();
        return memberVOList.stream()
                .map(memberVO -> modelMapper.map(memberVO, MemberDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public MemberDTO get(String mid) throws Exception {
        Optional<MemberVO> selected = memberDAO.findById(mid);
        return selected
                .map(memberVO -> modelMapper.map(memberVO, MemberDTO.class))
                .orElseThrow(() -> new IllegalArgumentException("검색 실패"));
    }

    @Override
    @Transactional
    public void edit(MemberDTO memberDTO) throws Exception {
        Optional<MemberVO> foundMember = memberDAO.findById(memberDTO.getUserId());
        if (!foundMember.isPresent()) {
            throw new IllegalArgumentException();
        }
        MemberVO updated = foundMember.get();
        modelMapper.map(memberDTO, updated);
        memberDAO.update(updated);
    }

    @Override
    @Transactional
    public void remove(String mid) throws Exception {
        memberDAO.delete(mid);
    }
}
