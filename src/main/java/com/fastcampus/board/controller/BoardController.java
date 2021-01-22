package com.fastcampus.board.controller;

import com.fastcampus.board.model.Board;
import com.fastcampus.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardRepository boardRepository;
    // private final BoardService boardService;

    @GetMapping("/api/posts")
    public List<Board> getList() {
        return boardRepository.findAll();

        // 만약 리턴했는데 리스트가 아무것도 없다면 ??
        // null 체크 -> 예ㅊ외처리 필요
    }
}
