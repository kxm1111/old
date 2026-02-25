package com.example;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        // 创建嵌入式Tomcat实例
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        // 创建上下文路径
        String contextPath = "";
        String docBase = new File(".").getAbsolutePath();

        Context ctx = tomcat.addContext(contextPath, docBase);

        // 注册Servlet到/xm路径
        Tomcat.addServlet(ctx, "xmServlet", new XmServlet());
        ctx.addServletMappingDecoded("/xm", "xmServlet");

        // 启动Tomcat
        tomcat.start();
        System.out.println("Tomcat started, access: http://localhost:8080/xm");
        System.out.println("Press Ctrl+C to stop...");

        // 保持运行
        tomcat.getServer().await();
    }
}
