package com.food2.dto.setting;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import com.food2.dto.settingTranslation.SettingTranslationCreateDto;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SettingCreateDto {

    @NotBlank
    private String key;

    @NotBlank
    private String type;

    @Size(max = 100)
    private String group;

    private List<SettingTranslationCreateDto> translations;}
