package com.demirturk.cms.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Article Template Data Transfer Object")
public class ArticleTemplateDto {
    @ApiModelProperty(required = true, value = "Id")
    private Long id;

    @ApiModelProperty(required = true, value = "Name")
    @NotNull
    private String name;

    @ApiModelProperty(required = true, value = "Url")
    @NotNull
    private String url;

    @ApiModelProperty(required = true, value = "Category Template Dto")
    private CategoryTemplateDto categoryTemplate;

    @ApiModelProperty(required = true, value = "Is Use Category?")
    private boolean isUseCategory;

}
