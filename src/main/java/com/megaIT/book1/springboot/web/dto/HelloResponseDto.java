package com.megaIT.book1.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HelloResponseDto {
    // lombok 사용할 때 final 사용가능
    // final with method -> 오버라이딩 X, final with class -> 상속 X
    private final String name;
    private final int amount;
}
