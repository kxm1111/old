@echo off
echo ====================================
echo Starting Tomcat 11 Demo
echo ====================================
echo.

cd /d %~dp0

if exist target (
    echo Running from JAR...
    for /f "delims=" %%i in ('dir /b target\tomcat11-demo-*.jar') do set JAR_FILE=%%i
    if defined JAR_FILE (
        java -jar target\%JAR_FILE%
    ) else (
        echo Error: No JAR file found in target directory
        pause
        exit /b 1
    )
) else (
    echo Error: Please build the project first using 'mvn package'
    echo Run: mvn clean package
    pause
    exit /b 1
)

pause
