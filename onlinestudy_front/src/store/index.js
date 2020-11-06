import Vue from 'vue'
import Vuex from 'vuex'
import user from './user'
import post from './util'

Vue.use(Vuex)

export default new Vuex.Store({
  state:{
    signUp: false
  },
  modules: {
    user
  },
  mutations:{
    changeSignUp(state,flag){
      state.signUp = flag
    }
  },
  actions:{
    login({commit},data){
      return post('login',data,res=>{
        if(res.data != 'success') return false
        commit('changeSignUp',true)
        commit('user/updateUserInfo',data,{root:true})
        return true
      },true)
    },
    register({},data){
      return post('register',data,res=>{
        return res.data
      })
    }
  }
})
