package com.example;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.jasper.servlet.JspServlet;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class JspAppMain {

    public static void main(String[] args) throws LifecycleException {
        // 创建Tomcat实例
        Tomcat tomcat = new Tomcat();
        
        // 设置端口
        tomcat.setPort(8080);
        
        // 设置临时目录
        tomcat.setBaseDir(System.getProperty("java.io.tmpdir"));
        
        // 获取webapp目录
        String webappDir = prepareWebappDir();
        Context context = tomcat.addWebapp("", new File(webappDir).getAbsolutePath());
        
        // 配置JSP servlet
        Wrapper jspWrapper = Tomcat.addServlet(context, "jsp", new JspServlet());
        jspWrapper.addInitParameter("fork", "false");
        jspWrapper.addInitParameter("development", "false");
        jspWrapper.addInitParameter("classdebuginfo", "true");
        context.addServletMappingDecoded("*.jsp", "jsp");
        context.addServletMappingDecoded("*.jspx", "jsp");
        
        // 添加HelloServlet
        Tomcat.addServlet(context, "helloServlet", new HelloServlet());
        context.addServletMappingDecoded("/hello", "helloServlet");
        
        // 启动Tomcat
        tomcat.start();
        
        System.out.println("JSP应用已在 http://localhost:8080 启动");
        System.out.println("按 Ctrl+C 停止服务");
        
        // 保持程序运行
        tomcat.getServer().await();
    }
    
    private static String prepareWebappDir() {
        try {
            // 创建临时目录来存放webapp资源
            Path tempDir = Paths.get(System.getProperty("java.io.tmpdir"), "jsp-app-webapp");
            Files.createDirectories(tempDir);
            
            // 获取类路径中的webapp资源并复制到临时目录
            // 复制index.jsp
            Path indexPath = tempDir.resolve("index.jsp");
            Files.copy(
                JspAppMain.class.getClassLoader().getResourceAsStream("webapp/index.jsp"),
                indexPath,
                StandardCopyOption.REPLACE_EXISTING
            );
            
            // 创建WEB-INF目录
            Path webInfDir = tempDir.resolve("WEB-INF");
            Files.createDirectories(webInfDir);
            
            // 复制web.xml
            Path webXmlPath = webInfDir.resolve("web.xml");
            Files.copy(
                JspAppMain.class.getClassLoader().getResourceAsStream("webapp/WEB-INF/web.xml"),
                webXmlPath,
                StandardCopyOption.REPLACE_EXISTING
            );
            
            return tempDir.toString();
        } catch (Exception e) {
            System.err.println("无法准备webapp目录: " + e.getMessage());
            e.printStackTrace();
            
            // 返回一个默认的临时目录
            try {
                Path tempDir = Paths.get(System.getProperty("java.io.tmpdir"), "jsp-app-webapp");
                Files.createDirectories(tempDir);
                return tempDir.toString();
            } catch (Exception ex) {
                ex.printStackTrace();
                return System.getProperty("java.io.tmpdir");
            }
        }
    }
}