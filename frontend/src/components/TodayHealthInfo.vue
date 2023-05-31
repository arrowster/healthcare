<template>
  <v-container>
    <v-card>
      <span>나의 기초 대사량</span>
      <span>오늘 운동량</span>
      <span>남은 칼로리</span>
    </v-card>
  </v-container>
</template>

<script>
export default {
  name: "TodayHealthInfo",
  data: () => {
    return {
      myHealthInfo: {
        basic_metabolic: "",
        toDay_exercise: "",
        left_metabolic: ""
      },
    }
  },
  methods:{
    //???
  }
}
</script>

<style scoped>

</style>
