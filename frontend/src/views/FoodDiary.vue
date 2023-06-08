<template>
  <v-container>
    <v-row dense>
        <PhotoBox />
        <DragDropBox />
    </v-row>
  </v-container>
</template>

<script>
import DragDropBox from "@/components/DragDropBox";
import PhotoBox from "@/components/PhotoBox";

export default {
  components: {
    DragDropBox, PhotoBox
  },
  name: "foodDiary"
}
</script>

<style scoped>

</style>
