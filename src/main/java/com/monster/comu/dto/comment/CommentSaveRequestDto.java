package com.monster.comu.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentSaveRequestDto {
    private Long userId;
    private Long postId;
    private String content;
}
