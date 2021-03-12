<template>
  <div class="home">
    <main class="home_content">
      <interesting-component />
    </main>
  </div>
</template>

<script>
import InterestingComponent from "../../components/pages/home/InterestingComponent.vue";

export default {
  name: "Home",
  components: {
    InterestingComponent,
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
  justify-content: center;
  width: 70%;
  padding-top: 7%;
}
</style>