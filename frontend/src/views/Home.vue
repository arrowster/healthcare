<template>
  <v-container class="">
    <v-row>
      <TodayHealthInfo />
    </v-row>
    <v-row>
      <DrawGraph />
    </v-row>
  </v-container>
</template>

<script>
  import TodayHealthInfo from "@/components/TodayHealthInfo";
  import DrawGraph from "@/components/DrawGraph";
  export default {
    components: {
      TodayHealthInfo, DrawGraph
    },
    name: "Home",
  }
</script>
