<template>
  <v-container>
    <form action="">
      <v-text-field
        v-model="registerInfo.userEmail"
        :rules="fieldRules"
        label="ID"
        required
      />
      <v-text-field
        v-model="registerInfo.userPwd"
        :rules="fieldRules"
        label="pwd"
        required
      />
      <v-text-field
        v-model="registerInfo.userName"
        :rules="fieldRules"
        label="name"
        required
      />
      <v-text-field
        v-model="registerInfo.userWeight"
        :rules="fieldRules"
        label="weight"
        required
      />
      <v-text-field
        v-model="registerInfo.userHeight"
        :rules="fieldRules"
        label="height"
        required
      />
      <v-text-field
        v-model="registerInfo.userAge"
        :rules="fieldRules"
        label="age"
        required
      />
      <v-text-field
        v-model="registerInfo.userSex"
        :rules="fieldRules"
        label="sex"
        required
      />
      <v-text-field
        v-model="registerInfo.userAddr"
        :rules="fieldRules"
        label="Addr"
        required
      />
      <v-text-field
        v-model="registerInfo.userPhonenum"
        :rules="fieldRules"
        label="PhoneNum"
        required
      />
      <div>
        <v-btn @click="register">submit</v-btn>
      </div>
    </form>
  </v-container>
</template>

<script>
import axios from "axios";
import router from "@/router";

export default {
  name: "RegisterForm",
  data: function () {
    return {
      registerInfo: {
        userEmail: "",
        userPwd: "",
        userName: "",
        userWeight: "",
        userHeight: "",
        userAge: "",
        userSex: "",
        userAddr: "",
        userPhonenum: "",
        userAuthority: "0"
      },
      fieldRules: [v => !!v || 'This field is required'],
    }
  },
  //todo: id, password 값 넘기기
  //todo: res custom, admin 판단
  methods: {
    register() {
      console.log({...this.registerInfo})
      axios.post('/user/save', { ...this.registerInfo }).then((res) => {
        console.log("register완료")
        console.log(res)
        router.push({
          path: '/'
        });
      });
    }
  }
}
</script>

<style scoped>

</style>
