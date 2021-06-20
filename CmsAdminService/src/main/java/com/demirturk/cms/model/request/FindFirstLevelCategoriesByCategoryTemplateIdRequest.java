package com.demirturk.cms.model.request;

import lombok.Data;

@Data
public class FindFirstLevelCategoriesByCategoryTemplateIdRequest {
    private Long categoryTemplateId;
}
