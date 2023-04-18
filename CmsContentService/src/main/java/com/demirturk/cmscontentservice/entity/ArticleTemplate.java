package com.demirturk.cmscontentservice.entity;

import com.demirturk.cmscommons.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "article_template")
@Entity
//@Audited
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter
@Setter
public class ArticleTemplate extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String url;

    @JoinColumn
    @OneToOne
    private CategoryTemplate categoryTemplate;

    @Column
    private boolean isUseCategory = false;
}
