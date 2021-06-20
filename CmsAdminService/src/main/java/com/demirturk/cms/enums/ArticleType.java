package com.demirturk.cms.enums;

public enum ArticleType {
    SINGLE_PAGE_ARTICLE(Values.SINGLE_PAGE_ARTICLE), MULTI_PAGE_ARTICLE(Values.MULTI_PAGE_ARTICLE), ARTICLE(Values.ARTICLE);

    private final String name;

    private ArticleType(String name){
        this.name = name;
    }

    public static String getName(ArticleType articleType){return articleType.name;}

    public static class Values {
        private Values(){
        }
        public static final String SINGLE_PAGE_ARTICLE = "SINGLE_PAGE_ARTICLE";
        public static final String MULTI_PAGE_ARTICLE = "MULTI_PAGE_ARTICLE";
        public static final String ARTICLE = "ARTICLE";
    }
}
