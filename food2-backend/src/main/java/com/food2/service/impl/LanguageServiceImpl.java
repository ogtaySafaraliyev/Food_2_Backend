package com.food2.service.impl;

import com.food2.dto.language.LanguageCreateDto;
import com.food2.dto.language.LanguageResponseDto;
import com.food2.dto.language.LanguageUpdateDto;
import com.food2.entity.Language;
import com.food2.mapper.LanguageMapper;
import com.food2.repository.LanguageRepository;
import com.food2.service.LanguageService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository repository;
    private final LanguageMapper mapper;

    @Override
    public LanguageResponseDto create(LanguageCreateDto dto) {
        Language entity = mapper.toEntity(dto);
        return mapper.toResponseDto(repository.save(entity));
    }

    @Override
    public LanguageResponseDto update(Long id, LanguageUpdateDto dto) {
        Language language = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Language not found with id: " + id));

        mapper.updateEntityFromDto(dto, language);
        return mapper.toResponseDto(repository.save(language));
    }

    @Override
    public List<LanguageResponseDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public LanguageResponseDto getById(Long id) {
        return mapper.toResponseDto(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Language not found with id: " + id)));
    }

    @Override
    public void delete(Long id) {
        if(!repository.existsById(id)) {
            throw new RuntimeException("Language not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
