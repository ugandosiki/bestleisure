import axios from "axios"
import CategoryService from "../services/category.service"
export const category = {
    namespaced: true,
    state: {
        categories: []
    },
    actions: {
        create({ commit }, category) {
            console.log(category)
            CategoryService.create(category)
        },
        fetchAllCategories({ commit }) {
            axios.get("http://localhost:8080/categories/get").then((response) => {
                let categories = response.data;
                commit("setAllCategories", categories)
            })
        }
    },
    mutations: {
        setAllCategories(state, cat) {
            state.categories = cat
        }
    }
};