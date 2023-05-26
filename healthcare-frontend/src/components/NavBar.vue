<template>
  <v-app-bar class="d-flex" color="#5F7EAF" elevation="4" rounded app>
    <v-app-bar-title>
      <router-link to="/">
        <v-icon icon="mdi-book-music"/> HealthCare
      </router-link>
    </v-app-bar-title>
    <span class="mr-2" v-if="flag">
			Logged in as {{ username }} | <span @click="logout">logout</span>
		</span>
    <form id="navForm" v-else>
      <v-text-field
        v-model="user.userEmail"
        label="ID"
        required
      />
      <v-text-field
        v-model="user.userPwd"
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
import router from "@/router";

export default {
  name: "NavBar",
  data:  () => {
    return {
      user: { //todo: 칼럼 명 맞춰야함
        userEmail: "",
        userPwd: ""
      },
      username: "",
      flag: false
    }
  },
  methods: {
    login() {
      console.log("login btn 클릭")
      console.log({...this.user})
      axios.post('/user/login', { ...this.user }).then((res) => {
        const userType = res.data.userType;
        const userInfo = res.data.userInfo;
        console.log(res.data)
        if (userType === "admin"){  //admin
          router.push({
            path: '/admin'
          })
        }
        else {  //normalUser
          this.flag = !(this.flag)
        }
      }).catch(()=>{
        alert("ID 혹은 PassWord가 올바르지 않습니다.")
      })
    },
    logout() {
      this.user.userEmail = ""
      this.user.userPwd = ""
      alert('logout 성공')
      window.location.href = '/'
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
