package com.demirturk.cmscontentservice.entity.article;

import com.demirturk.cmscontentservice.entity.LargeText;
import com.demirturk.cmscommons.enums.ArticleType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "article")
@Getter
@Setter
@AllArgsConstructor
@DiscriminatorValue(value = ArticleType.Values.SINGLE_PAGE_ARTICLE)
public class SinglePageArticle  extends Article{

    @Builder(builderMethodName = "singlePageArticle")
    public SinglePageArticle(Long id, LargeText content, String title, String keywords, String description, String author, String name, String url) {
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
