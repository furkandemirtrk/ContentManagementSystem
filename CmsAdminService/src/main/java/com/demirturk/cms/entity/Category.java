package com.demirturk.cms.entity;

import com.demirturk.cms.base.entity.BaseEntity;
import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Audited
@Table(name = "category")
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter
@Setter
public class Category  extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category parentCategory;

    @OneToMany(cascade={CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "parentCategory")
    private Set<Category> childCategorySet = new HashSet<>();

    @Column(unique = true, nullable = false)
    private String url;

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    private CategoryTemplate categoryTemplate;
}
