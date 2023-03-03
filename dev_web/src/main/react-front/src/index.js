import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App.jsx';
import { BrowserRouter } from 'react-router-dom';
import AuthLogic from './service/authLogic';
import firebaseApp from './service/firebase';

// 공통코드 -> service>authLogic.js->import외부 js 재사용가능하다. -> export default 클래스명 -> 
// 브라우저에서 import하려면 반드시 babel이 필요하다.
const authLogic = new AuthLogic(firebaseApp);

// 왜 파라미터가 필요한가 ? - firebaseApp -> import firebaseApp from "./service/firebase"; -> export default firebaseApp
// authLogic 파이어베이스에서 제공하는 함수를 호출하겠다.
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.Fragment>
    <BrowserRouter>
    {/*App컴포넌트를 렌더링 할 때 속성 자리에 주소번지를 넘길 수 있다. -props */}
    {/*태그와 JS를 섞어쓰기가 가능하다. - { } */}
      <App authLogic={authLogic} />
    </BrowserRouter>
  </React.Fragment>
);
