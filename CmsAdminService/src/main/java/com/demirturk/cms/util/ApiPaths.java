package com.demirturk.cms.util;

public class ApiPaths {
    public ApiPaths() {
    }

    private static final String BASE_PATH = "/api"; //NOSONAR

    public static final class CategoryTemplateController{
        public CategoryTemplateController() {
        }

        public static final String CONTROLLER = BASE_PATH + "/categoryTemplate";
        public static final String CHECK_URL = "/categoryTemplate";
        public static final String DELETE = "/delete";
        public static final String FIND_ALL_BY_ARTICLE_TEMPLATE_NOT_CHOOSE = "/findAllByArticleTemplateNotChoose";
        public static final String FIND_BY_URL = "/findByUrl";
    }

    public static final class CategoryController{
        public CategoryController() {
        }

        public static final String CONTROLLER = BASE_PATH + "/category";
        public static final String FIND_ALL_BY_PARENT_CATEGORY =  "/findAllByParentCategoryId";
        public static final String FIND_FIRST_LEVEL_CATEGORIES_BY_CATEGORY_TEMPLATE =  "/findFirstLevelCategoriesByCategoryTemplateId";
    }

    public static final class ArticleTemplateController{
        public ArticleTemplateController() {
        }

        public static final String CONTROLLER = BASE_PATH + "/articleTemplate";
        public static final String CHECK_URL ="/checkUrl";
        public static final String DELETE = "/delete";
    }

    public static final class ArticleController{
        public ArticleController() {
        }

        public static final String CONTROLLER = BASE_PATH + "/article";
        public static final String CHECK_URL ="/checkUrl";
        public static final String DELETE = "/delete";
        public static final String FIND_ALL_BY_ARTICLE_TEMPLATE = "/findAllByArticleTemplate";
    }

    public static final class MenuController{
        public MenuController() {
        }

        public static final String CONTROLLER = BASE_PATH + "/menu";
        public static final String CHECK_URL ="/checkUrl";
        public static final String DELETE = "/delete";
    }
}
