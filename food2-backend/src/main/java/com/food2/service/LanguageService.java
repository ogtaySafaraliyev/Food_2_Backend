package com.food2.service;


import com.food2.dto.language.LanguageCreateDto;
import com.food2.dto.language.LanguageResponseDto;
import com.food2.dto.language.LanguageUpdateDto;

import java.util.List;

public interface LanguageService {

    LanguageResponseDto create(LanguageCreateDto dto);

    LanguageResponseDto update(Long id, LanguageUpdateDto dto);

    List<LanguageResponseDto> getAll();

    LanguageResponseDto getById(Long id);

    void delete(Long id);
}
