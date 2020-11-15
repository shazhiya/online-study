export default function(to,from,next){
    if(to.matched.length === 0){
        next({name:'404',params:{path: to.path}})
        return true
    }
    return false
}