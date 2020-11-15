import post from '../../util'
export default{
    namespaced: true,
    state: {
        roles: [],
        securities: []
    },
    mutations: {
        updateData(state,data){
            state.roles = data.roles
            state.securities = data.securities
        }
    },
    actions:{
        querySecuritiesByUsername({commit},user){
            return post('/user/querySecuritiesByUsername',user,res=>{
                commit('updateData',{roles: res.data.roles,securities: res.data.securities})
            })
        }
    }
}