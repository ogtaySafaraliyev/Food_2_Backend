package com.food2.dto.setting;


import com.food2.dto.setting.settingTranslation.SettingTranslationUpdateDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
