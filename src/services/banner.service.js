import axios from 'axios';
import store from "../store"
const API_URL = 'http://localhost:8080/banners/';

class BannerService {
    create(post, banner, image) {
        const formData = new FormData();
        formData.append("title", banner.title);
        formData.append("description", banner.description);
        formData.append("post", post);
        formData.append("file", image);
        formData.append("path", formData.getAll("file")[0].name);
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
                store.dispatch("banner/fetchAllBanners");
                store.dispatch("post/fetchAllPosts")
                console.log(response);
            })
            .catch(function (error) {
                console.log(error);
            });
    }
}
export default new BannerService();