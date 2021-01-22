package com.fastcampus.board.controller;

import com.fastcampus.board.dto.BoardDto;
import com.fastcampus.board.model.Board;
import com.fastcampus.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @GetMapping("/api/post/{id}")
    public Board getBoard(@PathVariable Long id)  {
        Board getBoard = boardRepository.findById(id).orElse(Board.emptyObject());

        return getBoard;
    }

    @PostMapping("/api/post")
    public void writeBoard(@RequestBody @Valid BoardDto boardDto) {
        Board board = new Board(
                null,
                boardDto.getWriter(),
                boardDto.getTitle(),
                boardDto.getContent(),
                boardDto.getRDate()
        );
        boardRepository.save(board);
    }

    @PostMapping("/api/post/update")
    public void updateBoard(@RequestBody @Valid BoardDto boardDto) {
        Board updateBoard = boardRepository.findById(boardDto.getId()).orElseThrow(() -> new RuntimeException("post update failed"));

        updateBoard.setTitle(boardDto.getTitle());
        updateBoard.setContent(boardDto.getContent());

        boardRepository.save(updateBoard);
    }

    @DeleteMapping("/api/post/delete")
    public void deleteBoard(@RequestBody @Valid BoardDto boardDto) {
        Board delBoard = boardRepository.findById(boardDto.getId()).orElseThrow(() -> new RuntimeException("post delete failed"));

        boardRepository.delete(delBoard);
    }

}
