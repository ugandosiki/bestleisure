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
        async fetchAllPosts({ commit }) {
            try {
                const { data } = await axios.get("http://localhost:8080/posts/get")
                let posts = data;
                commit("setAllPosts", posts)
            }
            catch (error) {
                console.log(error)
            }
        },
        delete({ commit }, title) {
            console.log(title)
            PostService.delete(title);
        },
        addLike({ commit }, payload) {
            console.log(payload.userID)
            PostService.addLike(payload.userID, payload.postID)
        },
        updateDescr({commit}, payload){
            console.log(payload.data.i)
            PostService.updateDescr(payload.data.d, payload.data.i)
        },
        updateTitle({commit}, payload){
            console.log(payload.data.i)
            PostService.updateTitle(payload.data.t, payload.data.i)
        }
    },
    mutations: {
        setAllPosts(state, posts) {
            state.posts = posts
        }
    }
};