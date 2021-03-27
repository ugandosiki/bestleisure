import PostService from "../services/post.service"
import axios from "axios"
export const post = {
    namespaced: true,
    state: {
        posts: []
    },
    actions: {
        create({ commit }, payload) {
            console.log(payload.data.p)
            PostService.create(payload.data.p, payload.data.i, payload.data.u)
        },
        fetchAllPosts({ commit }) {
            axios.get("http://localhost:8080/posts/get").then((response) => {
                let posts = response.data;
                commit("setAllPosts", posts)
            })
        },
        delete({commit}, title){
            console.log(title)
            PostService.delete(title);
        }
    },
    mutations: {
        setAllPosts(state, posts) {
            state.posts = posts
        }
    }
};