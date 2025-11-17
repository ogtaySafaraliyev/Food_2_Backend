package com.food2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food2.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}