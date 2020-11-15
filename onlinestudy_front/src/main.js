import Vue from 'vue'
import App from './App.vue'
import Router from './router'
import back from './network'
import store from './store'
import elementUi from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css';
Vue.config.productionTip = false
Vue.prototype.back = back
Vue.prototype.src = 'http://localhost:9090/'

Vue.use(elementUi)

new Vue({
  router: Router,
  store,
  render: h => h(App)
}).$mount('#app')
