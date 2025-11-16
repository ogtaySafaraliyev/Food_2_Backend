package com.food2.dto.dto.setting;


import com.food2.dto.setting.settingTranslation.SettingTranslationResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

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
