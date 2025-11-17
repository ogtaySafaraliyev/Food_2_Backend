package com.food2.dto.settingTranslation;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SettingTranslationCreateDto {
    private String lang;
    private String value;
}
