package com.demirturk.cms.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Category Data Transfer Object")
public class CategoryDto {
    @ApiModelProperty(required = true, value = "Id")
    private Long id;

    @ApiModelProperty(required = true, value = "Name")
    @NotNull
    private String name;

    @ApiModelProperty(required = true, value = "url")
    @NotNull
    private String url;

    @ApiModelProperty(value = "Parent Category")
    private CategoryDto parentCategory;


    @ApiModelProperty(value = "Category Template")
    private CategoryTemplateDto categoryTemplate;
}
