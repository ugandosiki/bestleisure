import axios from 'axios';
import store from '../store'
const API_URL = 'http://localhost:8080/auth/';

class AuthService {
  login(user) {
    const formData = new FormData();
    formData.append("email", user.email);
    formData.append("password", user.password);
    axios({
      method: "post",
      url: API_URL + 'login',
      data: formData,
      headers: {
        "Content-Type": "multipart/form-data",
        "Access-Control-Allow-Origin": "*",
      },
    })
      .then(function (response) {
        if (response.data.token) {
          localStorage.setItem('user', JSON.stringify(response.data));
          store.commit("auth/loginSuccess", response.data)
        }
        return response.data;
      })
      .catch(function (error) {
        console.log(error);
      });
  }

  logout() {
    localStorage.removeItem('user');
  }

  register(user) {
    const formData = new FormData();
    formData.append("name", user.name);
    formData.append("email", user.email);
    formData.append("password", user.password);
    formData.append("city", user.city);
    formData.append("role", user.role.id);
    console.log(formData.getAll("role"));
    axios({
      method: "post",
      url: API_URL + 'register',
      data: formData,
      headers: {
        "Content-Type": "multipart/form-data",
        "Access-Control-Allow-Origin": "*",
      },
    })
      .then(function (response) {
        console.log(response);
      })
      .catch(function (error) {
        console.log(error);
      });
  }
}
export default new AuthService();
