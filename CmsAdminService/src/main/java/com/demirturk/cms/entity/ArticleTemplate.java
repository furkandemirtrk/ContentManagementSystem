package com.demirturk.cms.entity;

import com.demirturk.cms.base.entity.BaseEntity;
import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Table(name = "article_template")
@Entity
@Audited
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

    @JoinColumn(nullable = false)
    @OneToOne
    private CategoryTemplate categoryTemplate;
}
