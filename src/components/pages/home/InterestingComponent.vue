<template>
  <div class="interesting shadow-2">
    <div class="block_title">
      <span>Самое интересное</span>
    </div>
    <div class="block_posts">
      <div class="post-null" v-if="fetchedPosts.length == 0">Рекомендаций для вашего города пока что нет</div>
      <interesting-post-component
        v-else
        class="post"
        v-for="post in fetchedPosts"
        :key="post.id"
        :postData="post"
      />
    </div>
  </div>
</template>

<script>
import InterestingPostComponent from "./InterestingPostComponent.vue";
export default {
  components: { InterestingPostComponent },
  name: "InterestingComponent",
  computed: {
    fetchedPosts() {
      return this.$store.state.post.posts
        .filter((e) => e.subCategory.name == this.$store.state.auth.user.city)
        .sort(function (a, b) {
          return b.userLikes.length - a.userLikes.length;
        })
        .slice(0, 4);
    },
  },
};
</script>

<style scoped>
.interesting {
  background-color: rgba(255, 255, 255, 0.9);
  width: 100%;
  position: relative;
}
.block_title {
  font-size: 18pt;
  font-family: "Redressed", cursive;
}
.block_title {
  font-size: 16pt;
  text-align: center;
}
.block_title span::before,
.block_title span::after {
  content: "";
  display: inline-block;
  margin: 0px 10px;
  height: 1px;
  width: 200px;
  background-color: black;
  vertical-align: middle;
}
.block_posts {
  display: flex;
}
.post {
  display: flex;
  width: 25%;
  margin: 10px;
  align-items: center;
  position: relative;
  z-index: 9998;
  font-family: "Roboto Condensed", sans-serif;
}
.post-null{
  width: 100%;
  padding: 20px;
  text-align: center;
}
.post_title p {
  text-align: center;
  font-size: 12pt;
}
.post_descr {
  text-align: justify;
  margin-left: 5px;
}
.post_content button {
  background: #08b8b8;
  border: 1px solid #07a7a7;
  cursor: pointer;
  margin-left: 5px;
  margin-top: 15px;
  padding: 5px 20px;
}
.post_content button:hover {
  transition-duration: 0.3s;

  background: #0080e3;
}
.interesting:before,
.interesting:after {
  border-color: transparent;
  -webkit-transition: all 0.25s;
  transition: all 0.25s;
  border-style: solid;
  border-width: 0;
  content: "";
  height: 40px;
  position: absolute;
  width: 40px;
}
.interesting:before {
  border-color: #0080e3;
  border-right-width: 4px;
  border-top-width: 4px;
  right: -5px;
  top: -5px;
}
.interesting:after {
  border-bottom-width: 4px;
  border-color: #0080e3;
  border-left-width: 4px;
  bottom: -5px;
  left: -5px;
}
.interesting:hover:before,
.interesting.hover:before,
.interesting:hover:after,
.interesting.hover:after {
  height: 100%;
  width: 100%;
}
@media (max-width: 600px) {
  .block_title span::before,
  .block_title span::after {
    display: none;
  }
  .block_posts {
    display: flex;
    width: 100%;
    flex-direction: column;
  }
  .post {
    display: flex;
    width: 99%;
    margin: 10px;
    align-items: center;
    position: relative;
    z-index: 9999;
  }
  .interesting {
    padding-right: 20px;
  }
}
</style>