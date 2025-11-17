package com.food2.dto.setting;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import com.food2.dto.settingTranslation.SettingTranslationUpdateDto;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SettingUpdateDto {
    private String key;
    private String type;
    private String group;

    private List<SettingTranslationUpdateDto> translations;
}
