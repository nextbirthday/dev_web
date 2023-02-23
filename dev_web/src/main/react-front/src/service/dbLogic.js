import axios from 'axios';

//rafce - arrow function export default;
export const jsonDeptList = (params) => {
  return new Promise((resolve, reject) => {
    try {
      const response = axios({
        method: 'get',
        url: process.env.REACT_APP_DEV_WEB_IP + 'dept/jsonDeptList.st1',
        params: params,
      });
      resolve(response);
    } catch (error) {
      reject(error);
    }
  });
};
