package com.demirturk.cms.model.dto;

import com.demirturk.cms.base.entity.dto.BaseEntityDto;
import com.demirturk.cms.enums.ArticleType;
import io.swagger.annotations.ApiModel;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Article Data Transfer Object")
public class ArticleDto extends BaseEntityDto {
    private Long id;
    private ArticleType articleType;
    private LargeTextDto content;
    private String title;
    private String keywords;
    private String description;
    private String author;
    private String name;
    private String url;
    private CategoryDto category;
    private ArticleTemplateDto articleTemplate;

}
