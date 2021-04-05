<template>
  <div class="post">
    <q-card class="my-card" flat bordered>
      <q-card-section horizontal>
        <q-card-section class="q-pt-xs col-7">
          <div class="text-overline">
            {{ postData.category.name }}-{{ postData.subCategory.name }}
          </div>
          <div class="text-h5 q-mt-sm q-mb-xs">{{ postData.title }}</div>
          <div class="text-caption text-grey">
            {{ postData.description.substr(0, 300).trim() +"..." }}
          </div>
        </q-card-section>

        <q-card-section class="col-5 flex on-right">
          <q-img class="rounded-borders" :src="src + postImage.path" />
        </q-card-section>
      </q-card-section>

      <q-separator />

      <q-card-actions>
        <q-icon name="favorite" color="primary" size="20px"/><span style="font-size: 18pt;text-align:center;">{{postData.userLikes.length}}</span>
        <q-btn flat color="primary" @click="$router.push({ name: 'Post', params: { id: postData.id } })"> Перейти на страницу </q-btn>
      </q-card-actions>
    </q-card>

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
    postData: Object,
  },
  computed: {
    postImage() {
      let postImage = {};
      this.postData.images.forEach((e) => {
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
  
  
  width: 97%;
 
  z-index: 1;
 
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