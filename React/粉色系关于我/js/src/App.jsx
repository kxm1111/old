import './App.css'

function App() {
  return (
    <div className="about-page">
      <div className="header">
        <h1 className="title">关于我</h1>
        <div className="subtitle">Hello, I'm a passionate developer</div>
      </div>
      
      <div className="content">
        <div className="profile-section">
          <div className="avatar-container">
            <div className="avatar">
              <span className="avatar-text">😊</span>
            </div>
          </div>
          
          <div className="info-card">
            <h2>个人简介</h2>
            <p className="description">
              我是一名热爱技术的开发者，专注于前端开发和用户体验设计。
              喜欢探索新技术，享受代码创造的乐趣。
            </p>
          </div>
        </div>
        
        <div className="skills-section">
          <h2>技能专长</h2>
          <div className="skills-grid">
            <div className="skill-item">
              <div className="skill-icon">💻</div>
              <h3>前端开发</h3>
              <p>React, Vue, JavaScript</p>
            </div>
            <div className="skill-item">
              <div className="skill-icon">🎨</div>
              <h3>UI/UX设计</h3>
              <p>用户体验, 界面设计</p>
            </div>
            <div className="skill-item">
              <div className="skill-icon">📱</div>
              <h3>移动端开发</h3>
              <p>React Native, 小程序</p>
            </div>
            <div className="skill-item">
              <div className="skill-icon">⚙️</div>
              <h3>后端技术</h3>
              <p>Node.js, Java, Python</p>
            </div>
          </div>
        </div>
        
        <div className="interests-section">
          <h2>兴趣爱好</h2>
          <div className="interests-list">
            <div className="interest-item">
              <span className="interest-icon">📚</span>
              <span>阅读技术书籍</span>
            </div>
            <div className="interest-item">
              <span className="interest-icon">🎮</span>
              <span>游戏开发</span>
            </div>
            <div className="interest-item">
              <span className="interest-icon">📸</span>
              <span>摄影</span>
            </div>
            <div className="interest-item">
              <span className="interest-icon">🎵</span>
              <span>音乐</span>
            </div>
          </div>
        </div>
        
        <div className="contact-section">
          <h2>联系我</h2>
          <div className="contact-info">
            <div className="contact-item">
              <span className="contact-icon">📧</span>
              <span>email@example.com</span>
            </div>
            <div className="contact-item">
              <span className="contact-icon">📱</span>
              <span>+86 138 **** 8888</span>
            </div>
            <div className="contact-item">
              <span className="contact-icon">🌐</span>
              <span>github.com/username</span>
            </div>
          </div>
        </div>
      </div>
      
      <div className="footer">
        <p>© 2024 我的个人网站. 用心制作 ❤️</p>
      </div>
    </div>
  )
}

export default App
