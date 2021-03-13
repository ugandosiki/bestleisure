<template>
  <div class="home">
    <main class="home_content">
      <interesting-component  class="intresting-component"/>
      <last-banners-component class="last-banners-component"/>
      <logo-component class="logo-component"/>
    </main>
  </div>
</template>

<script>
import InterestingComponent from "../../components/pages/home/InterestingComponent.vue";
import LastBannersComponent from '../../components/pages/home/LastBannersComponent.vue';
import LogoComponent from '../../components/pages/home/LogoComponent.vue';

export default {
  name: "Home",
  components: {
    InterestingComponent, LastBannersComponent,
    LogoComponent
  },
};
</script>

<style scoped>
.home{
  display: flex;
  justify-content: center;
}
.home_content{
  margin: auto;
  display: flex;
  flex-direction: column;
  justify-content: center;
  width: 70%;
  padding-top: 3%;
}
.last-banners-component{
  margin-top: 50px;
}
@media (max-width: 600px){
  .home_content{
    width: 90%;
    margin-top: 30px;
  }
}
</style>