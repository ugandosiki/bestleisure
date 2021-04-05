<template>
  <div class="post">
    <q-img :src="src + postImage.path" style="height: 140px; max-width: 100%">
      <template v-slot:loading>
        <q-spinner-gears color="white" />
      </template>
    </q-img>
    <div class="post_content">
      <div class="post_title">
        <p>
          <strong>{{ postData.title }}</strong>
        </p>
      </div>
      <div class="post_descr">
        {{ postData.description.substr(0, 150).trim() + "..." }}
        <p>
          <q-icon name="favorite" color="primary" size="22px" />
          <strong>{{ postData.userLikes.length }}</strong>
          {{ postData.category.name }} - {{ postData.subCategory.name }}
        </p>
      </div>
    </div>
    <q-btn
      flat
      color="white"
      @click="$router.push({ name: 'Post', params: { id: postData.id } })"
    >
      Перейти на страницу
    </q-btn>
  </div>
</template>

<script>
export default {
  name: "InterestingPostComponent",
  data() {
    return {
      src: "http://localhost:8080/uploads/",
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
};
</script>

<style scoped>
.post {
  display: flex;
  width: 25%;
  margin: 10px;
  flex-direction: column;
  position: relative;
  z-index: 9998;
  font-family: "Roboto Condensed", sans-serif;
  height: 100%;
}
.post_content {
  height: 100%;
  width: 100%;
}
.post_title {
  text-transform: uppercase;
  text-align: center;
}
.post_title p {
  width: 100%;
  text-align: center;
  font-size: 12pt;
}
.post_descr {
  text-align: justify;
  margin-left: 5px;
  height: 100%;
}
button {
  background: #08b8b8;
  display: block;
  border: none;
  cursor: pointer;
  margin-left: 5px;
  width: 100%;
}
button:hover {
  transition-duration: 0.3s;
  color: white;
  background: #0080e3;
}
</style>