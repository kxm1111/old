import React from 'react'
import ReactDOM from 'react-dom/client'
import AboutMe from './components/AboutMe'

const rootElement = document.getElementById('app')
if (rootElement) {
  const root = ReactDOM.createRoot(rootElement)
  root.render(
    <React.StrictMode>
      <AboutMe />
    </React.StrictMode>
  )
}