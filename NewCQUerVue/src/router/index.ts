import { createRouter, createWebHashHistory } from 'vue-router'
import Login from '../views/login.vue'
import Welcome from '../views/welcome.vue'
import Home from '../views/home.vue'
import Info from '../views/info.vue'
import Adminhome from '../views/adminhome.vue'

const routes = [
    {
        path: '/',
        redirect: '/login'
    },
  {
    path: '/login',
    name: 'login',
    component: Login,
  },
  {
    path: '/info',
    name: 'info',
    component: Info,
  },
  {
    path: '/welcome',
    name: 'welcome',
    component: Welcome,
  },
  {
    path: '/home',
    name: 'home',
    component: Home,
    children: [
        {
          path: '/hobby',
          name: 'hobby',
          component: () => import('@/views/subMenu/hobby/index.vue')
        },
        {
          path: '/fellow',
          name: 'fellow',
          component: () => import('@/views/subMenu/fellow/index.vue')
        },
        {
          path: '/newFriend',
          name: 'newFriend',
          component: () => import('@/views/subMenu/newFriend/index.vue')
        },
        {
          path: '/select',
          name: 'select',
          component: () => import('@/views/subMenu/select/index.vue')
        },
        {
          path: '/preClass',
          name: 'preClass',
          component: () => import('@/views/subMenu/preClass/index.vue')
        },
        {
          path: '/life',
          name: 'life',
          component: () => import('@/views/subMenu/life/index.vue')
        },
        {
          path: '/classTem',
          name: 'classTem',
          component: () => import('@/views/subMenu/classTem/index.vue')
        },
        {
          path: '/Personal',
          name: 'Personal',
          component: () => import('@/views/subMenu/Personal/index.vue')
        },
        {
            path: '/ikun',
            name: 'ikun',
            component: () => import('@/views/subMenu/ikun/index.vue')
          },
      ]
  },
  {
    path: '/adminhome',
    name: 'adminhome',
    component: Adminhome,
    children: [
        {
          path: '/adminPersonal',
          name: 'adminPersonal',
          component: () => import('@/views/adminsubMenu/Personal/index.vue')
        },
        {
          path: '/ResetPassword',
          name: 'ResetPassword',
          component: () => import('@/views/adminsubMenu/ResetPassword/index.vue')
        }
      ]
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
