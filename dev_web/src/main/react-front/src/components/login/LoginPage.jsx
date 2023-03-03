import React, { useEffect } from 'react';
import { Button } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';

const LoginPage = ({ authLogic }) => {
  const navigate = useNavigate();
  const moveHome = (userId) => {
    console.log(userId);
    navigate({ pathname: '/home/' + userId });
  };
  const handleLogin = () => {
    /*service -> authLogic.js에 선언된 클래스 -> login함수 선언 
    파라미터로 넘기는 문자열에 따라서 구글로그인 또는 깃헙로그인 AuthLogic클래스의 getProvider 함수에서 분기되어 있다<div className=""></div>  */
    authLogic.login('Google').then((data) => moveHome(data.user.uid));
  };

  useEffect(() => {
    authLogic.onAuthChange((user) => {
      console.log('LoginPage.jsx user ===> ' + user);
      console.log('LoginPage.jsx user.uid ===> ' + user.uid);
      /*사용자가 있다면 로그인 거치지 않고 바로 HomePage로 이동하기 처리 */
      user && moveHome(user.uid);
    });
  }, []);

  return (
    <React.Fragment>
      <Button
        onClick={() => {
          navigate('/');
        }}
      >
        홈페이지
      </Button>
      <Button onClick={handleLogin}>Google</Button>
    </React.Fragment>
  );
};

export default LoginPage;
