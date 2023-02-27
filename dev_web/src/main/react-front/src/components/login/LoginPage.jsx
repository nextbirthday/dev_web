import React from 'react';
import { Button } from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';

const LoginPage = ({ authLogic }) => {
  const navigate = useNavigate();
  const moveHome = (userId) => {
    console.log(userId);
    navigate({ pathname: '/home/' + userId });
  };
  const handleLogin = () => {
    authLogic
      .login('Google')
      //.then((data) => console.log(data.user));
      .then((data) => moveHome(data.user.uid));
  };
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
