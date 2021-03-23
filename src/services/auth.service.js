import axios from 'axios';

const API_URL = 'http://localhost:8080/auth/';

class AuthService {
    login(user) {
        return axios
            .post(API_URL + 'login', {
                name: user.name,
                password: user.password
            })
            .then(response => {
                if (response.data.accessToken) {
                    localStorage.setItem('user', JSON.stringify(response.data));
                }

                return response.data;
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
