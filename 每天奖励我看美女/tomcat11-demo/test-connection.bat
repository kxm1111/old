@echo off
chcp 65001 >nul
echo ========================================
echo   测试 Tomcat 连接
echo ========================================
echo.
echo 正在测试端口 80 是否监听...
netstat -ano | findstr ":80"
echo.
echo 如果看到 LISTENING 状态，说明端口正常
echo.
echo 正在尝试访问 localhost:80...
echo.

REM 使用 PowerShell 测试 HTTP 连接
powershell -Command "try { $response = Invoke-WebRequest -Uri 'http://localhost:80/' -TimeoutSec 5; Write-Host '成功！HTTP 状态码：' $response.StatusCode } catch { Write-Host '失败：' $_.Exception.Message }"

echo.
pause
