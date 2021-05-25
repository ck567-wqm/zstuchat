import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Login from "@/views/Login";
import About from "@/views/About";
import HomeMain from "@/components/HomeMain";
import UserInfo from "@/components/UserInfo";
import MyInfo from "@/components/UserInfo/MyInfo";
import Account from "@/components/UserInfo/Account";
import MyMessage from "@/components/UserInfo/MyMessage";
import Register from "@/views/Register";
import Chatting from "@/components/Chatting";
import {Message} from "element-ui";
import Music from "@/components/Music";
import MusicRoom from "@/components/MusicRoom";
import Dynamic from "@/components/Dynamic";
import MyFriend from "@/components/UserInfo/MyFriend";
import AddFriend from "@/components/UserInfo/AddFriend";
import AddMessage from "@/components/UserInfo/AddMessage";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    component: Home,
    meta: {
      requireAuth: false
    },
    children: [{
      path: '/',
      meta: {
        requireAuth: false
      },
      component: HomeMain
    }, {
      path: '/userinfo',
      component: UserInfo,
      meta: {
        requireAuth: true
      },
      children: [{
        path: '/userinfo/1',
        component: MyInfo,
        meta: {
          requireAuth: true
        },
      }, {
        path: '/userinfo/2',
        component: Account,
        meta: {
          requireAuth: true
        },
      }, {
        path: '/userinfo/3',
        component: MyMessage,
        meta: {
          requireAuth: true
        },
      }, {
        path: '/userinfo/4',
        component: MyFriend,
        meta: {
          requireAuth: true
        },
      }, {
        path: '/userinfo/5',
        component: AddFriend,
        meta: {
          requireAuth: true
        },
      }, {
        path: '/userinfo/6',
        component: AddMessage,
        meta: {
          requireAuth: true
        },
      }]
    }, {
      path: '/chatting',
      component: Chatting,
      meta: {
        requireAuth: true
      }
    },
      {
        path: '/music',
        component: Music,
        meta: {
          requireAuth: false
        }
      },
      {
        path: '/dynamic',
        component: Dynamic,
        meta: {
          requireAuth: false
        }
      },
      {
        path: '/find',
        component: MusicRoom,
        meta: {
          requireAuth: false
        }
      },
      {
        path: '/About',
        component: About,
        meta: {
          requireAuth: false
        }
      }]
  },

  {
    path: '/login',
    name: 'login',
    component: Login
  },
  {
    path: '/register',
    component: Register,
    meta: {
      requireAuth: false
    }
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

router.beforeEach((to, form, next) => {
  if (to.path === '/login' || to.path === '/register') return next()
  const tokenStr = window.sessionStorage.getItem('token')
  if (!tokenStr && to.meta.requireAuth) {
    Message.warning('请先登录')
    next('/login')
  } else {
    next()
  }
})

export default router
