// index.js
import Vue from 'vue';
import App from './app.vue';
import store from './store'; // 导入 Vuex store
import './assets/styles/style.styl'
import './assets/styles/global.styl';

const root = document.createElement('div');
document.body.appendChild(root);

new Vue({
  store,
  render: (h) => h(App)
}).$mount(root)