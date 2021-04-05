import BannerService from "../services/banner.service"
import axios from "axios"
export const banner = {
    namespaced: true,
    state: {
        banners: []
    },
    actions: {
        create({ commit }, payload) {
            console.log(payload.data.b)
            BannerService.create(payload.data.p, payload.data.b, payload.data.i)
        },
        async fetchAllBanners({ commit }) {
            try {
                const { data } = await axios.get("http://localhost:8080/banners/get")
                let banners = data;
                commit("setAllBanners", banners)
            }
            catch (error) {
                console.log(error)
            }
        },
        delete({ commit }, title) {
            console.log(title)
            BannerService.delete(title);
        }
    },
    mutations: {
        setAllBanners(state, banners) {
            state.banners = banners
        }
    }
};