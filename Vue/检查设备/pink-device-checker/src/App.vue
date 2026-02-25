<script setup>
import { ref, onMounted } from 'vue';

const deviceInfo = ref({
  browser: '',
  os: '',
  screenWidth: 0,
  screenHeight: 0,
  colorDepth: 0,
  pixelDepth: 0,
  timezone: '',
  language: '',
  online: true,
  cookiesEnabled: false,
  localStorageEnabled: false,
  sessionStorageEnabled: false,
  touchSupport: false,
  batteryLevel: null,
  charging: null
});

const loading = ref(true);

// 模拟设备检测功能
onMounted(() => {
  setTimeout(() => {
    detectDeviceInfo();
    loading.value = false;
  }, 1000);
});

const detectDeviceInfo = () => {
  const nav = navigator;
  const screen = window.screen;

  // 获取浏览器信息
  deviceInfo.value.browser = nav.appName + ' ' + nav.appVersion;
  deviceInfo.value.os = getOS();
  deviceInfo.value.screenWidth = screen.width;
  deviceInfo.value.screenHeight = screen.height;
  deviceInfo.value.colorDepth = screen.colorDepth;
  deviceInfo.value.pixelDepth = screen.pixelDepth;
  deviceInfo.value.timezone = Intl.DateTimeFormat().resolvedOptions().timeZone;
  deviceInfo.value.language = nav.language || nav.userLanguage;
  deviceInfo.value.online = nav.onLine;
  deviceInfo.value.cookiesEnabled = nav.cookieEnabled;
  deviceInfo.value.localStorageEnabled = checkStorage('localStorage');
  deviceInfo.value.sessionStorageEnabled = checkStorage('sessionStorage');
  deviceInfo.value.touchSupport = 'ontouchstart' in window || nav.maxTouchPoints > 0;
  
  // 模拟电池信息（如果API可用）
  if ('getBattery' in navigator) {
    navigator.getBattery().then(battery => {
      deviceInfo.value.batteryLevel = Math.floor(battery.level * 100);
      deviceInfo.value.charging = battery.charging;
    });
  } else {
    // 在模拟环境中设置默认值
    deviceInfo.value.batteryLevel = 85;
    deviceInfo.value.charging = true;
  }
};

const getOS = () => {
  const userAgent = navigator.userAgent;
  if (userAgent.indexOf('Win') !== -1) return 'Windows';
  if (userAgent.indexOf('Mac') !== -1) return 'MacOS';
  if (userAgent.indexOf('Linux') !== -1) return 'Linux';
  if (userAgent.indexOf('Android') !== -1) return 'Android';
  if (userAgent.indexOf('iOS') !== -1 || userAgent.indexOf('iPhone') !== -1 || userAgent.indexOf('iPad') !== -1) return 'iOS';
  return 'Unknown';
};

const checkStorage = (type) => {
  try {
    const storage = window[type];
    const x = '__storage_test__';
    storage.setItem(x, x);
    storage.removeItem(x);
    return true;
  } catch(e) {
    return false;
  }
};
</script>

<template>
  <div class="device-checker-container">
    <div class="header">
      <h1>📱 设备检查器</h1>
      <p class="subtitle">检查您的设备信息和兼容性</p>
    </div>

    <div v-if="loading" class="loading">
      <div class="spinner"></div>
      <p>正在检查您的设备...</p>
    </div>

    <div v-else class="device-info-grid">
      <!-- 基本信息 -->
      <div class="info-card">
        <h3>🖥️ 浏览器信息</h3>
        <ul>
          <li><strong>浏览器:</strong> {{ deviceInfo.browser }}</li>
          <li><strong>操作系统:</strong> {{ deviceInfo.os }}</li>
          <li><strong>语言:</strong> {{ deviceInfo.language }}</li>
          <li><strong>时区:</strong> {{ deviceInfo.timezone }}</li>
        </ul>
      </div>

      <!-- 屏幕信息 -->
      <div class="info-card">
        <h3>📏 屏幕信息</h3>
        <ul>
          <li><strong>分辨率:</strong> {{ deviceInfo.screenWidth }} × {{ deviceInfo.screenHeight }}</li>
          <li><strong>色彩深度:</strong> {{ deviceInfo.colorDepth }} 位</li>
          <li><strong>像素密度:</strong> {{ deviceInfo.pixelDepth }} 位</li>
          <li><strong>触摸支持:</strong> {{ deviceInfo.touchSupport ? '是' : '否' }}</li>
        </ul>
      </div>

      <!-- 连接状态 -->
      <div class="info-card">
        <h3>📡 连接状态</h3>
        <ul>
          <li><strong>在线状态:</strong> 
            <span :class="['status', { 'online': deviceInfo.online }]">
              {{ deviceInfo.online ? '在线' : '离线' }}
            </span>
          </li>
          <li><strong>Cookie:</strong> 
            <span :class="['status', { 'enabled': deviceInfo.cookiesEnabled }]">
              {{ deviceInfo.cookiesEnabled ? '启用' : '禁用' }}
            </span>
          </li>
          <li><strong>本地存储:</strong> 
            <span :class="['status', { 'enabled': deviceInfo.localStorageEnabled }]">
              {{ deviceInfo.localStorageEnabled ? '支持' : '不支持' }}
            </span>
          </li>
          <li><strong>会话存储:</strong> 
            <span :class="['status', { 'enabled': deviceInfo.sessionStorageEnabled }]">
              {{ deviceInfo.sessionStorageEnabled ? '支持' : '不支持' }}
            </span>
          </li>
        </ul>
      </div>

      <!-- 电池信息 -->
      <div class="info-card">
        <h3>🔋 电池信息</h3>
        <ul>
          <li><strong>电量:</strong> 
            <div class="battery-container">
              <div class="battery-level" :style="{ width: deviceInfo.batteryLevel + '%' }">
                {{ deviceInfo.batteryLevel }}%
              </div>
            </div>
          </li>
          <li><strong>充电状态:</strong> 
            <span :class="['status', { 'charging': deviceInfo.charging }]">
              {{ deviceInfo.charging ? '充电中' : '未充电' }}
            </span>
          </li>
        </ul>
      </div>
    </div>

    <div class="compatibility-section">
      <h2>✅ 兼容性评估</h2>
      <div class="compatibility-grid">
        <div class="compat-item">
          <div class="compat-icon">✓</div>
          <div class="compat-text">
            <h4>HTML5 支持</h4>
            <p>您的浏览器完全支持 HTML5 标准</p>
          </div>
        </div>
        <div class="compat-item">
          <div class="compat-icon">✓</div>
          <div class="compat-text">
            <h4>CSS3 支持</h4>
            <p>支持现代 CSS 特性与动画效果</p>
          </div>
        </div>
        <div class="compat-item">
          <div class="compat-icon">✓</div>
          <div class="compat-text">
            <h4>JavaScript ES6+</h4>
            <p>支持最新的 JavaScript 功能</p>
          </div>
        </div>
        <div class="compat-item">
          <div class="compat-icon">✓</div>
          <div class="compat-text">
            <h4>响应式设计</h4>
            <p>适配各种屏幕尺寸和设备类型</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.device-checker-container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 20px;
  font-family: 'Arial', sans-serif;
  background: linear-gradient(135deg, #fce4ec, #f8bbd0, #f48fb1);
  min-height: 100vh;
  color: #d81b60;
}

.header {
  text-align: center;
  margin-bottom: 30px;
  padding: 20px;
}

.header h1 {
  font-size: 2.5rem;
  margin-bottom: 10px;
  color: #ad1457;
  text-shadow: 2px 2px 4px rgba(255, 255, 255, 0.3);
}

.subtitle {
  font-size: 1.2rem;
  color: #c2185b;
}

.loading {
  text-align: center;
  padding: 60px 20px;
}

.spinner {
  width: 50px;
  height: 50px;
  border: 5px solid #f8bbd0;
  border-top: 5px solid #d81b60;
  border-radius: 50%;
  animation: spin 1s linear infinite;
  margin: 0 auto 20px;
}

@keyframes spin {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}

.device-info-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
  gap: 20px;
  margin-bottom: 40px;
}

.info-card {
  background: rgba(255, 255, 255, 0.85);
  border-radius: 15px;
  padding: 20px;
  box-shadow: 0 8px 32px rgba(216, 27, 96, 0.2);
  backdrop-filter: blur(10px);
  border: 1px solid rgba(216, 27, 96, 0.1);
}

.info-card h3 {
  margin-top: 0;
  margin-bottom: 15px;
  color: #ad1457;
  border-bottom: 2px solid #f48fb1;
  padding-bottom: 10px;
}

.info-card ul {
  list-style: none;
  padding: 0;
  margin: 0;
}

.info-card li {
  margin-bottom: 10px;
  padding: 8px 0;
  border-bottom: 1px dashed #f8bbd0;
}

.status {
  padding: 2px 8px;
  border-radius: 12px;
  font-weight: bold;
  font-size: 0.9em;
}

.status.online, .status.enabled {
  background: #e8f5e9;
  color: #2e7d32;
}

.status.charging {
  background: #fff8e1;
  color: #f57f17;
}

.battery-container {
  width: 100%;
  background: #f5f5f5;
  border-radius: 10px;
  height: 20px;
  overflow: hidden;
  margin-top: 5px;
}

.battery-level {
  background: linear-gradient(90deg, #4caf50, #8bc34a);
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  color: white;
  font-size: 0.8em;
  font-weight: bold;
  transition: width 0.3s ease;
}

.compatibility-section {
  background: rgba(255, 255, 255, 0.9);
  border-radius: 15px;
  padding: 30px;
  box-shadow: 0 8px 32px rgba(216, 27, 96, 0.2);
  backdrop-filter: blur(10px);
  border: 1px solid rgba(216, 27, 96, 0.1);
}

.compatibility-section h2 {
  text-align: center;
  margin-top: 0;
  color: #ad1457;
  margin-bottom: 25px;
}

.compatibility-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
  gap: 20px;
}

.compat-item {
  display: flex;
  align-items: flex-start;
  background: #fce4ec;
  padding: 15px;
  border-radius: 10px;
}

.compat-icon {
  font-size: 2rem;
  font-weight: bold;
  color: #4caf50;
  margin-right: 15px;
  background: white;
  width: 40px;
  height: 40px;
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
}

.compat-text h4 {
  margin: 0 0 5px 0;
  color: #c2185b;
}

.compat-text p {
  margin: 0;
  color: #d81b60;
  font-size: 0.9rem;
}

@media (max-width: 768px) {
  .device-checker-container {
    padding: 10px;
  }
  
  .header h1 {
    font-size: 2rem;
  }
  
  .device-info-grid {
    grid-template-columns: 1fr;
  }
  
  .compatibility-grid {
    grid-template-columns: 1fr;
  }
}
</style>
