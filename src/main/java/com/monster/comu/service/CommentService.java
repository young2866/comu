package com.monster.comu.service;

import com.monster.comu.domain.comment.Comment;
import com.monster.comu.domain.comment.CommentRepository;
import com.monster.comu.domain.post.Post;
import com.monster.comu.domain.post.PostRepository;
import com.monster.comu.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Transactional
    public void commentSave(Long postId, Comment comment, User user) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("해당 postId가 없습니다. id=" + postId));
        comment.save(post, user);
        commentRepository.save(comment);
    }

    public void commentDelete(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
