package com.food2.mapper;

import com.food2.dto.setting.settingTranslation.*;
import com.food2.entity.SettingTranslation;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface SettingTranslationMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "lang", ignore = true)
    SettingTranslation toEntity(SettingTranslationCreateDto dto);


    @Mapping(target = "lang", source = "lang.code")
    SettingTranslationResponseDto toResponseDto(SettingTranslation entity);

//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    void updateEntityFromDto(SettingTranslationUpdateDto dto, @MappingTarget SettingTranslation entity);
}
