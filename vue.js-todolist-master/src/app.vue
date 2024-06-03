<!--app.vue-->
<template>
  <div id="app">
    <Header></Header>
    <login v-if="showLogin" @login-success="handleLoginSuccess" />
    <Todo v-if="!showLogin" ref="todoRef"></Todo>
    <Footer></Footer>
  </div>
</template>

<script>
import Header from './todo/header.vue'
import Footer from './todo/footer.jsx'
import Todo from './todo/todo.vue'
import login from './todo/login.vue'

export default {
  data() {
    return {
      showLogin: true
    };
  },
  components: {
    Header,
    Footer,
    Todo,
    login
  },
  methods: {
    handleLoginSuccess(userData) {
      console.log('handleLoginSuccess called', userData);
      sessionStorage.setItem('name', userData.name);
      sessionStorage.setItem('pwd', userData.pwd);
      console.log('Data stored in sessionStorage');
      this.showLogin = false;
      this.$nextTick(() => {
        setTimeout(() => {
          if (this.$refs.todoRef) {
            this.$refs.todoRef.fetchTodoItems();
          }
        }, 0);
      });
    }
  }
}
</script>

<style lang="stylus" scoped>
  #app
    position absolute
    left 0
    right 0
    top 0
    bottom 0
    #cover
        position absolute
        left 0
        right 0
        top 0
        bottom 0   
        background-color #999 
        opacity 0.2
        z-index -1
</style>