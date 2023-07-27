<template>
    <v-card class="v-card pd-4">
      <v-card class="childCard">
        <span>나의 기초 대사량</span><br>
        <span>{{ myHealthInfo.basicMetabolic }}</span>
      </v-card>
      <v-card class="childCard">
        <span>오늘 운동량</span><br>
        <span>{{ myHealthInfo.toDayExercise }}</span>
      </v-card>
      <v-card class="childCard">
        <span>남은 칼로리</span><br>
        <span>{{ myHealthInfo.leftMetabolic }}</span>
      </v-card>
    </v-card>
</template>

<script>
export default {
  name: "TodayHealthInfo",
  data: () => {
    return {
      myHealthInfo: {
        basicMetabolic: "testBasic",
        toDayExercise: "testExer",
        leftMetabolic: "testMetabolic"
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
