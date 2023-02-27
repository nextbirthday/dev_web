import React, { useEffect, useState } from 'react';
import { Table } from 'react-bootstrap';
import Bottom from '../include/Bottom';
import Header from '../include/Header';
import { initializeApp } from 'https://www.gstatic.com/firebasejs/9.17.1/firebase-app.js';
import { getDatabase, ref, set, onValue } from 'https://www.gstatic.com/firebasejs/9.17.1/firebase-database.js';
import DeptRow from '../dept/DeptRow';

const firebaseConfig = {
  apiKey: process.env.REACT_APP_FS_APIKEY,
  authDomain: process.env.REACT_APP_FS_AUTHDOMAIN,
  databaseURL: process.env.REACT_APP_FS_DATABASEURL,
  projectId: process.env.REACT_APP_FS_PROJECTID,
  storageBucket: process.env.REACT_APP_FS_STORAGEBUCKET,
  messagingSenderId: process.env.REACT_APP_FS_MESSAGINGSENDERID,
  appId: process.env.REACT_APP_FS_APPID,
};

const app = initializeApp(firebaseConfig);
console.log(app);
const database = getDatabase();

const FireDeptPage = () => {
  const [depts, setDepts] = useState([]);
  useEffect(() => {
    console.log('useEffect 호출');
    console.log(database);

    const starCountRef = ref(database, 'dept');
    onValue(starCountRef, (snapshot) => {
      const data = snapshot.val();
      console.log(data);
      setDepts(data);
    });
  }, []); // 옵션에 별도의 값을 지정하지 않으면 최초 한 번만 실행된다.
  console.log(depts);

  return (
    <>
      <Header />
      <div>부서관리 페이지</div>
      <div>
        <Table striped bordered hover>
          <thead>
            <tr>
              <th>deptno</th>
              <th>dname</th>
              <th>loc</th>
            </tr>
          </thead>
          <tbody>
            {Object.keys(depts).map((key) => (
              <DeptRow key={key} dept={depts[key]} />
            ))}
          </tbody>
        </Table>
      </div>
      <Bottom />
    </>
  );
};

export default FireDeptPage;
