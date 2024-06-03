<template>
  <div v-if="showCard" class="login-container">
    <div v-if="showLogin" class="login-card">
      <h2>Login</h2>
      <input type="text" placeholder="Username" v-model="name">
      <input type="password" placeholder="Password" v-model="pwd">
      <button @click="login">Login</button>
      <div class="register-link">
        Don't have an account? <a href="#" @click="showRegisterForm">Register</a>
      </div>
    </div>
    <div v-if="showRegister" class="register-card">
      <h2>Register</h2>
      <input type="text" placeholder="Username" v-model="newname">
      <input type="password" placeholder="Password" v-model="newPwd">
      <button @click="register">Register</button>
      <div class="login-link">
        Already have an account? <a href="#" @click="showLoginForm">Login</a>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      name: '',
      pwd: '',
      newname: '',
      newPwd: '',
      showRegister: false,
      showLogin:true,
      showCard:true
    };
  },
  methods: {
    login() {
      if (!this.validateCredentials(this.name, this.pwd)) {
        return;
      }
      const data = {
        name: this.name,
        pwd: this.pwd
      };
      axios.post('http://localhost:8081/login', data)
          .then(response => {
            console.log('Login successful', response.data);
            this.$emit('login-success', response.data); // 将用户数据传递给父组件
          })
          .catch(error => {
            console.error('Login failed', error);
            alert('Login failed. Please check your username or password.');
          });
    },
    showRegisterForm() {
      this.showRegister = true;
      this.showLogin=false;
    },
    showLoginForm() {
      this.showRegister = false;
      this.showLogin = true;
    },
    register() {
      if (!this.validateCredentials(this.newname, this.newPwd)) {
        return;
      }
      const data={
        name: this.newname,
        pwd: this.newPwd
      };
      axios.post('http://localhost:8081/add',data)
          .then(response => {
            this.showRegister = false;
            this.showLogin = true;
          })
          .catch(error => {
            alert('Username already exits.Please change ur name.');
          });
    },
    validateCredentials(username, password) {
      if (username.length < 4) {
        alert('Username must be at least 4 characters long.');
        return false;
      }
      if (password.length < 3) {
        alert('Password must be at least 3 characters long.');
        return false;
      }
      return true;
    }
  }
};
</script>

<style lang="stylus" scoped>
.login-container {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: rgba(0, 0, 0, 0.5);
  z-index: 9999; /* 设置一个较大的 z-index 值，确保登录框在主页面上方 */
}
.login-card {
  padding: 20px;
  background-color: #f5f5f5;
  border-radius: 5px;
  text-align: center;
}

.register-card {
  padding: 20px;
  background-color: #f5f5f5;
  border-radius: 5px;
  text-align: center;
  margin-top: 20px;
}

input {
  margin: 10px 0;
  padding: 5px;
  width: 100%;
}

button {
  margin-top: 10px;
  padding: 5px 10px;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 3px;
}

.register-link,
.login-link {
  margin-top: 10px;
}

a {
  color: #007bff;
  text-decoration: underline;
  cursor: pointer;
}
</style>
