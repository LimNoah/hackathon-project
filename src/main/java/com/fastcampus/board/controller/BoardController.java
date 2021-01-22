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

    private BoardRepository boardRepository;

    @GetMapping("/api/boardList")
    public List<Board> getBoardList(){
        System.out.println(boardRepository.findAll());
        return boardRepository.findAll();
    }

}
