# Tomcat 11 Maven 项目

这是一个内嵌 Apache Tomcat 11 的 Maven 项目，支持 JSP 和 Servlet。

## 项目特性

- ✅ 内嵌 Tomcat 11.0.0
- ✅ 端口号：8080
- ✅ JSP 支持（index.jsp 输出"你好世界"）
- ✅ Servlet 支持（访问路径 /a 输出"a 页面"）
- ✅ 可执行 JAR 包打包

## 快速开始

### 1. 构建项目

```bash
mvn clean package
```

### 2. 运行项目

**方式一：使用启动脚本**
```bash
start.bat
```

**方式二：直接运行 JAR**
```bash
java -jar target\tomcat11-demo-1.0-SNAPSHOT.jar
```

**方式三：使用 Maven 运行**
```bash
mvn exec:java -Dexec.mainClass="com.example.Main"
```

### 3. 访问应用

- **首页（JSP）**: http://localhost:8080/index.jsp
- **A 页面（Servlet）**: http://localhost:8080/a

## 项目结构

```
tomcat11-demo/
├── src/
│   └── main/
│       ├── java/com/example/
│       │   ├── Main.java          # 主启动类
│       │   └── AServlet.java      # Servlet 示例
│       └── webapp/
│           └── index.jsp          # JSP 首页
├── pom.xml                        # Maven 配置
├── start.bat                      # Windows 启动脚本
└── README.md                      # 说明文档
```

## 技术栈

- Java 17
- Apache Tomcat 11.0.0
- Maven Shade Plugin（打包可执行 JAR）

## 打包说明

执行 `mvn clean package` 后，会在 `target` 目录生成可执行 JAR 包：
- `tomcat11-demo-1.0-SNAPSHOT.jar` - 包含所有依赖的可执行 JAR

## 注意事项

- 确保已安装 JDK 17+
- 确保已安装 Maven
- 端口 8080 未被占用
