package com.monster.comu.service;


import com.monster.comu.domain.post.Post;
import com.monster.comu.domain.post.PostRepository;
import com.monster.comu.domain.user.User;
import com.monster.comu.dto.post.PostSaveRequestDto;
import com.monster.comu.dto.post.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long save(PostSaveRequestDto postSaveRequestDto, User user) {
        postSaveRequestDto.setUser(user);
        return postRepository.save(postSaveRequestDto.toEntity()).getId();
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Post detail(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 id가 없습니다. id=" + id));
    }

    @Transactional
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }

    @Transactional
    public Long update(Long id, PostUpdateRequestDto postUpdateRequestDto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 id가 없습니다 id=" + id));
        post.update(postUpdateRequestDto.getTitle(), postUpdateRequestDto.getContent());
        return id;
    }

    @Transactional
    public int updateView(Long id) {
        return postRepository.updateView(id);
    }

    @Transactional
    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Transactional
    public Page<Post> findByTitleContainingOrContentContaining(String title, String content, Pageable pageable) {
        return postRepository.findByTitleContainingOrContentContaining(title, content, pageable);
    }
}
