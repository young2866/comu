package com.monster.comu.dto.post;


import com.monster.comu.domain.post.Post;
import com.monster.comu.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostSaveRequestDto {

    private String title;
    private String content;
    private int view;
    private User user;

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .view(0)
                .user(user)
                .build();
    }

    public void setUser(User user) {
        this.user = user;
    }
}
