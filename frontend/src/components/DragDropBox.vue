<template>
  <div class="container row">
      <v-card class="file-upload-container mt-4"
          @dragenter="onDragenter"
          @dragover="onDragover"
          @dragleave="onDragleave"
          @drop="onDrop"
          @click="onClick"
      >
        <div class="file-upload" :class="isDragged ? 'dragged' : ''">
          Drag & Drop img File Plz...
        </div>
      </v-card>
    <!-- 파일 업로드 -->
    <input type="file" ref="fileInput" class="file-upload-input" @change="onFileChange" accept=".jpg, .jpeg">
    <!-- 업로드된 리스트 -->
    <div class="file-info" v-if="foodFile !== null">
      <div class="name text-center mt-4 mb-2">
        {{ foodFile.name }}
      </div>
    </div>
    <!-- 파일 변환 보내기 -->
    <div class="file-upload-list__item__btn-convert mt-04">
      <v-btn block elevation="4" @click="uploadFile()">Submit</v-btn>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import router from "@/router";
export default {
  name: "DragDropBox",
  data(){
    return {
      isDragged: null,
      fileList: [],
      foodFile: null,
      foodDTO: {
        foodName: null,
        foodInfo: null,
        foodProtein: null
      },
    }
  },
  methods:{
    onClick () {
      this.$refs.fileInput.click()
    },
    onDragenter (event) {
      // class 넣기
      this.isDragged = true
    },
    onDragleave (event) {
      // class 삭제
      this.isDragged = false
    },
    onDragover (event) {
      // 드롭을 허용하도록 prevetDefault() 호출
      event.preventDefault()
    },
    onDrop (event) {
      // 기본 액션을 막음 (링크 열기같은 것들)
      event.preventDefault()
      this.isDragged = false
      const files = event.dataTransfer.files
      if (files.length > 1) {
        return;
      }
      this.addFiles(files)
    },
    onFileChange (event) {
      const file = event.target.files
      if (file.length > 1) {
        return;
      }
      this.addFiles(file)
    },
    async addFiles (file) {
      const src = await this.readFiles(file[0])
      file[0].src = src
      this.foodFile = file[0]
    },

    // FileReader를 통해 파일을 읽어 thumbnail 영역의 src 값으로 셋팅
    async readFiles (files) {
      return new Promise((resolve, reject) => {
        const reader = new FileReader()
        reader.onload = async (e) => {
          resolve(e.target.result)
        }
        reader.readAsDataURL(files)
      })
    },

    //uploadFiles axios 파일 전송
    uploadFile() {
      if (this.foodFile === null) {
        return
      }
      const formData = new FormData();
      formData.append("foodFile", this.foodFile);
      formData.append("foodDTO", JSON.stringify(this.foodDTO));

      axios.post('/food/save', formData, {
        headers: {
          "Content-Type": "multipart/form-data"
        },
      }).then(res => {
        // 데이터 처리
        console.log(res.data);

      })
    }
  }
}
</script>

<style lang="scss" scoped>
.v-btn {
  background-color: #F7E0D3;
}
.container {
  min-height: 150px;
  width: 300px;
  margin: 0 auto;
}
.file-upload {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
  border: transparent;
  border-radius: 20px;
  cursor: pointer;
  &.dragged {
    border: 1px dashed rgba(192,192,192,0.3);
    opacity: .6;
  }
  &-container {
    background-color: rgba(192,192,192,0.3);

    height: 240px;

    padding: 20px;
    margin: 0 auto;
    box-shadow: 0 0.625rem 1.25rem #0000001a;
    border-radius: 20px;
  }
  &-input {
    display: none;
  }
  &-list {
    margin-top: 10px;
    width: 100%;
    &__item {
      padding: 10px;
      display: flex;
      justify-content: space-between;
      align-items: center;
      &__data {
        display: flex;
        align-items: center;
        &-thumbnail {
          margin-right: 10px;
          border-radius: 20px;
          width: 120px;
          height: 120px;
        }
      }
      &__btn-remove {
        cursor: pointer;
        background-color: rgba(192,192,192,0.3);
        border: 1px solid black;
        display: flex;
        justify-content: center;
        align-items: center;
        padding: 5px;
        border-radius: 6px;
      }
      &__btn-convert {
        width: 300px;
        color: black;
        cursor: pointer;
        border : none;
        display: flex;
        justify-content: center;
        align-items: center;
        padding: 5px;
        border-radius: 6px;
      }

    }
  }
}
</style>
