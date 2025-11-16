package com.food2.dto.language;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LanguageResponseDto {
    private Long id;
    private String code;
    private String name;
    private String image;
    private LocalDateTime createdAt;
}
