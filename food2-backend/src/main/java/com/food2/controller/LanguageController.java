package com.food2.controller;

import com.food2.dto.language.LanguageCreateDto;
import com.food2.dto.language.LanguageResponseDto;
import com.food2.dto.language.LanguageUpdateDto;
import com.food2.service.LanguageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
@RequiredArgsConstructor
public class LanguageController {

    private final LanguageService service;

    @PostMapping
    public ResponseEntity<LanguageResponseDto> create(@RequestBody LanguageCreateDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LanguageResponseDto> update(@PathVariable Long id, @RequestBody LanguageUpdateDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @GetMapping
    public ResponseEntity<List<LanguageResponseDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LanguageResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
