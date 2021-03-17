<template>
  <div class="home">
    <div class="home_content">
      <interesting-component class="intresting-component" />
      <last-banners-component class="last-banners-component" />
      <news-component class="news-component" />
    </div>
  </div>
</template>

<script>
import InterestingComponent from "../../components/pages/home/InterestingComponent.vue";
import LastBannersComponent from "../../components/pages/home/LastBannersComponent.vue";
import NewsComponent from "../../components/pages/home/NewsComponent.vue";

export default {
  name: "Home",
  components: {
    InterestingComponent,
    LastBannersComponent,
    NewsComponent,
  },
};
</script>

<style scoped>
.home {
  display: flex;
  justify-content: center;
}
.home_content {
  margin: auto;
  display: flex;
  flex-direction: column;
  justify-content: center;
  width: 70%;
  padding-top: 3%;
}
.last-banners-component {
  margin-top: 50px;
}
@media (max-width: 600px) {
  .home_content {
    width: 90%;
    margin-top: 30px;
  }
}
</style>