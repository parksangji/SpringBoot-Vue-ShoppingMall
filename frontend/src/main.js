import App from './App.vue';
import { store }  from './store/index.js';
import { router } from './router/index.js';
import axios from 'axios';
import { createApp } from 'vue';


const app = createApp(App)
axios.defaults.baseURL = "http://localhost:8080";
app.use(router)
app.use(store)
app.mount('#app')

app.config.globalProperties.axios=axios   // axios 전역사용
app.config.globalProperties.store=store   // store 전역사용
app.config.globalProperties.router=router // router 전역사용

import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'
import "bootstrap-vue/dist/bootstrap-vue.css";