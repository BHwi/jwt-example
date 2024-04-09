package com.nhnacademy.auth.user.controller;

import com.nhnacademy.auth.user.dto.MemberCreateDto;
import com.nhnacademy.auth.user.entity.Member;
import com.nhnacademy.auth.user.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/member/{id}")
    public Member getMember(@PathVariable Long id, HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        return memberService.getMemberBySelf(id, token);
    }

    @PostMapping("/member/create")
    public Member createMember(@RequestBody MemberCreateDto memberCreateDto) {
        Member member = memberService.createMember(memberCreateDto);
        return member;
    }

    @PutMapping("/member/{id}")
    public Member updateMember(@PathVariable Long id,@RequestBody MemberCreateDto memberCreateDto) {
        Member member = memberService.modifyMember(id,memberCreateDto);
        return member;
    }

    @PutMapping("/member/delete/{id}")
    public Member deleteMember(@PathVariable Long id) {
        return memberService.deleteMember(id);
    }
}
