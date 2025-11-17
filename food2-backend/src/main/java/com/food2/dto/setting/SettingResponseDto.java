package com.food2.dto.setting;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

import com.food2.dto.settingTranslation.SettingTranslationResponseDto;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SettingResponseDto {
    private Long id;
    private String key;
    private String type;
    private String group;
    private LocalDateTime createdAt;
    private List<SettingTranslationResponseDto> translations;

}
