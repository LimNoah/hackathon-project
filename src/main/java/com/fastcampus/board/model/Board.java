package com.fastcampus.board.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Board {
    // 게시판 필요한거 : 글 작성자, 글제목, 글날짜, 글 내용, 등록일, 수정일
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // postid, pid, 게시글id
    private String writer; // 작성자
    private String title; // 제목
    private String content; // 내용
    private LocalDate rDate; // 등록일
    private LocalDate mDate; // 수정일

// 한 사용자 다수의 게시글
}