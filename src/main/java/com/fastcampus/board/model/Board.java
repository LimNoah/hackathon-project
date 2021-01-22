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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // postid, pid, 게시글id
    private String writer; // 작성자
    private String title; // 제목
    private String content; // 내용
    private LocalDate rDate; // 등록일

    // 한 사용자 다수의 게시글

    public static Board emptyObject() {
        return new Board();
    }

}
