// src/App.js
import "./App.css";
import AppBar from "./components/appbar";
import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import AdminPanel from './components/AdminPanel';
import HomePage from './components/HomePage';
import FeaturesPage from './components/FeaturesPage';
import PricingPage from './components/PricingPage';

function App() {
  return (
    <Router>
      <div className="App">
        <AppBar />
        <Routes>
          <Route exact path="/" element={<HomePage />} />
          <Route path="/admin" element={<AdminPanel />} />
          <Route path="/features" element={<FeaturesPage />} />
          <Route path="/pricing" element={<PricingPage />} />
        </Routes>
        <footer>
          <p>
            For more information, visit our <a href="https://github.com/sm000k/CANGO_PORTFOLIO" target="_blank" rel="noopener noreferrer">GitHub repository</a>.
          </p>
        </footer>
      </div>
    </Router>
  );
}

export default App;
