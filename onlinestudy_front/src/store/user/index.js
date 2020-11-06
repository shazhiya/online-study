export default {
    namespaced: true,
    state:{
        username:'',
        password:'',
    },
    mutations:{
        updateUserInfo(state,data){
            state.username = data.username
        }
    }
}