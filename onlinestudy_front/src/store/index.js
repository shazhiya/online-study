import Vue from 'vue'
import Vuex from 'vuex'
import user from './user'
import security from './security'
import post from './util'
import createPersistedState from "vuex-persistedstate"


Vue.use(Vuex)

export default new Vuex.Store({
  state:{
    signUp: false
  },
  modules: {
    user,security
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
        commit('user/updateUserName',data,{root:true})
        return true
      },true)
    },
    register(store,data){
      return post('register',data,res=>{
        return res.data
      })
    }
  },
  plugins: [createPersistedState({storage : window.sessionStorage})]
})
