package com.demirturk.cmscontentservice.model.dto;

import com.demirturk.cmscommons.entity.dto.BaseEntityDto;
import com.demirturk.cmscommons.enums.ArticleType;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
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
