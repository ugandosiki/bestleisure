<template>
  <div class="banner">
    <q-img :src="src + bannerImage.path" style="width: 100%; height: 256px" />
    <div class="banner-title"><strong>{{banner.title}}</strong></div>
    <div class="banner-descr">{{banner.description}}</div>
  </div>
</template>

<script>
export default {
  name: "BannerComponent",
  data() {
    return {
      src: "http://localhost:8080/uploads/",
    };
  },
  props: {
    banner: Object,
  },
  computed: {
    bannerImage() {
      let bannerImage = {};
      this.banner.images.forEach((e) => {
        if (e.path.match(/Banner/g)) {
          bannerImage = e;
        }
      });
      return bannerImage;
    },
  },
};
</script>

<style scoped>
.banner{
    padding-top: 50px;
}
.banner-title{
    font-size: 16pt;
    text-align: center;
}
</style>