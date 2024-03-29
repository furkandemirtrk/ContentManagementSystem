package com.demirturk.cmscontentservice.entity.article;

import com.demirturk.cmscontentservice.entity.LargeText;
import com.demirturk.cmscommons.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import java.util.Objects;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DISCRIMINATOR_COLUMN",
        discriminatorType = DiscriminatorType.STRING)
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "article")
@Entity
//@Audited
public class Article extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn
    @OneToOne(cascade = CascadeType.ALL)
    private LargeText content;

    @Column
    private String title;

    @Column
    private String keywords;

    @Column
    private String description;

    @Column
    private String author;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String url;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        Article article = (Article) o;
        return id.equals(article.id) && name.equals(article.name) && url.equals(article.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, url);
    }
}
