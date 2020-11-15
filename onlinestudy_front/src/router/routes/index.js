import index from './mIndex'
const routes = [
    {
        name: 'root',
        path:'/',
        component: ()=> import('view/login')
    },
    {
        name: 'login',
        path: '/login',
        component: ()=> import('view/login')
    },
    {
        name: 'register',
        path: '/register',
        component: ()=> import('view/register')
    },
    {
        name: '404',
        path: '/NotFound',
        component: ()=>import('view/404')
    },
    index
]

export default routes