package com.monster.comu.controller.api;


import com.monster.comu.config.auth.PrincipalDetail;
import com.monster.comu.domain.user.User;
import com.monster.comu.dto.user.UserSaveRequestDto;
import com.monster.comu.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @PostMapping("/auth/api/v1/user")
    public Long save(@RequestBody UserSaveRequestDto userSaveRequestDto) {
        return userService.save(userSaveRequestDto.toEntity());
    }

    @PutMapping("api/v1/user")
    public Long update(@RequestBody User user, @AuthenticationPrincipal PrincipalDetail principalDetail) {
        userService.update(user, principalDetail);
        return user.getId();
    }

    @PostMapping("/auth/idCheck")
    public boolean checkUsernameDuplicate(@RequestBody UserSaveRequestDto userSaveRequestDto) {
        return userService.existsByUsername(userSaveRequestDto.getUsername());
    }
}
