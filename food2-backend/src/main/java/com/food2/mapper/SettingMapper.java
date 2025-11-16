package com.food2.mapper;


import com.food2.dto.dto.setting.SettingResponseDto;
import com.food2.dto.setting.SettingCreateDto;
import com.food2.dto.setting.SettingUpdateDto;
import com.food2.entity.Setting;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring",  uses = {SettingTranslationMapper.class})
public interface SettingMapper {
    Setting toEntity(SettingCreateDto settingCreateDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "translations", ignore = true)
    void updateEntityFromDto(SettingUpdateDto dto, @MappingTarget Setting setting);

    SettingResponseDto toResponseDto(Setting setting);
}
