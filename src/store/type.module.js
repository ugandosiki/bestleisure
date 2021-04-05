import axios from "axios"
import TypeService from "../services/type.service"
export const type = {
    namespaced: true,
    state: {
        types: []
    },
    actions: {
        create({ commit }, type) {
            console.log(type)
            TypeService.create(type)
        },
        async fetchAllTypes({ commit }) {
            try {
                const { data } = await axios.get("http://localhost:8080/types/get")
                let types = data;
                commit("setAllTypes", types)

            }
            catch (error) {
                console.log(error);
            }

        }
    },
    mutations: {
        setAllTypes(state, types) {
            state.types = types
        }
    }
};