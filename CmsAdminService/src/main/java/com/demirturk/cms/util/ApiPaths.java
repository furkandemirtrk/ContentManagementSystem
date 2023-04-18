package com.demirturk.cms.util;

public class ApiPaths {
    public ApiPaths() {
    }

    private static final String BASE_PATH = "/api"; //NOSONAR

    public static final class MenuController{
        public MenuController() {
        }

        public static final String CONTROLLER = BASE_PATH + "/menu";
        public static final String CHECK_URL ="/checkUrl";
        public static final String DELETE = "/delete";
    }
}
