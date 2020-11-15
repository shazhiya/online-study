export default {
    path: 'mine',
    components:{
        main: () =>import('component/mine/index'),
    },
    children:[{
        name: 'mine',
        path: '',
        components:{
            mine: ()=> import('component/mine/home')
        }
    },{
        name:'edit',
        path:'edit',
        components:{
            mine: ()=>import('component/mine/edit')
        }
    }]
}