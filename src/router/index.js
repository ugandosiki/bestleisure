import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/pages/Home.vue'
import DefaultLayot from '../views/layouts/DefaultLayout'
import AuthLayout from '../views/layouts/AuthLayout'
import Post from '../views/pages/Post.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'AppContent',
    component: DefaultLayot,
    redirect: "home",
    children: [
      {
        path: "about",
        component: () => import('../views/pages/About.vue')
      },
      {
        path: "catalog",
        component: () => import('../views/pages/Catalog.vue')
      },
      {
        path: "cabinet",
        component: () => import('../views/pages/Cabinet.vue'),
      },
      {
        path: "home",
        component: Home
      },
      {
        path: "/post/:id",
        component: Post,
        name: "Post"
      },
    ]
  },

  {
    path: '/auth',
    name: 'Auth',
    redirect: 'auth/register',
    component: AuthLayout,
    children: [
      {
        path: "register",
        component: () => import('../views/pages/auth/Register.vue')
      },
      {
        path: "login",
        component: () => import('../views/pages/auth/Login.vue')
      },
    ]
  }

]

const router = new VueRouter({
  mode: 'history',
  base: "/",
  routes,
})
router.beforeEach((to, from, next) => {
  const publicPages = ['/auth/login', '/auth/register'];
  const authRequired = !publicPages.includes(to.path);
  const loggedIn = localStorage.getItem('user');
  if (from.path == "/auth/login") {
    next()
  }
  else if (authRequired && !loggedIn) {
    next('/auth/login');
  } else {
    next();
  }
});
export default router
