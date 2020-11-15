import security from './security'
import post from '../util'
export default {
    namespaced: true,
    state:{
        username:'',
        password:'',
        profile:{},
        userPage: {},
        userInfo:{}
    },
    mutations:{
        updateUserName(state,data){
            state.username = data.username
        },
        updateProfile(state,data){
            state.profile = data
        },
        updateUserPage(state,data){
            state.userPage = data
        },
        updateUserInfo(state,data){
            state.userInfo = data
        }
    },
    modules:{
        security
    },
    actions:{
        getProfile({commit},userName){
            return post('user/getProfileByUsername',{userName:userName},res=>{
                commit('updateProfile',res.data)
            })
        },
        getInfo({commit},userName){
            return post('user/getProfileByUsername',{userName:userName},res=>{
                commit('updateUserInfo',res.data)
            })
        },
        getUserPage({commit},data){
            return post('user/list',data,res=>{
                commit('updateUserPage',res.data)
            },true)
        }
    }
}