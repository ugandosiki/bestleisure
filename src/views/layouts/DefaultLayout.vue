<template>
  <div class="main_layout">
    <nav class="desc_nav shadow-2">
      <ul>
        <router-link
          to="/home"
          tag="li"
          exact
          exact-active-class="active_r_link"
          >Главная</router-link
        >
        <router-link
          to="/catalog"
          tag="li"
          exact
          exact-active-class="active_r_link"
          >Каталог</router-link
        >
        <router-link
          to="/cabinet"
          tag="li"
          exact
          exact-active-class="active_r_link"
          >Личный кабинет</router-link
        >
        <router-link
          to="/about"
          tag="li"
          exact
          exact-active-class="active_r_link"
          >О приложении</router-link
        >
      </ul>
    </nav>
    <!-- Mobile Navigation -->
    <Slide left class="mobile_nav">
      <router-link to="/home" tag="a" exact exact-active-class="active_r_link"
        >Главная</router-link
      >
      <router-link
        to="/catalog"
        tag="a"
        exact
        exact-active-class="active_r_link"
        >Каталог</router-link
      >
      <router-link
        to="/cabinet"
        tag="a"
        exact
        exact-active-class="active_r_link"
        >Личный кабинет</router-link
      >
      <router-link to="/about" tag="a" exact exact-active-class="active_r_link"
        >О приложении</router-link
      >
    </Slide>

    <router-view/>
  </div>
</template>

<script>
import { Slide } from "vue-burger-menu";
export default {
  name: "LayoutDefault",
  components: {
    Slide,
  },
};
</script>

<style>
.mobile_nav {
  display: none;
}
.active_r_link {
  background-color: #6d8890;
}
.main_layout {
  min-height: 100vh;
  background-color: #e7ebff;
}
.desc_nav {
  background-color: #07a7a7;
  height: 60px;
  width: 40vw;
  margin: auto;
  display: flex;
  align-items: center;
}
.desc_nav ul {
  width: 100%;
  height: 100%;
  margin: 0;
  padding: 0;
  display: flex;
  align-items: center;
  flex-direction: row;
  justify-content: space-around;
  list-style-type: none;
}
.desc_nav ul li {
  cursor: pointer;
  text-align: center;
  width: 25%;
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
}
.desc_nav ul li:hover {
  background-color: #6d8890;
  transition-duration: 0.3s;
}
.desc_nav ul li {
  color: white;
  text-decoration: none;
  font-size: 14pt;
}
@media (max-width: 770px) {
  .mobile_nav {
    display: block;
  }
  .mobile_nav a {
    color: white;
  }
  .bm-burger-button {
    left: 15px;
    top: 10px;
  }
  .cross-style {
      top: 12px;
      right: 10px; 
    }
  .desc_nav {
    display: none;
  }

}
</style>
