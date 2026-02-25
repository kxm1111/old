<script setup>
import { ref } from 'vue'

const skills = ref([
  { name: 'Vue3', level: 90 },
  { name: 'JavaScript', level: 85 },
  { name: 'CSS3', level: 80 },
  { name: 'Node.js', level: 75 },
  { name: 'React', level: 70 },
  { name: 'TypeScript', level: 65 }
])

const hobbies = ref([
  '🎨 前端开发',
  '📚 学习新技术',
  '🎵 听音乐',
  '📖 阅读',
  '📷 摄影',
  '🍵 喝奶茶'
])

const socialLinks = ref([
  { name: 'GitHub', url: '#', icon: 'github' },
  { name: '掘金', url: '#', icon: 'juejin' },
  { name: '邮箱', url: 'mailto:example@email.com', icon: 'email' }
])
</script>

<template>
  <div class="about-container">
    <!-- 头部区域 -->
    <header class="header">
      <div class="avatar-container">
        <div class="avatar">
          <span>👩</span>
        </div>
      </div>
      <h1 class="name">Pink Girl</h1>
      <p class="title">前端开发工程师 | 技术爱好者</p>
      <div class="divider"></div>
    </header>

    <!-- 简介区域 -->
    <section class="section intro-section">
      <h2 class="section-title">关于我</h2>
      <div class="intro-content">
        <p>你好！我是Pink Girl，一个热爱前端开发的技术爱好者。</p>
        <p>我专注于Vue.js和现代前端技术栈，喜欢创造美观且用户友好的界面。</p>
        <p>在工作之余，我喜欢学习新技术、摄影和享受生活中的小美好。</p>
      </div>
    </section>

    <!-- 技能区域 -->
    <section class="section skills-section">
      <h2 class="section-title">技能树</h2>
      <div class="skills-grid">
        <div 
          v-for="skill in skills" 
          :key="skill.name" 
          class="skill-item"
        >
          <div class="skill-header">
            <span class="skill-name">{{ skill.name }}</span>
            <span class="skill-level">{{ skill.level }}%</span>
          </div>
          <div class="skill-bar">
            <div 
              class="skill-progress" 
              :style="{ width: skill.level + '%' }"
            ></div>
          </div>
        </div>
      </div>
    </section>

    <!-- 兴趣爱好区域 -->
    <section class="section hobbies-section">
      <h2 class="section-title">兴趣爱好</h2>
      <div class="hobbies-grid">
        <div 
          v-for="hobby in hobbies" 
          :key="hobby" 
          class="hobby-item"
        >
          {{ hobby }}
        </div>
      </div>
    </section>

    <!-- 联系方式区域 -->
    <section class="section contact-section">
      <h2 class="section-title">联系我</h2>
      <div class="social-links">
        <a 
          v-for="link in socialLinks" 
          :key="link.name"
          :href="link.url" 
          class="social-link"
          target="_blank"
          rel="noopener"
        >
          {{ link.name }}
        </a>
      </div>
    </section>

    <!-- 底部 -->
    <footer class="footer">
      <p>© 2024 Pink Girl. Made with 💖 and Vue3</p>
    </footer>
  </div>
</template>

<style scoped>
/* 全局样式 */
.about-container {
  min-height: 100vh;
  background: linear-gradient(135deg, #fff5f7 0%, #ffe4e9 100%);
  font-family: 'Arial', 'Microsoft YaHei', sans-serif;
  padding: 20px;
  color: #666;
}

/* 头部样式 */
.header {
  text-align: center;
  padding: 40px 20px;
  background: rgba(255, 255, 255, 0.8);
  border-radius: 20px;
  margin-bottom: 30px;
  box-shadow: 0 8px 32px rgba(255, 182, 193, 0.2);
  backdrop-filter: blur(10px);
}

.avatar-container {
  margin-bottom: 20px;
}

.avatar {
  width: 120px;
  height: 120px;
  border-radius: 50%;
  overflow: hidden;
  margin: 0 auto;
  border: 4px solid #ffb6c1;
  box-shadow: 0 0 20px rgba(255, 182, 193, 0.5);
  background: linear-gradient(45deg, #ffb6c1, #ffc0cb);
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 48px;
  color: white;
}

.avatar img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.name {
  font-size: 2.5rem;
  color: #ff69b4;
  margin: 15px 0;
  font-weight: bold;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.1);
}

.title {
  font-size: 1.2rem;
  color: #ff85a1;
  margin-bottom: 20px;
}

.divider {
  width: 100px;
  height: 3px;
  background: linear-gradient(90deg, #ffb6c1, #ff69b4);
  margin: 0 auto;
  border-radius: 2px;
}

/* 区域通用样式 */
.section {
  background: rgba(255, 255, 255, 0.9);
  border-radius: 20px;
  padding: 30px;
  margin-bottom: 30px;
  box-shadow: 0 8px 32px rgba(255, 182, 193, 0.15);
  backdrop-filter: blur(10px);
  border: 1px solid rgba(255, 182, 193, 0.2);
}

.section-title {
  font-size: 1.8rem;
  color: #ff69b4;
  margin-bottom: 25px;
  text-align: center;
  position: relative;
}

.section-title::after {
  content: '';
  position: absolute;
  bottom: -10px;
  left: 50%;
  transform: translateX(-50%);
  width: 60px;
  height: 3px;
  background: linear-gradient(90deg, #ffb6c1, #ff69b4);
  border-radius: 2px;
}

/* 简介区域 */
.intro-content {
  line-height: 1.8;
  font-size: 1.1rem;
}

.intro-content p {
  margin-bottom: 15px;
  text-align: center;
}

/* 技能区域 */
.skills-grid {
  display: grid;
  gap: 20px;
  max-width: 600px;
  margin: 0 auto;
}

.skill-item {
  background: rgba(255, 255, 255, 0.7);
  padding: 15px;
  border-radius: 15px;
  border: 1px solid rgba(255, 182, 193, 0.3);
}

.skill-header {
  display: flex;
  justify-content: space-between;
  margin-bottom: 10px;
  font-weight: bold;
  color: #ff69b4;
}

.skill-name {
  font-size: 1.1rem;
}

.skill-level {
  color: #ff85a1;
}

.skill-bar {
  height: 12px;
  background: rgba(255, 182, 193, 0.2);
  border-radius: 6px;
  overflow: hidden;
}

.skill-progress {
  height: 100%;
  background: linear-gradient(90deg, #ffb6c1, #ff69b4);
  border-radius: 6px;
  transition: width 1s ease-in-out;
}

/* 兴趣爱好区域 */
.hobbies-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(150px, 1fr));
  gap: 15px;
  max-width: 800px;
  margin: 0 auto;
}

.hobby-item {
  background: linear-gradient(135deg, #ffb6c1, #ffc0cb);
  color: white;
  padding: 20px;
  border-radius: 15px;
  text-align: center;
  font-weight: bold;
  box-shadow: 0 4px 15px rgba(255, 182, 193, 0.3);
  transition: transform 0.3s ease, box-shadow 0.3s ease;
}

.hobby-item:hover {
  transform: translateY(-5px);
  box-shadow: 0 8px 25px rgba(255, 182, 193, 0.4);
}

/* 联系方式区域 */
.social-links {
  display: flex;
  justify-content: center;
  gap: 20px;
  flex-wrap: wrap;
}

.social-link {
  display: inline-block;
  background: linear-gradient(135deg, #ffb6c1, #ff69b4);
  color: white;
  padding: 12px 25px;
  border-radius: 25px;
  text-decoration: none;
  font-weight: bold;
  transition: all 0.3s ease;
  box-shadow: 0 4px 15px rgba(255, 182, 193, 0.3);
}

.social-link:hover {
  transform: translateY(-3px);
  box-shadow: 0 8px 25px rgba(255, 182, 193, 0.5);
  background: linear-gradient(135deg, #ff69b4, #ff1493);
}

/* 底部样式 */
.footer {
  text-align: center;
  padding: 30px;
  color: #ff85a1;
  font-size: 0.9rem;
}

/* 响应式设计 */
@media (max-width: 768px) {
  .about-container {
    padding: 10px;
  }
  
  .header {
    padding: 30px 15px;
  }
  
  .name {
    font-size: 2rem;
  }
  
  .section {
    padding: 20px;
  }
  
  .skills-grid {
    gap: 15px;
  }
  
  .hobbies-grid {
    grid-template-columns: repeat(auto-fit, minmax(120px, 1fr));
    gap: 10px;
  }
  
  .social-links {
    gap: 15px;
  }
  
  .social-link {
    padding: 10px 20px;
    font-size: 0.9rem;
  }
}

@media (max-width: 480px) {
  .name {
    font-size: 1.8rem;
  }
  
  .avatar {
    width: 100px;
    height: 100px;
    font-size: 36px;
  }
  
  .hobbies-grid {
    grid-template-columns: 1fr;
  }
  
  .social-links {
    flex-direction: column;
    align-items: center;
  }
  
  .social-link {
    width: 80%;
    text-align: center;
  }
}
</style>
