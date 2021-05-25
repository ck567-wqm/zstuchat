import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

Vue.config.productionTip = false

import Element from 'element-ui'
import "element-ui/lib/theme-chalk/index.css"
Vue.use(Element)

//导入全局样式表
import './assets/css/global.css'
//引入字体图标库
import './assets/iconfont/iconfont.css'


import axios from 'axios'
//配置请求的根路径
let BASE_URL = 'http://localhost:8081'
axios.defaults.baseURL = BASE_URL
//给请求头中添加token
axios.interceptors.request.use(config => {
  config.headers.Authorization = window.sessionStorage.getItem('token') || null
  return config
})
Vue.prototype.$http = axios
Vue.prototype.$apiServer = 'http://localhost:3100'

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
