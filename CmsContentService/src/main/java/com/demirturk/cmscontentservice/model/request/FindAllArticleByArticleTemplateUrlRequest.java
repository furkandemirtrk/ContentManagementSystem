package com.demirturk.cmscontentservice.model.request;

import lombok.Data;

@Data
public class FindAllArticleByArticleTemplateUrlRequest {
    private String url;
}
