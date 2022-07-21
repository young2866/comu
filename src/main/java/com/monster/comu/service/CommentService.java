package com.monster.comu.service;

import com.monster.comu.domain.comment.Comment;
import com.monster.comu.domain.comment.CommentRepository;
import com.monster.comu.domain.post.Post;
import com.monster.comu.domain.post.PostRepository;
import com.monster.comu.domain.user.User;
import com.monster.comu.domain.user.UserRepository;
import com.monster.comu.dto.comment.CommentSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Transactional
    public void commentSave(CommentSaveRequestDto commentSaveRequestDto) {
        Post post = postRepository.findById(commentSaveRequestDto.getPostId())
                .orElseThrow(() -> new IllegalArgumentException("해당 postId가 없습니다. id=" + commentSaveRequestDto.getPostId()));

        User user = userRepository.findById(commentSaveRequestDto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("해당 userId가 없습니다. id=" + commentSaveRequestDto.getUserId()));

        Comment comment = Comment.builder()
                .user(user)
                .post(post)
                .content(commentSaveRequestDto.getContent())
                .build();


        commentRepository.save(comment);
    }

    public void commentDelete(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
