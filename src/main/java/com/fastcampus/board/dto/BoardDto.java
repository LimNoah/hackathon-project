package com.fastcampus.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardDto {
    private Long id;
    @NotEmpty
    private String writer;
    @NotEmpty
    private String title;
    @NotEmpty
    private String content;
    private LocalDate rDate;

}
