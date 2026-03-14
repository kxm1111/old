@echo off
echo ====================================
echo Testing Tomcat 11 Demo
echo ====================================
echo.

echo Testing index.jsp...
curl http://localhost:8080/index.jsp
echo.
echo.

echo Testing Servlet /a...
curl http://localhost:8080/a
echo.
echo.

pause
