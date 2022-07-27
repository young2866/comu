package com.monster.comu.domain.user;

import com.monster.comu.domain.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false, unique = true)
    private String username; // 유저의 아이디

    @Column(length = 100)
    private String password;

    @Column(nullable = false, unique = true)
    private String nickname;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }

    public void update(String password, String nickname) {
        this.password = password;
        this.nickname = nickname;
    }

    public User updateModifiedDate() {
        this.onPreUpdate();
        return this;
    }
}
