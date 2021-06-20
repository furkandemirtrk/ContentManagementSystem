package com.demirturk.cms.entity;

import com.demirturk.cms.base.entity.BaseEntity;
import lombok.*;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
}
