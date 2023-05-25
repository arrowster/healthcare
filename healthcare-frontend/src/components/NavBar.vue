<template>
  <v-app-bar class="d-flex" color="#5F7EAF" elevation="4" rounded app>
    <v-app-bar-title>
      <router-link to="/">
        <v-icon icon="mdi-book-music"/> HealthCare
      </router-link>
    </v-app-bar-title>
    <form id="navForm">
      <v-text-field
        v-model="user.id"
        label="ID"
        required
      />
      <v-text-field
        v-model="user.pwd"
        type="password"
        label="Password"
        required
      />
      <v-btn class="mr-2" @click="login">login</v-btn>
      <router-link to="/register">register</router-link>
    </form>
  </v-app-bar>
</template>

<script>
import axios from "axios";

export default {
  name: "NavBar",
  data: function () {
    return {
      user: { //todo: 칼럼 명 맞춰야함
        id: "",
        pwd: ""
      }
    }
  },
  methods: {
    login() {
      //todo: id, password 값 넘기기
      //todo: res custom, admin 판단
      console.log("login btn 클릭")
      console.log({...this.user})
      axios.post('/user/login', { ...this.user }).then((res) => {
        //todo: sdf
        if (res.data === 1){  //admin
          window.location.href = '/';
        }
        else {  //nomalUser
          window.location.href = '/admin';
        }
      })
    },
    logout() {
      this.user.id = ""
      this.user.password = ""
      alert('logout 성공')
    },
  }
}
</script>

<style lang="scss" scoped>
a{
  text-decoration: none; /* 링크의 밑줄 제거 */
  color: #F7E0D3; /* 링크의 색상 제거 */
}
form{
  display: flex;
  flex-direction: row;
  align-items: center;
  margin-right: 8px;
  .v-text-field{
    margin-right: 8px !important;
    margin-top: 10px !important;
    width: 200px;
  }
}
</style>
