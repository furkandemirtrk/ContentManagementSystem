package com.demirturk.cms.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.demirturk.cms.base.entity.BaseEntity;

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
@Audited
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

    @ManyToOne(fetch = FetchType.LAZY)
    private CategoryTemplate categoryTemplate;

}
