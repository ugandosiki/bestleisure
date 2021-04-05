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
        async fetchAllSubCategories({ commit }) {
            try {
                const { data } = await axios.get("http://localhost:8080/subcategories/get")
                let scategories = data;
                commit("setAllSubCategories", scategories)
            }
            catch (error) {
                console.log(error)
            }
        }
    },
    mutations: {
        setAllSubCategories(state, scat) {
            state.subcategories = scat
        }
    }
};