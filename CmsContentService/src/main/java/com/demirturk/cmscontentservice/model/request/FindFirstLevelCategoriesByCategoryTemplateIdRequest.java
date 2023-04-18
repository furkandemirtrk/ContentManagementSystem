package com.demirturk.cmscontentservice.model.request;

import lombok.Data;

@Data
public class FindFirstLevelCategoriesByCategoryTemplateIdRequest {
    private Long categoryTemplateId;
}
