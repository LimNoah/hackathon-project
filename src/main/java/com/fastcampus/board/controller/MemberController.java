package com.fastcampus.board.controller;

import com.fastcampus.board.dto.MemberDto;
import com.fastcampus.board.model.Board;
import com.fastcampus.board.model.Member;
import com.fastcampus.board.repository.BoardRepository;
import com.fastcampus.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private MemberRepository memberRepository;
    private BoardRepository boardRepository;

    @PostMapping("/api/login")
    public void login(@RequestBody @Valid MemberDto memberDto){
        Member member = memberRepository.findByUserId(memberDto.getUserId());
        System.out.println("member >>> " + member);
        System.out.println("memberDto >>> " + memberDto);
        if(member.getPassword() == memberDto.getPassword()){

        }
    }
}
