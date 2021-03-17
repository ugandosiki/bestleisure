<template>
  <div class="post shadow-2">
    <q-img
      src="data:image/jpeg;base64,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"
      style="height: 200px; max-width: 200px"
    >
      <template v-slot:loading>
        <q-spinner-gears color="white" />
      </template>
    </q-img>
    <div class="post_content">
      <div class="post_title">
        <p><strong>Lorem ipsum dolor sit.</strong></p>
      </div>
      <div class="post_descr">
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Est unde
        similique vero omnis optio ullam ea laboriosam accusamus modi eligendi.
      </div>
      <div class="post_info">
        <div class="likes">
          <q-icon :name="matThumbUp" size="18px" /><span>1</span>
        </div>
        <div class="country"><strong>Украина</strong></div>
        <div class="city"><strong>Киев</strong></div>
      </div>
      <router-link to="/about" tag="button">Перейти на страницу</router-link>
    </div>
  </div>
</template>

<script>
import { matThumbUp } from "@quasar/extras/material-icons";
export default {
  name: "PostComponent",
  data() {
    return {
      matThumbUp: null,
    };
  },
  created() {
    this.matThumbUp = matThumbUp;
  },
};
</script>

<style scoped>
.post {
  background: rgba(255, 255, 255, 0.8);
 
  display: flex;
  width: 97%;
  padding: 10px;
  margin: 10px;
  align-items: center;
  position: relative;
  z-index: 9998;
  font-family: "Roboto Condensed", sans-serif;
}
.post_title p {
  text-align: center;
  margin-bottom: 0;
  font-size: 12pt;
}
.post_descr {
  text-align: justify;
  margin-left: 5px;
}
.post_content button {
  color: white;
  background: #08b8b8;
  border: 1px solid #07a7a7;
  cursor: pointer;
  margin-left: 5px;
  margin-top: 10px;
  padding: 5px 20px;
}
.post_content button:hover {
  transition-duration: 0.3s;
  background: #0080e3;
}
.likes {
  font-size: 16pt;
  margin-left: 5px;
}
.post_info {
  display: flex;
  align-items: baseline;
}
.post_info div {
  margin-left: 10px;
}
</style>