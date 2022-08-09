import {createRouter,createWebHistory} from 'vue-router'

const routes = [
    {
        path: '/',
        redirect : '/api/login'
    },
    {
        path: '/api/login',
        component : () => import('@/components/login')
    },
    {
        path: '/api/signup',
        component : () => import('@/components/signup')
    }
]

export const router = createRouter({
    history : createWebHistory(),
    routes
});