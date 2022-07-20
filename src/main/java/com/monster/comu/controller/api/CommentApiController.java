package com.monster.comu.controller.api;

import com.monster.comu.config.auth.PrincipalDetail;
import com.monster.comu.domain.comment.Comment;
import com.monster.comu.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CommentApiController {

    private final CommentService commentService;

    @PostMapping("/api/v1/post/{postId}/comment")
    public void save(@PathVariable Long postId,
                     @RequestBody Comment comment,
                     @AuthenticationPrincipal PrincipalDetail principalDetail) {
        commentService.commentSave(postId, comment, principalDetail.getUser());
    }

    @DeleteMapping("/api/v1/post/{postId}/comment/{commentId}")
    public void delete(@PathVariable Long commentId) {
        commentService.commentDelete(commentId);
    }
}
