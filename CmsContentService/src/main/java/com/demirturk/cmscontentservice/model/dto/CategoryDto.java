package com.demirturk.cmscontentservice.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String url;
    private CategoryDto parentCategory;
    private CategoryTemplateDto categoryTemplate;
}
