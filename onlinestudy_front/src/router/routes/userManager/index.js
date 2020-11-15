export default {
    name:'userManager',
    path: 'usermanager',
    components:{
        main: () => import('component/userManager/userManager'),
        default: () => import('view')
    }
}