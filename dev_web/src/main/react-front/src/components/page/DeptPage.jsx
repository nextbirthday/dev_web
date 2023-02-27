import React, { useEffect, useState } from 'react';
import { Table } from 'react-bootstrap';
import DeptRow from '../dept/DeptRow';
import Bottom from '../include/Bottom';
import Header from '../include/Header';

const DeptPage = () => {
  const [depts, setDepts] = useState([
    { deptno: 10, dname: '개발1팀', loc: '부산' },
    { deptno: 20, dname: '개발2팀', loc: '울산' },
    { deptno: 30, dname: '전산팀', loc: '서울' },
  ]);
  useEffect(() => {
    // setDepts(depts);
    console.log(depts);
  }, []); // 옵션에 별도의 값을 지정하지 않으면 최초 한 번만 실행된다.

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
              <tr key={key}>
                <td>{depts[key].deptno}</td>
                <td>{depts[key].dname}</td>
                <td>{depts[key].loc}</td>
              </tr>
            ))}
          </tbody>
        </Table>
      </div>
      <Bottom />
    </>
  );
};

export default DeptPage;
