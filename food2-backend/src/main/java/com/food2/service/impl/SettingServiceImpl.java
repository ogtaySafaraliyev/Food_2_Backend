package com.food2.service.impl;

import com.food2.dto.setting.SettingCreateDto;
import com.food2.dto.setting.SettingResponseDto;
import com.food2.dto.setting.SettingUpdateDto;
import com.food2.dto.settingTranslation.SettingTranslationUpdateDto;
import com.food2.entity.Language;
import com.food2.entity.Setting;
import com.food2.entity.SettingTranslation;
import com.food2.exception.ResourceNotFoundException;
import com.food2.mapper.SettingMapper;
import com.food2.mapper.SettingTranslationMapper;
import com.food2.repository.LanguageRepository;
import com.food2.repository.SettingRepository;
import com.food2.repository.SettingTranslationRepository;
import com.food2.service.SettingService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class SettingServiceImpl implements SettingService {

    private final SettingRepository settingRepository;
    private final SettingTranslationRepository translationRepository;
    private final LanguageRepository languageRepository;

    private final SettingMapper mapper;
    private final SettingTranslationMapper translationMapper;

    @Override
    public SettingResponseDto create(SettingCreateDto dto) {
        Setting setting  = mapper.toEntity(dto);

        List<SettingTranslation> translations = dto.getTranslations()
                .stream()
                .map(t -> {
                    SettingTranslation st = new SettingTranslation();
                    st.setValue(t.getValue());

                    Language lang = languageRepository.findByCode(t.getLang())
                            .orElseThrow(() -> new ResourceNotFoundException("Language not found: " + t.getLang()));

                    st.setLang(lang);
                    st.setSetting(setting);
                    return st;
                })
                .toList();

        setting.setTranslations(translations);

        Setting saved = settingRepository.save(setting);

        return mapper.toResponseDto(saved);
    }


    @Override
    public SettingResponseDto update(Long id, SettingUpdateDto dto) {
        Setting setting = settingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Setting not found"));

        mapper.updateEntityFromDto(dto, setting);

        if (dto.getTranslations() != null) {
            updateTranslations(setting, dto.getTranslations());
        }

        Setting saved = settingRepository.save(setting);
        return mapper.toResponseDto(saved);
    }

    private void updateTranslations(Setting setting, List<SettingTranslationUpdateDto> translations) {

        Map<String, SettingTranslation> existing = setting.getTranslations()
                .stream()
                .collect(Collectors.toMap(
                        st -> st.getLang().getCode(),
                        st -> st
                ));

        for (SettingTranslationUpdateDto t : translations) {

            SettingTranslation existingTranslation = existing.get(t.getLang());

            Language lang = languageRepository.findByCode(t.getLang())
                    .orElseThrow(() -> new ResourceNotFoundException("Language not found: " + t.getLang()));

            if (existingTranslation != null) {
                existingTranslation.setValue(t.getValue());
            } else {
                SettingTranslation newTr = new SettingTranslation();
                newTr.setLang(lang);
                newTr.setSetting(setting);
                newTr.setValue(t.getValue());
                setting.getTranslations().add(newTr);
            }
        }
    }



    @Override
    public List<SettingResponseDto> getAll() {
        return settingRepository.findAll().stream()
                .map(mapper::toResponseDto)
                .toList();
    }

    @Override
    public SettingResponseDto getById(Long id) {
        return mapper.toResponseDto(settingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Setting not found")));
    }

    @Override
    public void delete(Long id) {
        Setting setting = settingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Setting not found"));
        settingRepository.delete(setting);
    }
}
