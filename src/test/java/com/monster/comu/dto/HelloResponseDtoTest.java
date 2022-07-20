package com.monster.comu.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HelloResponseDtoTest {

    @Test
    public void lombok() {
        String name = "abc";
        String nickname = "def";

        HelloResponseDto helloResponseDto = new HelloResponseDto(name, nickname);

        assertThat(helloResponseDto.getName()).isEqualTo(name);
        assertThat(helloResponseDto.getNickname()).isEqualTo(nickname);
    }

}