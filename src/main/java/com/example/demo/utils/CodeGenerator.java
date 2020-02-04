package com.example.demo.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.InjectionConfig;
//import com.baomidou.mybatisplus.generator.config.*;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//import static com.baomidou.mybatisplus.generator.config.rules.DateType.ONLY_DATE;

public class CodeGenerator {

//    public static String scanner(String tip) {
//        Scanner scanner = new Scanner(System.in);
//        StringBuilder help = new StringBuilder();
//        help.append("请输入" + tip + "：");
//        System.out.println(help.toString());
//        if (scanner.hasNext()) {
//            String ipt = scanner.next();
//            if (StringUtils.isNotEmpty(ipt)) {
//                return ipt;
//            }
//        }
//        throw new MybatisPlusException("请输入正确的" + tip + "！");
//    }
//
//
//    public static void main(String[] args) {
//        // 代码生成器
//        AutoGenerator mpg = new AutoGenerator();
//
//        // 全局配置
//        GlobalConfig gc = new GlobalConfig();
//        String projectPath = System.getProperty("user.dir") + File.separator + "enter";
//
//        String filePath = projectPath + "/src/main/java";
//        System.out.println("生成文件 的路径为：" + filePath);
//        gc.setOutputDir(filePath);
//
//        gc.setFileOverride(true);
//
//        gc.setOpen(false);
//        gc.setDateType(ONLY_DATE);
//        gc.setAuthor("daxue0929");// 作者
//
//        // 自定义文件命名，注意 %s 会自动填充表实体属性！
//        gc.setControllerName("%sController");
//        gc.setServiceName("%sService");
//        gc.setServiceImplName("%sServiceImpl");
//        gc.setMapperName("%sMapper");
//        gc.setXmlName("%sMapper");
//        mpg.setGlobalConfig(gc);
//
//
//
//        // 数据源配置
//        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setDriverName("com.mysql.jdbc.Driver");
//        dsc.setUsername("root");
//        dsc.setPassword("root");
//        dsc.setDbType(DbType.MYSQL);
//        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/demo");
//
//        // 包配置
//        final PackageConfig pc = new PackageConfig();
//        pc.setParent("com.example.demo");
////        dsc.setSchemaName("base");
//
//        mpg.setDataSource(dsc);
//
//        Map m = new HashMap();
//        m.put("entity_path", gc.getOutputDir() + File.separator + (pc.getParent().replaceAll("\\.", "\\" + File.separator)) + "/entity");
//        m.put("mapper_path", gc.getOutputDir() + File.separator + (pc.getParent().replaceAll("\\.", "\\" + File.separator)) + "/mapper");
//        m.put("service_path",gc.getOutputDir() + File.separator + (pc.getParent().replaceAll("\\.", "\\" + File.separator)) +"/service");
//        m.put("service_impl_path",gc.getOutputDir() + File.separator + (pc.getParent().replaceAll("\\.", "\\" + File.separator)) + "/service/impl");
//        m.put(ConstVal.CONTROLLER_PATH,gc.getOutputDir() + File.separator + (pc.getParent().replaceAll("\\.", "\\" + File.separator)) + "/controller");
//
//        m.put(ConstVal.XML_PATH,projectPath+"/src/main/resources/mapper/" + dsc.getSchemaName()); //对应xml文件的位置
//
//        pc.setPathInfo(m);
//
//        // 自定义配置
//        InjectionConfig cfg = new InjectionConfig() {
//            @Override
//            public void initMap() {
//                // to do nothing
//            }
//        };
//
//
//
//        cfg.setFileOutConfigList(null);
//        mpg.setCfg(cfg);
//        mpg.setPackageInfo(pc);
//        // 配置模板
//        TemplateConfig templateConfig = new TemplateConfig();
//
//        // 配置自定义输出模板
//        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
//        // templateConfig.setEntity("templates/entity2.java");
//        // templateConfig.setService();
//        // templateConfig.setController();
////        templateConfig.setXml(TEMPLATE_XML);
//        mpg.setTemplate(templateConfig);
//        // 策略配置
//        StrategyConfig strategy = new StrategyConfig();
//        strategy.setNaming(NamingStrategy.underline_to_camel);
//        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
////        strategy.setTablePrefix("platform");
//        //strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
//        strategy.setEntityLombokModel(true);
//        strategy.setRestControllerStyle(true);
//        // 写于父类中的公共字段
//        //strategy.setSuperEntityColumns("id");
//        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
////        strategy.setControllerMappingHyphenStyle(true);
////        strategy.setTablePrefix(pc.getModuleName() + "_");
//        mpg.setStrategy(strategy);
//
//        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
//        // 执行生成
//        mpg.execute();
//
//    }
//
//



}
