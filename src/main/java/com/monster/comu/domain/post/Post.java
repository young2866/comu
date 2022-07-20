package com.monster.comu.domain.post;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.monster.comu.domain.BaseTimeEntity;
import com.monster.comu.domain.comment.Comment;
import com.monster.comu.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob
    private String content;

    private int view;

    @OrderBy("id desc")
    @JsonIgnoreProperties({"post"})
    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Comment> commentList;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user;

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
