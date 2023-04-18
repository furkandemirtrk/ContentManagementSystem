package com.demirturk.cms.entity;

import java.util.HashSet;
import java.util.Set;

import com.demirturk.cmscommons.entity.BaseEntity;
import jakarta.persistence.*;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@EnableJpaAuditing
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Table(name = "menu")
@Entity
public class Menu extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String url;

    @Column
    private Integer sequence;

    @ManyToOne(fetch = FetchType.LAZY)
    private Menu parentMenu;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parentMenu", fetch = FetchType.LAZY)
    private Set<Menu> subMenuSet = new HashSet<>();

    @Column
    private boolean isCategories;

    private Long categoryTemplateId;

}
