package com.monster.comu.domain.comment;

import com.monster.comu.domain.BaseTimeEntity;
import com.monster.comu.domain.post.Post;
import com.monster.comu.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String content;

    @ManyToOne
    @JoinColumn(name = "boardId")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public void save(Post post, User user) {
        this.post = post;
        this.user = user;
    }
}
