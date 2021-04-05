<template>
  <div class="banner">
    <div class="q-pa-md row items-start q-gutter-md">
      <q-card class="my-card">
        <img :src="src + bannerImage.path" />

        <q-card-section>
          <div class="text-h6">{{ banner.title }}</div>
        </q-card-section>

        <q-card-section class="q-pt-none">
          {{ banner.description }}
        </q-card-section>
      </q-card>
    </div>
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
.banner {
  padding-top: 50px;
  width: 33%;
}
.my-card img {
  height: 256px;
}
</style>