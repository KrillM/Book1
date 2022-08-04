package com.megaIT.book1.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void lombokTest(){
        String name = "test";
        int amount = 1000;

        HelloResponseDto hrd = new HelloResponseDto(name, amount);

        assertThat(hrd.getName()).isEqualTo(name);
        assertThat(hrd.getAmount()).isEqualTo(amount);
    }
}