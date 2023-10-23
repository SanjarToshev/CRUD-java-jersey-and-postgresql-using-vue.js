import { createApp } from 'vue'
import App from './App.vue'
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap.min.js'


import { createRouter, createWebHistory } from 'vue-router';
axios.defaults.baseURL = process.env.VUE_APP_API_URL
axios.interceptors.request.use(function (config) {
    config.headers['X-Binarybox-Api-Key'] = process.env.VUE_APP_API_KEY;
    return config;
});

const router = createRouter({
    history: createWebHistory(),
    routes: [
        { path: '/', name:'home', component: ()=>import('../src/views/ViewUsers.vue') },
        { path: '/add',name: 'add', component: () =>import('../src/views/AddUser.vue') },
        { path: '/edit/:id', name: 'edit', component: ()=>import('../src/views/UpdateUser.vue') },
    ],
});

createApp(App).use(router).mount('#app');