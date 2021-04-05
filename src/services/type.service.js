import axios from 'axios';
import store from "../store"
const API_URL = 'http://localhost:8080/types/';

class TypeService {
    create(type) {
        const formData = new FormData();
        formData.append("name", type.name);
        console.log(type)
        axios({
            method: "post",
            url: API_URL + "add",
            data: formData,
            headers: {
                "Content-Type": "multipart/form-data",
                "Access-Control-Allow-Origin": "*",
            },
        })
            .then(function (response) {
                store.dispatch("type/fetchAllTypes");
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            });
    }
}
export default new TypeService();