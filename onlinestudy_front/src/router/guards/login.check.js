import store from '../../store'

export default function check(to,from,next){
    if(to.name == 'register') return false;
    if(to.name!='login' && !store.state.signUp){
        next({name:'login',params:{login:'login'}})
        return true
    }
    return false
}