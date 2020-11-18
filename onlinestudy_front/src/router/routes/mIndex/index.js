import userManager from '../userManager'
import mine from '../mine'
import courseManager from '../courseManager'
import study from '../study'
export default {
    path: '/index',
    components:{
        default:  ()=> import('view')
    },
    children:[
        {
            name:'index',
            path:'',
            components: {
                main: ()=> import('component/home/home')
            }
        },
        userManager,
        mine,
        courseManager,
        study
    ]
}