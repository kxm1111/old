<script setup>
import { ref } from 'vue'

const clickedButton = ref(null)

const handleClick = (name) => {
  clickedButton.value = name
  setTimeout(() => {
    clickedButton.value = null
  }, 300)
}
</script>

<template>
  <div class="container">
    <h1 class="title">粉色系按钮</h1>
    <p class="subtitle">各种风格的粉色按钮展示</p>

    <div class="button-section">
      <h2>基础按钮</h2>
      <div class="button-row">
        <button class="btn btn-pink" @click="handleClick('basic')">基础粉</button>
        <button class="btn btn-pink-light" @click="handleClick('light')">浅粉</button>
        <button class="btn btn-pink-dark" @click="handleClick('dark')">深粉</button>
        <button class="btn btn-rose" @click="handleClick('rose')">玫红</button>
      </div>
    </div>

    <div class="button-section">
      <h2>渐变按钮</h2>
      <div class="button-row">
        <!--  -->
        <button class="btn btn-gradient-1" @click="handleClick('grad1')">渐变粉</button>
        <!--  -->
        <button class="btn btn-gradient-2" @click="handleClick('grad2')">蜜桃渐变</button>
        <button class="btn btn-gradient-3" @click="handleClick('grad3')">樱花渐变</button>
      </div>
    </div>

    <div class="button-section">
      <h2>圆角按钮</h2>
      <div class="button-row">
        <button class="btn btn-round-sm" @click="handleClick('round-sm')">小圆角</button>
        <button class="btn btn-round-md" @click="handleClick('round-md')">中圆角</button>
        <button class="btn btn-round-lg" @click="handleClick('round-lg')">大圆角</button>
        <button class="btn btn-round-full" @click="handleClick('round-full')">完全圆</button>
      </div>
    </div>

    <div class="button-section">
      <h2>带图标的按钮</h2>
      <div class="button-row">
        <button class="btn btn-icon" @click="handleClick('icon1')">
          <span class="icon">♥</span> 爱心
        </button>
        <button class="btn btn-icon" @click="handleClick('icon2')">
          <span class="icon">✦</span> 星星
        </button>
        <button class="btn btn-icon" @click="handleClick('icon3')">
          ♡ 喜欢
        </button>
      </div>
    </div>

    <div class="button-section">
      <h2>特效按钮</h2>
      <div class="button-row">
        <button class="btn btn-glow" @click="handleClick('glow')">发光</button>
        <button class="btn btn-shadow" @click="handleClick('shadow')">阴影</button>
        <button class="btn btn-border" @click="handleClick('border')">边框</button>
        <button class="btn btn-3d" @click="handleClick('3d')">3D</button>
      </div>
    </div>

    <div class="button-section">
      <h2>动画按钮</h2>
      <div class="button-row">
        <button class="btn btn-animate-hover" @click="handleClick('hover')">悬停动画</button>
        <button class="btn btn-animate-click" @click="handleClick('click')">点击动画</button>
        <button class="btn btn-animate-ripple" @click="handleClick('ripple')">波纹</button>
      </div>
    </div>

    <div class="button-section">
      <h2>大按钮</h2>
      <div class="button-row">
        <button class="btn btn-lg btn-pink" @click="handleClick('lg')">大按钮</button>
        <button class="btn btn-sm btn-pink" @click="handleClick('sm')">小按钮</button>
      </div>
    </div>

    <p v-if="clickedButton" class="feedback">你点击了: {{ clickedButton }}</p>
  </div>
</template>

<style scoped>
.container {
  max-width: 800px;
  margin: 0 auto;
  text-align: center;
  padding: 2rem;
}

.title {
  font-size: 2.5rem;
  color: #d63384;
  margin-bottom: 0.5rem;
  text-shadow: 2px 2px 4px rgba(214, 51, 132, 0.2);
}

.subtitle {
  color: #c0607a;
  margin-bottom: 2rem;
  font-size: 1.1rem;
}

.button-section {
  margin-bottom: 2.5rem;
}

.button-section h2 {
  color: #c0607a;
  font-size: 1.2rem;
  margin-bottom: 1rem;
  font-weight: 500;
}

.button-row {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  gap: 1rem;
}

/*  */
/* 基础按钮样式 */
.btn {
  padding: 0.8rem 1.5rem;
  font-size: 1rem;
  font-weight: 500;
  border: none;
  cursor: pointer;
  transition: all 0.3s ease;
  font-family: inherit;
}
/*  */


.btn-pink {
  background: #ff69b4;
  color: white;
}
.btn-pink:hover {
  background: #ff4da6;
  transform: translateY(-2px);
}

.btn-pink-light {
  background: #ffb6c1;
  color: #c0607a;
}
.btn-pink-light:hover {
  background: #ffa4b2;
}

.btn-pink-dark {
  background: #db7093;
  color: white;
}
.btn-pink-dark:hover {
  background: #d06080;
}

.btn-rose {
  background: #e75480;
  color: white;
}
.btn-rose:hover {
  background: #e03060;
}

/*  */
/* 渐变按钮 */
.btn-gradient-1 {
  background: linear-gradient(45deg, #ff69b4, #ffb6c1);
  color: white;
}
.btn-gradient-1:hover {
  background: linear-gradient(45deg, #ff4da6, #ffa4b2);
}
/*  */

.btn-gradient-2 {
  background: linear-gradient(45deg, #ff9aae, #ffc3a0);
  color: #c0607a;
}
.btn-gradient-2:hover {
  transform: translateY(-2px);
}

.btn-gradient-3 {
  background: linear-gradient(45deg, #ffc0cb, #e6e6fa);
  color: #c0607a;
}
.btn-gradient-3:hover {
  box-shadow: 0 4px 15px rgba(255, 182, 193, 0.5);
}

/* 圆角按钮 */
.btn-round-sm {
  background: #ff69b4;
  color: white;
  border-radius: 4px;
}

.btn-round-md {
  background: #ff69b4;
  color: white;
  border-radius: 12px;
}

.btn-round-lg {
  background: #ff69b4;
  color: white;
  border-radius: 20px;
}

.btn-round-full {
  background: #ff69b4;
  color: white;
  border-radius: 50px;
}

/* 图标按钮 */
.btn-icon {
  background: linear-gradient(135deg, #ff69b4, #db7093);
  color: white;
  display: inline-flex;
  align-items: center;
  gap: 0.5rem;
}

.btn-icon:hover {
  transform: scale(1.05);
}

.icon {
  font-size: 1.1rem;
}

/* 特效按钮 */
.btn-glow {
  background: #ff69b4;
  color: white;
  box-shadow: 0 0 10px rgba(255, 105, 180, 0.5);
}
.btn-glow:hover {
  box-shadow: 0 0 20px rgba(255, 105, 180, 0.8), 0 0 30px rgba(255, 105, 180, 0.4);
}

.btn-shadow {
  background: #ff69b4;
  color: white;
  box-shadow: 4px 4px 0 #db7093;
}
.btn-shadow:hover {
  box-shadow: 6px 6px 0 #db7093;
  transform: translate(-2px, -2px);
}

.btn-border {
  background: transparent;
  color: #ff69b4;
  border: 2px solid #ff69b4;
}
.btn-border:hover {
  background: #ff69b4;
  color: white;
}

.btn-3d {
  background: #ff69b4;
  color: white;
  box-shadow: 0 6px 0 #c44d80;
  border-radius: 8px;
}
.btn-3d:hover {
  transform: translateY(-2px);
  box-shadow: 0 8px 0 #c44d80;
}
.btn-3d:active {
  transform: translateY(4px);
  box-shadow: 0 2px 0 #c44d80;
}

/* 动画按钮 */
.btn-animate-hover {
  background: #ff69b4;
  color: white;
  position: relative;
  overflow: hidden;
}
.btn-animate-hover::before {
  content: '';
  position: absolute;
  top: 0;
  left: -100%;
  width: 100%;
  height: 100%;
  background: linear-gradient(90deg, transparent, rgba(255,255,255,0.3), transparent);
  transition: left 0.5s;
}
.btn-animate-hover:hover::before {
  left: 100%;
}

.btn-animate-click {
  background: #ff69b4;
  color: white;
}
.btn-animate-click:active {
  transform: scale(0.95);
}

.btn-animate-ripple {
  background: #ff69b4;
  color: white;
  position: relative;
  overflow: hidden;
}
.btn-animate-ripple:active {
  transform: scale(0.97);
}

/* 大小按钮 */
.btn-lg {
  padding: 1rem 2.5rem;
  font-size: 1.2rem;
}

.btn-sm {
  padding: 0.5rem 1rem;
  font-size: 0.85rem;
}

.feedback {
  margin-top: 2rem;
  color: #d63384;
  font-weight: 500;
}
</style>
