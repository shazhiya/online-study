import userManager from '../userManager'
import mine from '../mine'
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
        mine
    ]
}