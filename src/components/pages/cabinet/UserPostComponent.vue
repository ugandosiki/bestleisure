<template>
  <div class="post shadow-2">
    <q-img :src="src + postImage.path" style="height: 200px; max-width: 200px">
      <template v-slot:loading>
        <q-spinner-gears color="white" />
      </template>
    </q-img>
    <div class="post_content">
      <div class="post_title">
        <p>
          <strong>{{ post.title }}</strong>
        </p>
      </div>
      <div class="post_descr">
        {{ post.description }}
      </div>
      <div class="post_info">
        <div class="likes">
          <q-icon :name="matThumbUp" size="18px" /><span>{{ post.likes }}</span>
        </div>
        <div class="country">
          <strong>{{ post.category.name }}</strong>
        </div>
        <div class="city">
          <strong>{{ post.subCategory.name }}</strong>
        </div>
      </div>
      <router-link :to="{ name: 'Post', params: { id: post.id } }" tag="button"
        >Перейти на страницу</router-link
      >
    </div>
  </div>
</template>

<script>
import { matThumbUp } from "@quasar/extras/material-icons";
export default {
  name: "PostComponent",
  data() {
    return {
      src: "http://localhost:8080/uploads/",
      matThumbUp: null,
    };
  },
  props: {
    post: { default: Object },
  },
  computed: {
    postImage() {
      let postImage = {};
      this.post.images.forEach((e) => {
        if (e.path.match(/Post/g)) {
          postImage = e;
          console.log(postImage);
        }   
      });
      return postImage;
    },
  },
  created() {
    this.matThumbUp = matThumbUp;
  },
};
</script>

<style scoped>
.post {
  background: rgba(255, 255, 255, 0.8);
  display: flex;
  width: 97%;
  padding: 10px;
  margin: 10px;
  align-items: center;
  position: relative;
  z-index: 1;
  font-family: "Roboto Condensed", sans-serif;
}
.post_content {
  width: 80%;
}
.post_title p {
  text-align: center;
  margin-bottom: 0;
  font-size: 12pt;
}
.post_descr {
  text-align: justify;
  margin-left: 5px;
}
.post_content button {
  color: white;
  background: #08b8b8;
  border: 1px solid #07a7a7;
  cursor: pointer;
  margin-left: 5px;
  margin-top: 10px;
  padding: 5px 20px;
}
.post_content button:hover {
  transition-duration: 0.3s;
  background: #0080e3;
}
.likes {
  font-size: 16pt;
  margin-left: 5px;
}
.post_info {
  display: flex;
  align-items: baseline;
}
.post_info div {
  margin-left: 10px;
}
</style>