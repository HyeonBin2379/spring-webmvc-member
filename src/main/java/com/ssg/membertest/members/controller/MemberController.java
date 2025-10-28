package com.ssg.membertest.members.controller;

import com.ssg.membertest.members.dto.MemberDTO;
import com.ssg.membertest.members.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Log4j2
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/memberList")
    public void memberList(Model model) {
        List<MemberDTO> memberList = memberService.listAll();
        model.addAttribute("memberList", memberList);
    }

    @GetMapping("/register")
    public void registerGET() {

    }

    @PostMapping("/register")
    public String registerPost(MemberDTO memberDTO) {
        memberService.register(memberDTO);
        return "redirect:/memberList";
    }
}
