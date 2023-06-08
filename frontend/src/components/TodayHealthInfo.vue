<template>
  <v-container>
    <v-card>
      <span>나의 기초 대사량</span>
      <span>{${ basicMetabolic }}</span>
      <span>오늘 운동량</span>
      <span>{${ toDayExercise }}</span>
      <span>남은 칼로리</span>
      <span>{${ leftMetabolic }}</span>
    </v-card>
  </v-container>
</template>

<script>
export default {
  name: "TodayHealthInfo",
  data: () => {
    return {
      myHealthInfo: {
        basicMetabolic: "",
        toDayExercise: "",
        leftMetabolic: ""
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
