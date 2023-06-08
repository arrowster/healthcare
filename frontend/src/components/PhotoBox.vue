<template>
  <v-card class="mx-auto d-flex justify-center" max-width="500">
    <v-container fluid class="d-flex container">
      <div v-if="photos.length === 0">
        지금은 보여드릴 사진이 없네요... 사진을 추가해 보세요!
      </div>
      <v-row dense>
        <v-col v-for="card in photos" :key="card.title">
          <v-card>
            <v-img :src="card.src" class="align-end" gradient="to bottom, rgba(0,0,0,.1), rgba(0,0,0,.5)" height="200px" cover>
              <v-card-title class="text-white" v-text="card.title"/>
            </v-img>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </v-card>
</template>

<script>
import axios from 'axios'
export default {
  name: "PhotoBox",
  data() {
    return {
      photos: [],
      imagePaths:[]
    }
  },
  mounted() {
    this.getPhotos()
  },
  methods: {
    getPhotos() {
      axios.get('/food/photo').then(res => {
        this.imagePaths = res.data
          this.getImage(this.imagePaths)
      }).catch(err => {
        console.log(err)
      })
    },
    getImage(imagePath) {
      return imagePath.map(filePath => {
        const fileName = filePath.split('/').pop(); // Extract the file name
        axios.get(`/food/photo/${(fileName)}`, {
          responseType: 'arraybuffer'
        }).then(res => {
          const imageBlob = new Blob([res.data], { type: 'image/jpeg' });
          const imageUrl = URL.createObjectURL(imageBlob);

          this.photos.push({ title: fileName, src: imageUrl, flex: 8 });
        }).catch(error => {
          console.log(error);
        });
      });
    }
  }
}
</script>

<style scoped>
.container {
  align-items: center;
}
</style>
