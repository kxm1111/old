<script setup>
import { ref } from 'vue'

// 示例图片数据
const images = ref([
  { id: 1, src: 'https://picsum.photos/400/300?random=1', title: '风景如画', desc: '美丽的大自然风光' },
  { id: 2, src: 'https://picsum.photos/400/300?random=2', title: '城市夜景', desc: '灯光璀璨的都市' },
  { id: 3, src: 'https://picsum.photos/400/300?random=3', title: '日出时分', desc: '迎接美好的清晨' },
  { id: 4, src: 'https://picsum.photos/400/300?random=4', title: '海边日落', desc: '浪漫的黄昏时刻' },
  { id: 5, src: 'https://picsum.photos/400/300?random=5', title: '森林漫步', desc: '清新的绿色世界' },
  { id: 6, src: 'https://picsum.photos/400/300?random=6', title: '雪山之巅', desc: '壮丽的自然景观' },
  { id: 7, src: 'https://picsum.photos/400/300?random=7', title: '花海徜徉', desc: '芬芳的彩色世界' },
  { id: 8, src: 'https://picsum.photos/400/300?random=8', title: '星空银河', desc: '浩瀚的宇宙之美' },
])

// 示例视频数据
const videos = ref([
  { id: 1, src: 'https://www.w3schools.com/html/mov_bbb.mp4', poster: 'https://picsum.photos/400/225?random=10', title: '可爱小兔子' },
  { id: 2, src: 'https://www.w3schools.com/html/movie.mp4', poster: 'https://picsum.photos/400/225?random=11', title: '精彩短视频' },
])

const selectedImage = ref(null)

const openLightbox = (image) => {
  selectedImage.value = image
}

const closeLightbox = () => {
  selectedImage.value = null
}
</script>

<template>
  <div class="media-container">
    <!-- 头部 -->
    <header class="header">
      <h1 class="title">📸 粉色系视频图片</h1>
      <p class="subtitle">记录美好瞬间</p>
      <div class="header-decoration"></div>
    </header>

    <!-- 图片画廊 -->
    <section class="section gallery-section">
      <h2 class="section-title">
        <span class="icon">🖼️</span> 图片画廊
      </h2>
      <div class="gallery-grid">
        <div 
          v-for="image in images" 
          :key="image.id" 
          class="gallery-item"
          @click="openLightbox(image)"
        >
          <img :src="image.src" :alt="image.title" class="gallery-img" />
          <div class="gallery-overlay">
            <h3>{{ image.title }}</h3>
            <p>{{ image.desc }}</p>
          </div>
        </div>
      </div>
    </section>

    <!-- 视频区域 -->
    <section class="section video-section">
      <h2 class="section-title">
        <span class="icon">🎬</span> 视频欣赏
      </h2>
      <div class="video-grid">
        <div v-for="video in videos" :key="video.id" class="video-card">
          <video 
            :poster="video.poster" 
            controls 
            class="video-player"
          >
            <source :src="video.src" type="video/mp4" />
            您的浏览器不支持视频播放
          </video>
          <div class="video-info">
            <h3>{{ video.title }}</h3>
          </div>
        </div>
      </div>
    </section>

    <!-- 底部 -->
    <footer class="footer">
      <p>💖 用心记录每一刻</p>
    </footer>

    <!-- 图片灯箱 -->
    <Teleport to="body">
      <div v-if="selectedImage" class="lightbox" @click="closeLightbox">
        <div class="lightbox-content" @click.stop>
          <img :src="selectedImage.src" :alt="selectedImage.title" />
          <h3>{{ selectedImage.title }}</h3>
          <p>{{ selectedImage.desc }}</p>
          <button class="close-btn" @click="closeLightbox">×</button>
        </div>
      </div>
    </Teleport>
  </div>
</template>

<style scoped>
/* 全局容器 */
.media-container {
  min-height: 100vh;
  background: linear-gradient(135deg, #fff5f7 0%, #ffe4e9 50%, #ffd4dc 100%);
  font-family: 'Arial', 'Microsoft YaHei', sans-serif;
  padding: 20px;
  color: #666;
}

/* 头部样式 */
.header {
  text-align: center;
  padding: 50px 20px;
  background: rgba(255, 255, 255, 0.85);
  border-radius: 24px;
  margin-bottom: 40px;
  box-shadow: 0 12px 40px rgba(255, 182, 193, 0.25);
  backdrop-filter: blur(10px);
  position: relative;
  overflow: hidden;
}

.header::before {
  content: '';
  position: absolute;
  top: -50%;
  left: -50%;
  width: 200%;
  height: 200%;
  background: radial-gradient(circle, rgba(255, 182, 193, 0.1) 0%, transparent 70%);
  animation: rotate 20s linear infinite;
}

@keyframes rotate {
  from { transform: rotate(0deg); }
  to { transform: rotate(360deg); }
}

.title {
  font-size: 2.8rem;
  color: #ff69b4;
  margin: 0 0 10px 0;
  font-weight: bold;
  text-shadow: 2px 2px 8px rgba(255, 105, 180, 0.2);
  position: relative;
}

.subtitle {
  font-size: 1.2rem;
  color: #ff85a1;
  margin: 0;
  position: relative;
}

.header-decoration {
  width: 80px;
  height: 4px;
  background: linear-gradient(90deg, #ffb6c1, #ff69b4, #ffb6c1);
  margin: 20px auto 0;
  border-radius: 2px;
}

/* 区域通用样式 */
.section {
  background: rgba(255, 255, 255, 0.9);
  border-radius: 24px;
  padding: 40px;
  margin-bottom: 40px;
  box-shadow: 0 10px 40px rgba(255, 182, 193, 0.18);
  backdrop-filter: blur(10px);
  border: 1px solid rgba(255, 182, 193, 0.25);
}

.section-title {
  font-size: 1.8rem;
  color: #ff69b4;
  margin-bottom: 35px;
  text-align: center;
  display: flex;
  align-items: center;
  justify-content: center;
  gap: 10px;
}

.icon {
  font-size: 1.5rem;
}

/* 图片画廊 */
.gallery-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(280px, 1fr));
  gap: 25px;
}

.gallery-item {
  position: relative;
  border-radius: 20px;
  overflow: hidden;
  cursor: pointer;
  box-shadow: 0 8px 25px rgba(255, 182, 193, 0.25);
  transition: all 0.4s cubic-bezier(0.175, 0.885, 0.32, 1.275);
}

.gallery-item:hover {
  transform: translateY(-10px) scale(1.02);
  box-shadow: 0 15px 40px rgba(255, 182, 193, 0.4);
}

.gallery-img {
  width: 100%;
  height: 220px;
  object-fit: cover;
  display: block;
  transition: transform 0.4s ease;
}

.gallery-item:hover .gallery-img {
  transform: scale(1.1);
}

.gallery-overlay {
  position: absolute;
  bottom: 0;
  left: 0;
  right: 0;
  padding: 20px;
  background: linear-gradient(transparent, rgba(255, 105, 180, 0.9));
  color: white;
  transform: translateY(100%);
  transition: transform 0.4s ease;
}

.gallery-item:hover .gallery-overlay {
  transform: translateY(0);
}

.gallery-overlay h3 {
  margin: 0 0 5px 0;
  font-size: 1.2rem;
}

.gallery-overlay p {
  margin: 0;
  font-size: 0.9rem;
  opacity: 0.9;
}

/* 视频区域 */
.video-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(400px, 1fr));
  gap: 30px;
}

.video-card {
  background: rgba(255, 255, 255, 0.8);
  border-radius: 20px;
  overflow: hidden;
  box-shadow: 0 8px 30px rgba(255, 182, 193, 0.2);
  transition: all 0.3s ease;
}

.video-card:hover {
  transform: translateY(-8px);
  box-shadow: 0 15px 40px rgba(255, 182, 193, 0.35);
}

.video-player {
  width: 100%;
  height: 250px;
  object-fit: cover;
  display: block;
}

.video-info {
  padding: 20px;
}

.video-info h3 {
  margin: 0;
  color: #ff69b4;
  font-size: 1.2rem;
}

/* 底部 */
.footer {
  text-align: center;
  padding: 30px;
  color: #ff85a1;
  font-size: 1rem;
}

/* 灯箱样式 */
.lightbox {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.85);
  display: flex;
  align-items: center;
  justify-content: center;
  z-index: 9999;
  backdrop-filter: blur(10px);
  animation: fadeIn 0.3s ease;
}

@keyframes fadeIn {
  from { opacity: 0; }
  to { opacity: 1; }
}

.lightbox-content {
  position: relative;
  max-width: 90%;
  max-height: 90%;
  text-align: center;
  animation: scaleIn 0.3s ease;
}

@keyframes scaleIn {
  from { transform: scale(0.8); }
  to { transform: scale(1); }
}

.lightbox-content img {
  max-width: 100%;
  max-height: 70vh;
  border-radius: 15px;
  box-shadow: 0 20px 60px rgba(255, 105, 180, 0.3);
}

.lightbox-content h3 {
  color: white;
  margin: 20px 0 10px;
  font-size: 1.5rem;
}

.lightbox-content p {
  color: rgba(255, 255, 255, 0.8);
  font-size: 1rem;
}

.close-btn {
  position: absolute;
  top: -50px;
  right: 0;
  background: linear-gradient(135deg, #ff69b4, #ff85a1);
  color: white;
  border: none;
  width: 40px;
  height: 40px;
  border-radius: 50%;
  font-size: 24px;
  cursor: pointer;
  transition: all 0.3s ease;
  display: flex;
  align-items: center;
  justify-content: center;
}

.close-btn:hover {
  transform: rotate(90deg);
  background: linear-gradient(135deg, #ff1493, #ff69b4);
}

/* 响应式设计 */
@media (max-width: 768px) {
  .media-container {
    padding: 15px;
  }
  
  .header {
    padding: 30px 15px;
  }
  
  .title {
    font-size: 2rem;
  }
  
  .section {
    padding: 25px;
  }
  
  .gallery-grid {
    grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
    gap: 15px;
  }
  
  .video-grid {
    grid-template-columns: 1fr;
  }
  
  .gallery-img {
    height: 180px;
  }
  
  .video-player {
    height: 200px;
  }
}

@media (max-width: 480px) {
  .title {
    font-size: 1.6rem;
  }
  
  .subtitle {
    font-size: 1rem;
  }
  
  .section-title {
    font-size: 1.4rem;
  }
  
  .gallery-grid {
    grid-template-columns: 1fr;
  }
  
  .gallery-overlay {
    transform: translateY(0);
    background: linear-gradient(transparent 30%, rgba(255, 105, 180, 0.85));
  }
}
</style>
