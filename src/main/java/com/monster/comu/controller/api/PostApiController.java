package com.monster.comu.controller.api;


import com.monster.comu.config.auth.PrincipalDetail;
import com.monster.comu.dto.post.PostSaveRequestDto;
import com.monster.comu.dto.post.PostUpdateRequestDto;
import com.monster.comu.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostService postService;

    @PostMapping("/api/v1/post")
    public Long save(@RequestBody PostSaveRequestDto postSaveRequestDto, @AuthenticationPrincipal PrincipalDetail principalDetail) {
        return postService.save(postSaveRequestDto, principalDetail.getUser());
    }

    @DeleteMapping("/api/v1/post/{id}")
    public Long deleteById(@PathVariable Long id) {
        postService.deleteById(id);
        return id;
    }

    @PutMapping("/api/v1/post/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostUpdateRequestDto postUpdateRequestDto) {
        return postService.update(id, postUpdateRequestDto);
    }
}
