package com.example;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.scan.StandardJarScanner;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        // 创建 Tomcat 实例
        Tomcat tomcat = new Tomcat();
        
        // 设置端口号为 8080
        tomcat.setPort(8080);
        
        // 获取当前工作目录作为基础目录
        String baseDir = System.getProperty("user.dir");
        File baseDirFile = new File(baseDir);
        
        // 设置 Tomcat 的基础目录
        tomcat.setBaseDir(baseDirFile.getAbsolutePath());
        
        // 创建 webapp 目录
        String webappDir = baseDirFile.getAbsolutePath() + File.separator + "src" + File.separator + "main" + File.separator + "webapp";
        File webappDirFile = new File(webappDir);
        
        if (!webappDirFile.exists()) {
            webappDirFile.mkdirs();
        }
        
        // 添加上下文路径为根路径的 web 应用（使用空字符串避免警告）
        Context context = tomcat.addWebapp("", webappDirFile.getAbsolutePath());

        // 配置 JSP Servlet 支持
        try {
            // 启用 JSP 编译
            StandardJarScanner jarScanner = (StandardJarScanner) context.getJarScanner();
            jarScanner.setScanAllDirectories(true);
            
            System.out.println("Tomcat 11 启动成功！");
            System.out.println("访问地址：http://localhost:8080/");
            System.out.println("index.jsp: http://localhost:8080/index.jsp");
            System.out.println("Servlet /a: http://localhost:8080/a");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // 启动 Tomcat
        try {
            tomcat.start();
            // 阻塞主线程，保持 Tomcat 运行
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
