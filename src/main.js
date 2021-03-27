import Vue from 'vue'
import App from './App.vue'
import './registerServiceWorker'
import router from './router'
import store from './store'
import './quasar'


import Paginate from 'vuejs-paginate'
Vue.component('Paginate', Paginate)
Vue.config.productionTip = false

store.dispatch("post/fetchAllPosts");
store.dispatch("category/fetchAllCategories");
store.dispatch("subcategory/fetchAllSubCategories");

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
