package com.demirturk.cmscontentservice.entity;

import com.demirturk.cmscommons.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
@Table(name = "category_template")
@Entity
//@Audited
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter
@Setter
public class CategoryTemplate extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(nullable = false, unique = true)
    private String url;
}
