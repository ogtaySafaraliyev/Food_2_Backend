package com.food2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SQLDelete(sql = "update categories set deleted_at = now() where id=?")
@Where(clause = "deleted_at is null")
public class Category extends BaseEntity {

    private Long parentId;

    private String status;  //bunu enum da istifade ede bilerik-baxir veziyyete
}
