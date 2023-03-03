import React from 'react';
import { useParams } from 'react-router-dom';
import Bottom from '../include/Bottom';
import Header from '../include/Header';

/*Logout 처리를 위해서 props에 authLogic에 주소번지를 받아온다. */
const HomePage = ({ authLogic }) => {
  let { userId } = useParams();
  console.log(userId);
  const onLogout = () => {
    console.log('onLogout');
    authLogic.logout();
  };
  return (
    <React.Fragment>
      <Header userId={userId} onLogout={onLogout} />
      <div>HomePage입니다.</div>
      <Bottom />
    </React.Fragment>
  );
};

export default HomePage;
