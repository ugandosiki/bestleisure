import axios from 'axios';

const API_URL = 'http://localhost:8080/posts/';

class PostService {
    create(post, image, user) {
        const formData = new FormData();
        formData.append("title", post.title);
        formData.append("description", post.description);
        formData.append("category", post.category);
        formData.append("subCategory", post.subCategory);
        formData.append("user", user);
        formData.append("likes", post.likes);
        formData.append("file", image);
        formData.append("path", formData.getAll("file")[0].name);
        console.log(image)
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
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            });
    }
    delete(title){
        const formData = new FormData();
        formData.append("title", title);
        axios({
            method: "post",
            url: API_URL + "delete",
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
export default new PostService();