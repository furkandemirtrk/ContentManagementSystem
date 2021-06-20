package com.demirturk.cms.entity;

import com.demirturk.cms.base.entity.BaseEntity;
import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Table(name = "category_template")
@Entity
@Audited
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
