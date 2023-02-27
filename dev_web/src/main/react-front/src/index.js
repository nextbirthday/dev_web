import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App.jsx';
import { BrowserRouter } from 'react-router-dom';
import AuthLogic from './service/authLogic';
import firebaseApp from './service/firebase';

const authLogic = new AuthLogic(firebaseApp);

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.Fragment>
    <BrowserRouter>
      <App authLogic={authLogic} />
    </BrowserRouter>
  </React.Fragment>
);
