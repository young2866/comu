package com.monster.comu.controller;

import com.monster.comu.domain.post.Post;
import com.monster.comu.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostService postService;

    @GetMapping("/")
    public String index(Model model, @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC)Pageable pageable
                        , @RequestParam(required = false, defaultValue = "") String search) {
        Page<Post> posts = postService.findByTitleContainingOrContentContaining(search, search, pageable);
        int startPage = Math.max(1, posts.getPageable().getPageNumber() - 4);
        int endPage = Math.min(posts.getTotalPages(), posts.getPageable().getPageNumber() + 4);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("posts", posts);
        return "index";
    }
}
