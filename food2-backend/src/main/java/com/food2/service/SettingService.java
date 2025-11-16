package com.food2.service;

import com.food2.dto.dto.setting.SettingResponseDto;
import com.food2.dto.setting.SettingCreateDto;
import com.food2.dto.setting.SettingUpdateDto;

import java.util.List;

public interface SettingService {
    SettingResponseDto create(SettingCreateDto dto);

    SettingResponseDto update(Long id, SettingUpdateDto dto);

    List<SettingResponseDto> getAll();

    SettingResponseDto getById(Long id);

    void delete(Long id);
}
