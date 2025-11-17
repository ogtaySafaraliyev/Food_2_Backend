package com.food2.dto.settingTranslation;

import com.food2.entity.Language;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SettingTranslationUpdateDto {

    @NotNull
    private String lang;

    @NotBlank
    private String value;
}
