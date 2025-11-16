package com.food2.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "settings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE settings SET deleted_at = NOW() WHERE id=?")
@Where(clause = "deleted_at IS NULL")
public class Setting extends BaseEntity {

    @Column(name = "setting_key", nullable = false, unique = true, length = 100)
    private String key;

    @Column(nullable = false, length = 50)
    private String type;

    @Column(name = "group_name", length = 100)
    private String group;

    @OneToMany(mappedBy = "setting", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SettingTranslation> translations = new ArrayList<>();
}
