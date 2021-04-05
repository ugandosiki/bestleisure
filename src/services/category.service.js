import axios from 'axios';
import store from "../store"
const API_URL = 'http://localhost:8080/categories/';

class CategoryService {
    create(category) {
        const formData = new FormData();
        formData.append("name", category.name);
        console.log(category)
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
                store.dispatch("category/fetchAllCategories");
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            });
    }
}
export default new CategoryService();