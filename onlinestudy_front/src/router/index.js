import Vue from 'vue'
import VueRouter from 'vue-router'
import routes from './routes'
import {beforeEach} from './guards'

Vue.use(VueRouter)

const router = new VueRouter({
  routes,
  mode: 'hash'
})


router.beforeEach(beforeEach)

export default router
