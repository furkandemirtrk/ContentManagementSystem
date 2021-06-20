package com.demirturk.cms.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Category Template Data Transfer Object")
public class CategoryTemplateDto {
    @ApiModelProperty(required = true, value = "Id")
    private Long id;

    @ApiModelProperty(required = true, value = "Name")
    @NotNull
    private String name;

    @ApiModelProperty(required = true, value = "Url")
    @NotNull
    private String url;
}
