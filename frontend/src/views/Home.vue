<template>
  <v-container class="">
    <v-row>
      <div>
        <TodayHealthInfo />
      </div>
      <v-col>
        <DrawGraph />
      </v-col>
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
