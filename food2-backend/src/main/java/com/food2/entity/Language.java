package com.food2.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "languages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "update languages set deleted_at = now() where id=?")
@Where(clause = "deleted_at is null")
public class Language extends BaseEntity {
    @Column(unique = true, nullable = false, length = 10)
    private String code;

    private String name;
    private String image;
}
