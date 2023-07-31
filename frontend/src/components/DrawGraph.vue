<template>
  <v-container>
    <div>test graph</div>
    <Line :data="data" :options="options"/>
  </v-container>
</template>

<script>
import axios from 'axios'
import { Line } from 'vue-chartjs'
import { Chart as ChartJS, CategoryScale, LinearScale, PointElement, LineElement, Title, Tooltip, Legend } from 'chart.js'

ChartJS.register(CategoryScale, LinearScale, PointElement, LineElement, Title, Tooltip, Legend)

export default {
  name: 'DrawGraph',
  components: { Line },
  data() {
    return {
      data: {
        labels: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
        datasets: [{
          label: '남은 칼로리',
          backgroundColor: '#f87979',
          data: [40, 39, -10, 40, 39, 80, 40]
        }]
      },
      options: {
        responsive: true,
        maintainAspectRatio: true
      }
    }
  },
  methods: {
    getHealthInfo() {
      axios.get('/food/photo').then(res => {
        this.imagePaths = res.data
        this.getImage(this.imagePaths)
      }).catch(err => {
        console.log(err)
      })
    },
  }
}
</script>

<style scoped>

</style>
