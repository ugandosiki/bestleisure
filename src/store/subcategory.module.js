import axios from "axios"
import SubCategoryService from "../services/subcategory.service"
export const subcategory = {
    namespaced: true,
    state: {
        subcategories: []
    },
    actions: {
        create({ commit }, subcategory) {
            console.log(subcategory)
            SubCategoryService.create(subcategory)
        },
        fetchAllSubCategories({ commit }) {
            axios.get("http://localhost:8080/subcategories/get").then((response) => {
                let scategories = response.data;
                commit("setAllSubCategories", scategories)
            })
        }
    },
    mutations: {
        setAllSubCategories(state, scat) {
            state.subcategories = scat
        }
    }
};