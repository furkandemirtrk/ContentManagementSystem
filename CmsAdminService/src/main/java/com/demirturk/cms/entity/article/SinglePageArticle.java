package com.demirturk.cms.entity.article;

import com.demirturk.cms.enums.ArticleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "article")
@Getter
@Setter
@AllArgsConstructor
@DiscriminatorValue(value = ArticleType.Values.SINGLE_PAGE_ARTICLE)
public class SinglePageArticle  extends Article{

    @Builder(builderMethodName = "singlePageArticle")
    public SinglePageArticle(Long id, String content, String title, String keywords, String description, String author, String name, String url) {
        super(id, content, title, keywords, description, author, name, url);
        this.setId(id);
        this.setContent(content);
        this.setTitle(title);
        this.setKeywords(keywords);
        this.setDescription(description);
        this.setAuthor(author);
        this.setName(name);
        this.setUrl(url);
    }
}
