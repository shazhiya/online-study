const routes = [
    {
        name: 'login',
        path: '/login',
        component: ()=> import('view/login')
    },
    {
        name: 'register',
        path: '/register',
        component: ()=> import('view/register')
    }
]

export default routes