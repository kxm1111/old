import React from 'react';
import '../styles/AboutMe.css';

const AboutMe: React.FC = () => {
  return (
    <div className="about-me-container">
      <div className="profile-card">
        <div className="profile-header">
          <div className="avatar-container">
            <div className="avatar-placeholder">
              <span className="avatar-text">👤</span>
            </div>
          </div>
          <h1 className="name">关于我</h1>
          <p className="title">前端开发者 | 设计爱好者</p>
        </div>
        
        <div className="profile-content">
          <div className="section">
            <h2 className="section-title">👋 个人简介</h2>
            <p className="description">
              你好！我是一名热爱前端开发和UI设计的程序员。我喜欢创造美观、用户友好的界面，
              享受将创意转化为现实的过程。在技术的世界里不断学习和成长。
            </p>
          </div>
          
          <div className="section">
            <h2 className="section-title">💻 技能专长</h2>
            <div className="skills-container">
              <div className="skill-tag">React</div>
              <div className="skill-tag">TypeScript</div>
              <div className="skill-tag">JavaScript</div>
              <div className="skill-tag">HTML/CSS</div>
              <div className="skill-tag">UI设计</div>
              <div className="skill-tag">响应式设计</div>
            </div>
          </div>
          
          <div className="section">
            <h2 className="section-title">🎯 兴趣爱好</h2>
            <div className="interests-container">
              <div className="interest-item">
                <span className="emoji">🎨</span>
                <span>平面设计</span>
              </div>
              <div className="interest-item">
                <span className="emoji">📚</span>
                <span>阅读技术博客</span>
              </div>
              <div className="interest-item">
                <span className="emoji">🎮</span>
                <span>游戏开发</span>
              </div>
              <div className="interest-item">
                <span className="emoji">📸</span>
                <span>摄影</span>
              </div>
            </div>
          </div>
          
          <div className="section">
            <h2 className="section-title">📬 联系方式</h2>
            <div className="contact-info">
              <p>📧 example@email.com</p>
              <p>🌐 www.myportfolio.com</p>
              <p>📱 +86 138 **** 8888</p>
            </div>
          </div>
        </div>
        
        <div className="footer">
          <p className="copyright">© 2024 关于我. 用 ❤️ 制作</p>
        </div>
      </div>
    </div>
  );
};

export default AboutMe;