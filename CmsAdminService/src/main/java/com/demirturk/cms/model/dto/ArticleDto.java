package com.demirturk.cms.model.dto;

import com.demirturk.cms.enums.ArticleType;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Article Data Transfer Object")
public class ArticleDto {
    private Long id;
    private ArticleType articleType;
    private String content;
    private String title;
    private String keywords;
    private String description;
    private String author;
    private String name;
    private String url;
    private CategoryDto category;
    private ArticleTemplateDto articleTemplate;

}
