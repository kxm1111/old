@echo off
chcp 65001 >nul
echo ========================================
echo   Tomcat 11 Demo 启动脚本
echo ========================================
echo.

REM 检查 Java 是否安装
java -version >nul 2>&1
if %errorlevel% neq 0 (
    echo [错误] 未检测到 Java，请先安装 Java 17 或更高版本
    pause
    exit /b 1
)

echo [信息] 正在启动 Tomcat 11...
echo [信息] 端口：80
echo.
echo 访问地址:
echo   - 首页：http://localhost:80/index.jsp
echo   - Servlet: http://localhost:80/a
echo.
echo 按 Ctrl+C 停止服务器
echo ========================================
echo.

REM 运行可执行 JAR
java -jar target\tomcat11-demo-1.0-SNAPSHOT.jar

pause
