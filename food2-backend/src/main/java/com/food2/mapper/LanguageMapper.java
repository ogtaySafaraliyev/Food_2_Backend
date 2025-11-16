package com.food2.mapper;

import com.food2.dto.language.LanguageCreateDto;
import com.food2.dto.language.LanguageResponseDto;
import com.food2.dto.language.LanguageUpdateDto;
import com.food2.entity.Language;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface LanguageMapper {

    Language toEntity (LanguageCreateDto languageCreateDto);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(LanguageUpdateDto dto,  @MappingTarget Language entity);

    LanguageResponseDto toResponseDto(Language entity);
}
