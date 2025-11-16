package com.food2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(updatable=false)
    private LocalDateTime createdAt;

    private LocalDateTime deletedAt;

//    public void softDelete() {
//        this.deletedAt = LocalDateTime.now();
//    }

    public boolean isDeleted() {
        return this.deletedAt != null;
    }
}
