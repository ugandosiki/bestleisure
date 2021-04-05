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
        async fetchAllCategories({ commit }) {
            try {
                const { data } = await axios.get("http://localhost:8080/categories/get")
                let categories = data;
                commit("setAllCategories", categories)
            }
            catch (error) {
                console.log(error)
            }
        }
    },
    mutations: {
        setAllCategories(state, cat) {
            state.categories = cat
        }
    }
};