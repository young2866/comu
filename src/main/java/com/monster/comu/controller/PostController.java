package com.monster.comu.controller;

import com.monster.comu.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostService postService;

    @GetMapping("/post/save")
    public String save() {
        return "layout/post/post-save";
    }

    @GetMapping("/post/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("post", postService.detail(id));
        postService.updateView(id);
        return "layout/post/post-detail";
    }

    @GetMapping("/post/{id}/update")
    public String update(@PathVariable Long id, Model model) {
        model.addAttribute("post", postService.detail(id));
        return "layout/post/post-update";
    }
}
