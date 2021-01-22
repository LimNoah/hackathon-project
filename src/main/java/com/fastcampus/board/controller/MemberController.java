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
    private final MemberRepository memberRepository;

    @PostMapping("/api/login")
    public void login(@RequestBody @Valid MemberDto memberDto){
        System.out.println("들어와라");
        Member member = memberRepository.findByUserId(memberDto.getUserId()).orElseThrow(()->new RuntimeException());
        System.out.println("member >>> " + member);
        System.out.println("memberDto >>> " + memberDto);
        if(member.getPassword() == memberDto.getPassword()){
            System.out.println("로그인 성공!");
        } else {
            System.out.println("로그인 실패!");
        }
    }

    @PostMapping("/api/join")
    public void join(@RequestBody @Valid MemberDto memberDto){
        Member member1 = new Member(
                null,
                memberDto.getUserId(),
                memberDto.getPassword(),
                memberDto.getName(),
                memberDto.getRole()
        );
        memberRepository.save(member1);
    }
}
