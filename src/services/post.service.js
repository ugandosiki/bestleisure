import axios from 'axios';
import store from "../store"
const API_URL = 'http://localhost:8080/posts/';

class PostService {
    create(post, image, user) {
        const formData = new FormData();
        formData.append("title", post.title);
        formData.append("description", post.description);
        formData.append("category", post.category);
        formData.append("subCategory", post.subCategory);
        formData.append("type", post.type);
        formData.append("user", user);
        formData.append("address", post.address);
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
                store.dispatch("post/fetchAllPosts")
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            });
    }
    delete(title) {
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
                store.dispatch("post/fetchAllPosts")
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            });
    }
    addLike(userID ,postID){
        const formData = new FormData();
        formData.append("userID", userID);
        formData.append("postID", postID);
        axios({
            method: "post",
            url: API_URL + "addLike",
            data: formData,
            headers: {
                "Content-Type": "multipart/form-data",
                "Access-Control-Allow-Origin": "*",
            },
        })
            .then(function (response) {
                store.dispatch("post/fetchAllPosts")
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            });
    }
    updateDescr(descr, id){
        const formData = new FormData()
        formData.append("descr", descr);
        axios({
            method: "put",
            url: API_URL + "updatedescr/" + id,
            data: formData,
            headers: {
                "Content-Type": "multipart/form-data",
                "Access-Control-Allow-Origin": "*",
            },
        })
            .then(function (response) {
                store.dispatch("post/fetchAllPosts")
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            });
    }
    updateTitle(title, id){
        const formData = new FormData()
        formData.append("title", title);
        axios({
            method: "put",
            url: API_URL + "updatetitle/" + id,
            data: formData,
            headers: {
                "Content-Type": "multipart/form-data",
                "Access-Control-Allow-Origin": "*",
            },
        })
            .then(function (response) {
                store.dispatch("post/fetchAllPosts")
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            });
    }
}
export default new PostService();