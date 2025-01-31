package com.pkx.code.build;

import java.util.Map;

/****
 * @Author: PKXING
 * @Description:Controller构建
 * @Date  PKXING 19:13
 *****/
public class ControllerBuilder {

    /***
     * 构建Controller
     * @param modelMap
     */
    public static void builder(Map<String,Object> modelMap){
        // 生成Controller层文件
        BuilderFactory.builder(modelMap,
                "/template/controller",
                "Controller.java",
                TemplateBuilder.PACKAGE_CONTROLLER,
                "Controller.java");
    }

}
