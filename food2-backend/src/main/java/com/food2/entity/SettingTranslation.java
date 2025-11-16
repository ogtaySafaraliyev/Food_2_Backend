package com.food2.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "setting_translations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE setting_translations SET deleted_at = NOW() WHERE id=?")
@Where(clause = "deleted_at IS NULL")
public class SettingTranslation extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "setting_id", nullable = false)
    private Setting setting;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id", nullable = false)
    private Language lang;

    @Column(columnDefinition = "TEXT")
    private String value;
}
