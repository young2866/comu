package com.monster.comu.dto.user;

import com.monster.comu.domain.user.Role;
import com.monster.comu.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class UserSaveRequestDto {

    private String username;
    private String password;
    private String email;
    private String nickname;
    private Role role;

    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .nickname(nickname)
                .role(Role.USER)
                .build();
    }
    @Getter
    public static class Response implements Serializable {

        private final Long id;
        private final String username;
        private final String nickname;
        private final String email;
        private final Role role;
        private final String modifiedDate;

        /* Entity -> dto */
        public Response(User user) {
            this.id = user.getId();
            this.username = user.getUsername();
            this.nickname = user.getNickname();
            this.email = user.getEmail();
            this.role = user.getRole();
            this.modifiedDate = user.getModifiedDate();
        }
    }
}
