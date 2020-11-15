import post from '../util'
export default{
    namespaced:true,
    state:{
        allRole:[]
    },
    mutations:{
        updateRole(state,data){
            state.allRole = data
        }
    },
    actions:{
        allRole({commit}){
            return post('security/allRole',{},res=>{
                commit('updateRole',res.data)
            })
        }
    }
}