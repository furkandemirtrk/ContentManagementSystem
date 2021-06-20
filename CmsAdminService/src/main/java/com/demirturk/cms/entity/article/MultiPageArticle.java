package com.demirturk.cms.entity.article;

import com.demirturk.cms.entity.ArticleTemplate;
import com.demirturk.cms.entity.Category;
import com.demirturk.cms.enums.ArticleType;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "article")
@Getter
@Setter
@AllArgsConstructor
@DiscriminatorValue(value = ArticleType.Values.MULTI_PAGE_ARTICLE)
@NoArgsConstructor
public class MultiPageArticle extends Article {

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @ManyToOne
    private ArticleTemplate articleTemplate;

    @Builder(builderMethodName = "multiPageBuilder")
    public MultiPageArticle(Long id, String content, String title, String keywords, String description, String author, String name, String url, Category category, ArticleTemplate articleTemplate) {
        super(id, content, title, keywords, description, author, name, url);
        this.setId(id);
        this.setContent(content);
        this.setTitle(title);
        this.setKeywords(keywords);
        this.setDescription(description);
        this.setAuthor(author);
        this.setName(name);
        this.setUrl(url);
        this.setCategory(category);
        this.setArticleTemplate(articleTemplate);
    }
}
