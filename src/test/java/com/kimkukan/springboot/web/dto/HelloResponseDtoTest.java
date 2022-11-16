package com.kimkukan.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat; //테스트검증 라이브러리

public class HelloResponseDtoTest {

    @Test
    public void lombok_test(){
        String name = "testdd";
        int amount = 181818;

        HelloResponseDto dto = new HelloResponseDto(name, amount);

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
