<template>
  <div class="banner">
    <q-img :src="src + bannerImage.path" style="height: 140px; max-width: 100%">
      <template v-slot:loading>
        <q-spinner-gears color="white" />
      </template>
    </q-img>
    <div class="banner_content">
      <div class="banner_title">
        <p>
          <strong>{{ bannerData.title }}</strong>
        </p>
      </div>

      <div class="banner_descr">
        {{ bannerData.description.substr(0, 150).trim() + "..." }}
      </div>
    </div>
    <!-- <q-btn
      flat
      color="white"
      @click="$router.push({ name: 'banner', params: { id: bannerData.id } })"
    >
      Перейти на страницу
    </q-btn> -->
  </div>
</template>

<script>
export default {
  name: "LastBannerComponent",
  props: {
    bannerData: Object,
  },
  data() {
    return {
      src: "http://localhost:8080/uploads/",
    };
  },
  computed: {
    bannerImage() {
      let bannerImage = {};
      this.bannerData.images.forEach((e) => {
        if (e.path.match(/Banner/g)) {
          bannerImage = e;
          console.log(bannerImage);
        }
      });
      return bannerImage;
    },
  },
};
</script>

<style scoped>
.banner{
  display: flex;
  width: 25%;
  margin: 10px;
  flex-direction: column;
  position: relative;
  z-index: 9998;
  font-family: "Roboto Condensed", sans-serif;
  height: 100%;
}
.banner_content {
  height: 100%;
  width: 100%;
}
.banner_title {
  text-transform: uppercase;
  text-align: center;
}
.banner_title p {
  width: 100%;
  text-align: center;
  font-size: 12pt;
}
.banner_descr {
  text-align: justify;
  margin-left: 5px;
  height: 100%;
}
</style>