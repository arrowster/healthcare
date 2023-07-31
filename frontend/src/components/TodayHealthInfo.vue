<template>
    <v-card class="v-card pd-4">
      <v-card class="childCard">
        <span>나의 기초 대사량</span><br>
        <span>{{ myHealthInfo.basicMetabolic }} kcal</span>
      </v-card>
      <v-card class="childCard">
        <span>오늘 운동량</span><br>
        <span>{{ myHealthInfo.toDayExercise }} kcal</span>
      </v-card>
      <v-card class="childCard">
        <span>남은 칼로리</span><br>
        <span>{{ myHealthInfo.leftMetabolic }} kcal</span>
      </v-card>
    </v-card>
</template>

<script>
export default {
  name: "TodayHealthInfo",
  data: () => {
    return {
      myHealthInfo: {
        basicMetabolic: "2067",
        toDayExercise: "4",
        leftMetabolic: "2063"
      },
    }
  },
  methods:{
    //???
  }
}
</script>

<style scoped>
  .v-card{
    width: max-content;
    padding: 4px;
    height: auto;
  }
  .childCard{
    width: auto;
    padding-bottom: 2px;
    margin-top: 2px;
    margin-bottom: 2px;
  }
</style>
