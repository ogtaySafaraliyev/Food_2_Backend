package com.food2.repository;

import com.food2.entity.Setting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingRepository extends JpaRepository<Setting, Long> {
}
