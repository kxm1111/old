# Tomcat 11 Demo - Maven 项目

## 项目特性
- ✅ 内嵌 Tomcat 11
- ✅ 端口号：80
- ✅ index.jsp 输出：你好世界
- ✅ Servlet 访问路径 /a，页面输出：a 页面
- ✅ 打包为可执行 JAR 文件

## 项目结构
```
tomcat11-demo/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── example/
│       │           ├── Main.java          # 主启动类
│       │           └── AServlet.java      # Servlet 处理器
│       └── webapp/
│           ├── WEB-INF/
│           │   └── web.xml               # Web 应用配置
│           └── index.jsp                 # 首页 JSP
├── pom.xml                               # Maven 配置
└── README.md                             # 说明文档
```

## 构建和运行

### 方式一：使用 Maven 命令

1. **构建项目**
   ```bash
   mvn clean package
   ```

2. **运行可执行 JAR**
   ```bash
   java -jar target/tomcat11-demo-1.0-SNAPSHOT.jar
   ```

3. **访问应用**
   - 首页：http://localhost:80/index.jsp（显示：你好世界）
   - Servlet 页面：http://localhost:80/a（显示：a 页面）

### 方式二：在 IDE 中运行

直接在 IDE 中运行 `com.example.Main` 类的 main 方法。

## 技术栈
- Java 17
- Apache Tomcat 11.0.0 (内嵌)
- Maven 3.x
- Jakarta Servlet 6.0
- JSP (JavaServer Pages)

## 注意事项

⚠️ **端口权限问题**：
- 端口 80 是系统保留端口，在某些操作系统上可能需要管理员权限
- Windows：以管理员身份运行命令提示符
- Linux/Mac：使用 `sudo` 或在启动命令前添加管理员权限

如果遇到端口占用问题，可以修改 `Main.java` 中的端口号：
```java
tomcat.setPort(8080); // 改为其他端口
```

## 依赖说明
- `tomcat-embed-core`: Tomcat 11 核心功能
- `tomcat-embed-jasper`: JSP 编译支持
- `tomcat-embed-el`: 表达式语言支持
- Maven Shade Plugin: 打包成可执行 JAR

## 测试验证
启动成功后，您应该看到以下控制台输出：
```
Tomcat 11 启动成功！
访问地址：http://localhost:80/
index.jsp: http://localhost:80/index.jsp
Servlet /a: http://localhost:80/a
```
