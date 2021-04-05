<template>
  <div class="last_banners shadow-2">
    <div class="block_title">
      <span>Последние акции</span>
    </div>
    <div class="block_banners">
      <div class="banner-null" v-if="fetchedBanners.length == 0">
        Рекомендаций для вашего города пока что нет
      </div>
      <last-banner-component
        v-else
        v-for="banner in fetchedBanners"
        :key="banner"
        :bannerData="banner"
      />
    </div>
  </div>
</template>

<script>
import LastBannerComponent from "./LastBannerComponent.vue";
export default {
  components: { LastBannerComponent },
  name: "LastBannersComponent",
  computed: {
    fetchedBanners() {
      let posts = this.$store.state.post.posts;
      let banners = [];
      posts
        .map((e) => {
          banners.push(e.banners[e.banners.length - 1]);
        })
        .splice(0, 4);
      console.log(banners);
      return banners;
    },
  },
};
</script>

<style scoped>
.last_banners {
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
.block_banners {
  display: flex;
}
.last_banners:before,
.last_banners:after {
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
.last_banners:before {
  border-color: #07a7a7;
  border-right-width: 4px;
  border-top-width: 4px;
  right: -5px;
  top: -5px;
}
.last_banners:after {
  border-bottom-width: 4px;
  border-color: #07a7a7;
  border-left-width: 4px;
  bottom: -5px;
  left: -5px;
}
.last_banners:hover:before,
.last_banners.hover:before,
.last_banners:hover:after,
.last_banners.hover:after {
  height: 100%;
  width: 100%;
}
@media (max-width: 600px) {
  .block_title span::before,
  .block_title span::after {
    display: none;
  }
  .block_banners {
    display: flex;
    width: 100%;
    flex-direction: column;
  }
  .banner {
    display: flex;
    width: 99%;
    margin: 10px;
    align-items: center;
    position: relative;
    z-index: 9999;
  }
  .last_banners {
    padding-right: 20px;
  }
}
</style>