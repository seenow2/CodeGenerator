package com.pkx.code.build;

import java.util.Map;

/****
 * @Author: PKXING
 * @Description:Result构建
 * @Date  PKXING 19:13
 *****/
public class ResultBuilder {

    /***
     * 构建Pojo
     * @param dataModel
     */
    public static void builder(Map<String,Object> dataModel) {

        BuilderFactory.builder(dataModel,
                "/template/result",
                "Result.java",
                TemplateBuilder.PACKAGE_RESULT,
                ".java");

        BuilderFactory.builder(dataModel,
                "/template/result",
                "StatusCode.java",
                TemplateBuilder.PACKAGE_RESULT,
                ".java");
    }

}
