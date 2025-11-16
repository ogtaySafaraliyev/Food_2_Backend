package com.food2.controller;

import com.food2.dto.dto.setting.SettingResponseDto;
import com.food2.dto.setting.SettingCreateDto;
import com.food2.dto.setting.SettingUpdateDto;
import com.food2.service.SettingService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/api/settings")
@RequiredArgsConstructor
public class SettingController {

    private final SettingService service;

    @PostMapping
    public ResponseEntity<SettingResponseDto> save(@Valid @RequestBody SettingCreateDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SettingResponseDto> update(@PathVariable Long id, @Valid @RequestBody SettingUpdateDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @GetMapping
    public ResponseEntity<List<SettingResponseDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SettingResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SettingResponseDto> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
