package com.demirturk.cmscontentservice.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArticleTemplateDto {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String url;
    private CategoryTemplateDto categoryTemplate;
    private boolean isUseCategory;

}
