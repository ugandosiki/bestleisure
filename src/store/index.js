import Vue from 'vue'
import Vuex from 'vuex'

import {auth} from "./auth.module"
import {post} from "./post.module"
import {category} from "./category.module"
import {subcategory} from "./subcategory.module"
import {banner} from "./banner.module"




Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    auth,
    post,
    category,
    subcategory,
    banner
  }
})
