import Vue from 'vue'
import App from './App.vue'
import Router from './router'
import back from './network'
import store from './store'

Vue.config.productionTip = false
Vue.prototype.back = back

new Vue({
  router: Router,
  store,
  render: h => h(App)
}).$mount('#app')
