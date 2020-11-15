import router from '../index'

export default function(to,from){
    if(to.name == from.name) router.go(0)
}